package html.template;

import html.util.FileUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Administrator on 2017-3-12.
 */
public class StokenParser {

    String source;


    String htmlSource;


    LinkedList<String> charLinkedList= new LinkedList<>();
    LinkedList<Token> tokenLinkedList = new LinkedList<>();

    String[] keywords ={"var","if","for","else",""};
    String[] seperates={"{","}",";","\n","\r","\r\n","(",")","\"","="," ",">","<","+","-","*","/"};

    String[] operators = {"+","-","*","/","++","--",">=","<="};

    Set<String> keywordSet = new HashSet<>();
    Set<String> seperatorSet = new HashSet<>();
    Set<String> operatorSet = new HashSet<>();


    {
        init();
    }

    private void init(){

        int keylen = keywords.length;

        for(int i=0;i<keylen;i++){
            String keyword = keywords[i];
            keywordSet.add(keyword);
        }

        int seplen=seperates.length;

        for(int i=0;i<seplen;i++){
            seperatorSet.add(seperates[i]);
        }

        int oplen = operators.length;
        for(int i=0;i<oplen;i++){
            operatorSet.add(operators[i]);
        }

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static void main1(String[] args) {

        //String filename = "test.html";

        String jsfile = "a.s";
        String source = FileUtil.readString4(jsfile);

        StokenParser stokenParser = new StokenParser();
        stokenParser.setSource(source);

        stokenParser.parseRaw();
        LinkedList<Token> tokens = stokenParser.tokenLinkedList;
        System.out.println("----tokens----");
        for(Token t:tokens){
            System.out.println(t.getValue());
        }

    }


    public static void main(String[] args) {

        String jsfile = "test.html";
        String source = FileUtil.readString4(jsfile);

        System.out.println("source len:"+source.length());

        StokenParser stokenParser = new StokenParser();
        stokenParser.setSource(source);

        stokenParser.parseBlock();
        LinkedList<BlockPair> blockCodePairs = stokenParser.blockPairLinkedList;
        System.out.println("block size:"+blockCodePairs.size());
        System.out.println("----blocks----");

        StringBuffer pureSource = new StringBuffer();

        for(BlockPair t:blockCodePairs){
            System.out.println("content:"+t.getContent());
            if(t.getBlocktype()==BlockPair.TYPE_HTML){
                StringBuffer sentence = new StringBuffer("printHtml(").append("\"").append(t.getContent()).append("\");\n");
                pureSource.append(sentence.toString());
            }else if(t.getBlocktype()==BlockPair.TYPE_CODE){
                pureSource.append(t.getContent());
            }
        }

        System.out.println("puresource:\n"+pureSource.toString());



        //词法分析器
        StokenParser stokenParser1 = new StokenParser();
        stokenParser1.setSource(pureSource.toString());

        stokenParser1.parseRaw();
        LinkedList<Token> tokens = stokenParser1.tokenLinkedList;
        System.out.println("----tokens----");
        for(Token t:tokens){
            System.out.println(t.getValue());
        }



    }

    int currentIndex=0;

    int len;
    int state=0;
    int line =1;


    //parse raw source code
    public void parseRaw(){
        int i=0;
        len = source.length();

        Character ch=null;

        //一个循环搞定
        outFor:for(i=0;i<len;i++){
            ch = readch();
            //get last,so break
                if(ch==null) {
                    break;
                }
                if(isAlpha(ch)){
                    String word = getWord();
                    Token token =null;
                    if(keywordSet.contains(word)){
                        token = new Token(line);
                        token.setValue(word);
                        token.setType(Token.TYPE_KEY);
                        if(token!=null) tokenLinkedList.add(token);
                    }else if(word!=null){
                        //id token
                        Token token1 = new Token(line);
                        token1.setValue(word);
                        token1.setType(Token.TYPE_ID);
                        tokenLinkedList.add(token1);
                    }
                    //continue read
                    //ch=readch();
                    //
                }else if(Character.isDigit(ch)){
                    String numberstr = getNumber();
                    Token token = new Token(line);
                    token.setValue(numberstr);
                    token.setType(Token.TYPE_NUM);
                    tokenLinkedList.add(token);
                }else if(isSeperators(ch)) {
                    if (spaceChar(ch)) {
                        System.out.println("encouter a space ");
                        continue outFor;
                    }else {
                        String c =String.valueOf(ch);
                        if(c.equals(">")||c.equals("<")){
                            Character cc = readch();
                            String concat = c.toString()+cc.toString();
                            if(operatorSet.contains(concat)){
                                String op2 = c.toString()+cc.toString();
                                Token token = new Token(line);
                                token.setValue(op2);
                                token.setType(Token.TYPE_OP);
                                tokenLinkedList.add(token);
                            }else {
                                Token token = new Token(line);
                                token.setValue(c.toString());
                                token.setType(Token.TYPE_OP);

                                tokenLinkedList.add(token);
                                //回一下
                                unreadch();
                            }
                        }else if(c.equals("(")||c.equals(")")){
                            Token token = new Token(line);
                            token.setValue(c.toString());
                            token.setType(Token.TYPE_PARRENT);
                            tokenLinkedList.add(token);
                        }else if(c.equals("{")||c.equals("}")){
                            Token token = new Token(line);
                            token.setValue(c.toString());
                            token.setType(Token.TYPE_BLOCK);
                            tokenLinkedList.add(token);
                        }else if(c.equals(Token.QUOTA)){
                            String str = getStr();
                            Token token = new Token(line);
                            token.setValue(str);
                            token.setType(Token.TYPE_STR);
                            tokenLinkedList.add(token);
                        }else if(c.equals(Token.EQUAL)){
                            Token token = new Token(line);
                            token.setValue(c.toString());
                            token.setType(Token.TYPE_OP);
                            tokenLinkedList.add(token);
                        }
                    }
                }
        }
    }

    private boolean isAlpha(char c){
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }


    //得到引号里面的内容
    private String getStr(){
        StringBuffer sb = new StringBuffer();
        Character ch = readch();
        while (!ch.toString().equals(Token.QUOTA)){
            sb.append(ch);
            ch= readch();
        }
        //unreadch();
        return sb.toString();
    }


    //得到单词
    private String getWord(){
        System.out.println("----getword----");
        String lastc=charLinkedList.pollLast();
        StringBuffer sb = new StringBuffer();
        sb.append(lastc);
        char c = readch();
        while(!isSeperators(c)){
            sb.append(c);
            c=readch();
        }
        //最后一个回溯一下
        if(!isSpace(c)) currentIndex--;
        System.out.println("word:"+sb.toString());
        return sb.toString();
    }

    private boolean isLineChangeCharacter(char c){
        String ch =String.valueOf(c);
        if(ch.equals("\n")){
            //line++;
            return true;
        }else if(ch.equals("\r")){
            char nextch = getchar();
            if(String.valueOf(nextch).equals("\n")){
                //line++;
                return true;
            }else {
                //回溯一下
                //currentIndex--;
                return false;
            }
        }
        return false;
    }

    private String getNumber(){
        System.out.println("----getnumber----");
        String lastc=charLinkedList.pollLast();
        StringBuffer sb = new StringBuffer();
        sb.append(lastc);
        char c = readch();
        while(Character.isDigit(c)){
            sb.append(c);
            c=readch();
        }
        //最后一个回溯一下
        if(!isSpace(c)) currentIndex--;
        System.out.println("word:"+sb.toString());
        return sb.toString();
    }

    private boolean isSpace(char c) {
        return Character.isSpaceChar(c);
    }

    private boolean spaceChar(char c){
        String v =String.valueOf(c);
        if(v.equals(" ")||v.equals("\t")){
            return true;
        }else return false;
    }


    private  boolean isSeperators(char c){
        String cc= String.valueOf(c);
        System.out.println("current char:"+cc);
        boolean isSeperator= seperatorSet.contains(cc);
        System.out.println("isSeperator:"+isSeperator);
        return isSeperator;
    }

    public String getHtmlSource() {
        return htmlSource;
    }

    public void setHtmlSource(String htmlSource) {
        this.htmlSource = htmlSource;
    }


    int lastHtmlBeginIndex=0;
    int lastHtmlEndIndex=0;
    int lastCodeBeginIndex=-1;
    int lastCodeEndIndex=-1;

    LinkedList<BlockPair> blockPairLinkedList = new LinkedList<>();
    int htmlBlockIndex=0;
    int blockIndex=0;

    int lastSBlockBeginIndex=-1;

    int phaseState;

    //对html里面的block进行解析
    public void parseBlock(){
        int i=0;

        phaseState = Stat.HTMLBLOCK_BEGIN;
        lastHtmlBeginIndex=0;

        len = source.length();
        Character ch=null;


        LinkedList<String> msgLinkedList= new LinkedList<>();


        outFor:for(i=0;i<=len;i++){
            ch = readch();
            System.out.println(ch);
            //最后的处理
            if(phaseState==Stat.HTMLBLOCK_BEGIN&&ch==null) {
                HtmlBlockPair htmlBlockPair = new HtmlBlockPair();
                htmlBlockPair.setBegin(lastHtmlBeginIndex);
                htmlBlockPair.setEnd(currentIndex);
                htmlBlockPair.setIndex(blockIndex);

                String blockContent1 = source.substring(lastHtmlBeginIndex,currentIndex);
                htmlBlockPair.setContent(blockContent1);

                blockPairLinkedList.add(htmlBlockPair);
                return;
            }
            else if(phaseState==Stat.HTMLBLOCK_BEGIN&&ch.toString().equals("<")){
                 String thisword = getNcharAppend(ch,4);
                 if(thisword==null) return;
                System.out.println("thisword:"+thisword);
                 //String concat = ch+next4;
                //code block begin
                 if(thisword.equals("<!--{")){
                     //html block end,create a new html block pair
                     HtmlBlockPair htmlBlockPair = new HtmlBlockPair();
                     htmlBlockPair.setBegin(lastHtmlBeginIndex);
                     htmlBlockPair.setEnd(currentIndex-1);
                     //first
                     htmlBlockPair.setIndex(blockIndex);

                     String blockContent = source.substring(lastHtmlBeginIndex,currentIndex-1);
                     htmlBlockPair.setContent(blockContent);

                     blockPairLinkedList.add(htmlBlockPair);

                     blockIndex++;


                     currentIndex=currentIndex+4;
                     phaseState =Stat.CODE_BEGIN;

                     lastCodeBeginIndex = currentIndex;
                     continue outFor;
                 }else {
                     continue outFor;
                 }
            }else if(phaseState==Stat.CODE_BEGIN&&ch.toString().equals("}")){
                String endword= getNcharAppend(ch,3);
                System.out.println("endword:"+endword);
                if(endword.equals("}-->")){
                    currentIndex=currentIndex+3;

                    BlockCodePair blockCodePair = new BlockCodePair();
                    blockCodePair.setBegin(lastCodeBeginIndex);
                    blockCodePair.setEnd(currentIndex-1);
                    blockCodePair.setIndex(blockIndex);

                    String blockCodeContent = source.substring(lastCodeBeginIndex,currentIndex-4);

                    blockCodePair.setContent(blockCodeContent);

                    blockIndex++;

                    blockPairLinkedList.add(blockCodePair);

                    phaseState=Stat.HTMLBLOCK_BEGIN;
                    lastHtmlBeginIndex = currentIndex;
                    continue outFor;

                }else {
                    continue outFor;
                }
            }else continue outFor;
        }
    }



    //parse html
    public void parse(){
        int i=0;
        len = source.length();

        Character ch=null;

        //一个循环搞定
        outFor:for(i=0;i<len;i++){
            ch = readch();
            //get last,so break
            if(ch==null) {
                break;
            }
            if(isAlpha(ch)){
                String word = getWord();
                Token token =null;
                if(keywordSet.contains(word)){
                    token = new Token(line);
                    token.setValue(word);
                    token.setType(Token.TYPE_KEY);
                    if(token!=null) tokenLinkedList.add(token);
                }else if(word!=null){
                    //id token
                    Token token1 = new Token(line);
                    token1.setValue(word);
                    token1.setType(Token.TYPE_ID);
                    tokenLinkedList.add(token1);
                }
                //continue read
                //ch=readch();
                //
            }else if(Character.isDigit(ch)){
                String numberstr = getNumber();
                Token token = new Token(line);
                token.setValue(numberstr);
                token.setType(Token.TYPE_NUM);
                tokenLinkedList.add(token);
            }else if(isSeperators(ch)) {
                if (spaceChar(ch)) {
                    System.out.println("encouter a space ");
                    continue outFor;
                }else {
                    String c =String.valueOf(ch);
                    if(c.equals(">")||c.equals("<")){
                        Character cc = readch();
                        String concat = c.toString()+cc.toString();
                        if(operatorSet.contains(concat)){
                            String op2 = c.toString()+cc.toString();
                            Token token = new Token(line);
                            token.setValue(op2);
                            token.setType(Token.TYPE_OP);
                            tokenLinkedList.add(token);
                        }else {
                            Token token = new Token(line);
                            token.setValue(c.toString());
                            token.setType(Token.TYPE_OP);

                            tokenLinkedList.add(token);
                            //回一下
                            unreadch();
                        }
                    }else if(c.equals("(")||c.equals(")")){
                        Token token = new Token(line);
                        token.setValue(c.toString());
                        token.setType(Token.TYPE_PARRENT);
                        tokenLinkedList.add(token);
                    }else if(c.equals("{")||c.equals("}")){
                        Token token = new Token(line);
                        token.setValue(c.toString());
                        token.setType(Token.TYPE_BLOCK);
                        tokenLinkedList.add(token);
                    }else if(c.equals(Token.QUOTA)){
                        String str = getStr();
                        Token token = new Token(line);
                        token.setValue(str);
                        token.setType(Token.TYPE_STR);
                        tokenLinkedList.add(token);
                    }else if(c.equals(Token.EQUAL)){
                        Token token = new Token(line);
                        token.setValue(c.toString());
                        token.setType(Token.TYPE_OP);
                        tokenLinkedList.add(token);
                    }
                }
            }
        }
    }

    //回一步
    private void unreadch(){
        currentIndex--;
    }

    private Character readch(){

        if(currentIndex>=len) return null;

        System.out.println("currentIndex:"+currentIndex);
        char c = source.charAt(currentIndex);

        //if(isLineChangeCharacter(c))
        if(isLineChangeCharacter(c)) line++;
        charLinkedList.add(String.valueOf(c));
        currentIndex++;
        return c;
    }

    //don't change index
    private Character getchar(){
        if(currentIndex>=len) return null;

        System.out.println("currentIndex:"+currentIndex);
        char c = source.charAt(currentIndex);

        //if(isLineChangeCharacter(c))

        //charLinkedList.add(String.valueOf(c));

        //currentIndex++;
        return c;
    }

    //read next n char,don't change index
    private String getNchar(int n){

        StringBuffer sb= new StringBuffer();
        for(int i=0;i<n;i++) {
            if (currentIndex >= len) return null;

            System.out.println("currentIndex:" + currentIndex);
            char c = source.charAt(currentIndex);

        }
        //if(isLineChangeCharacter(c))

        //charLinkedList.add(String.valueOf(c));

        //currentIndex++;
        return sb.toString();
    }

    //read next n char,don't change index
    private String getNcharAppend(Character thischar,int n){
        StringBuffer sb= new StringBuffer(thischar.toString());
        for(int i=0;i<n;i++) {
            if (currentIndex+i >= len) break;
            System.out.println("currentIndex:" + currentIndex);
            char c = source.charAt(currentIndex+i);
            sb.append(c);
        }
        //if(isLineChangeCharacter(c))

        //charLinkedList.add(String.valueOf(c));

        //currentIndex++;
        return sb.toString();
    }

    //read next n chars
    private String readnch(int n){
        StringBuffer sb = new StringBuffer();
        //sb.append(charLinkedList.getLast());
        for(int i=0;i<n;i++){
            sb.append(readch());
        }
        return sb.toString();
        //sb.append(readch();
    }


    private String appendNextNch(int n){
        StringBuffer sb = new StringBuffer();
        sb.append(charLinkedList.getLast());
        for(int i=0;i<n;i++){
            sb.append(readch());
        }
        return sb.toString();
    }

    private String readNextNch(int n){
        StringBuffer sb = new StringBuffer();
        //sb.append(charLinkedList.getLast());
        for(int i=0;i<n;i++){
            sb.append(readch());
        }
        return sb.toString();

    }


    public LinkedList<Token> getTokenLinkedList() {
        return tokenLinkedList;
    }

    public void setTokenLinkedList(LinkedList<Token> tokenLinkedList) {
        this.tokenLinkedList = tokenLinkedList;
    }
}
