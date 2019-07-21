package html.parse;

import java.util.*;

public class TokeParser {

	
	public int currentIndex=0;
	public int len=0;
	
	public static final String BEGIN_OPEN_TAG="<";
	public static final String BEGIN_CLOSE_TAG=">";

	public static final String ENN_OPEN_TAG="</";
	public static final String END_CLOSE_TAG=">";
	public static final String END_CLOSE_HALF_TAG="/>";

	public static final String QUOTES_SINGLE="'";
	public static final String QUOTES_DOUBLE="\"";
	
	public static final String TRANS_QUATO="\\"; 
	
	public static final String SLASH="/";

	public static final String EQUAL_TAG="=";
	public static final String SPACE_TAG=" ";
	public static final String LINE_TAG="\n";
	public static final String UNIX_LINE_TAG="\r\n";
	public static final String TAB_TAG="\t";

	public static final String Exclamation_TAG="!";

	public static final int STATE_BEGIN=1;

	String[] seperateTags ={"<",">","/>","</","'","\"","/","="," ","\n","\r\n","\t","!","\\",":",";","-"};

	public  Set<String> seperatorSet = new HashSet<String>();
	public  Set<State> stateSet= new HashSet<State>();
	
	public  LinkedList<Toke> tokeList= new LinkedList();
	
	public List<Toke> thinList = new ArrayList<Toke>();
	
	public  LinkedList<String> charLinkedList = new LinkedList<String>();
	
	public String source;

	{
		//init();
		initByArray();
	}

	private  void init(){
		seperatorSet.add(BEGIN_OPEN_TAG);
		seperatorSet.add(BEGIN_CLOSE_TAG);
		
		seperatorSet.add(ENN_OPEN_TAG);
		seperatorSet.add(END_CLOSE_TAG);
		seperatorSet.add(END_CLOSE_HALF_TAG);
		
		seperatorSet.add(QUOTES_SINGLE);
		seperatorSet.add(QUOTES_DOUBLE);
		
		seperatorSet.add(TRANS_QUATO);
		seperatorSet.add(TAB_TAG);
		
		seperatorSet.add(EQUAL_TAG);
		seperatorSet.add(SPACE_TAG);
		seperatorSet.add(LINE_TAG);
		seperatorSet.add(UNIX_LINE_TAG);
		seperatorSet.add(SLASH);
		seperatorSet.add(Exclamation_TAG);
	}

	private void initByArray(){
		int len = seperateTags.length;
		for(int i=0;i<len;i++){
			seperatorSet.add(seperateTags[i]);
		}
	}
	
	
	private String next(){
		char c = source.charAt(currentIndex);
		currentIndex++;
		return String.valueOf(c);
	}
	
	private char readch(){
		System.out.println("currentIndex:"+currentIndex);
		char c = source.charAt(currentIndex);
		
		charLinkedList.add(String.valueOf(c));
		
		currentIndex++;
		return c;
	}
	
	private String charToString(char c){
		return String.valueOf(c);
	}
	
	
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
	
	
	private String getQuoteContent(){
		System.out.println("----getword----");
		//String lastc=charLinkedList.pollLast();
		StringBuffer sb = new StringBuffer();
		//sb.append(lastc);
		char c = readch();
		while(!isQuoteDouble(c)){
			sb.append(c);
			c=readch();
		}
		//最后一个回溯一下
		//if(!isSpace(c)) currentIndex--;
		System.out.println("word:"+sb.toString());
		return sb.toString();
		
	}
	
	
	private boolean isQuoteDouble(char c){
		return String.valueOf(c).equals(QUOTES_DOUBLE);
	}
	
	private void skip(){
		currentIndex++;
	}
	
	private  boolean isSeperators(char c){
		String cc= String.valueOf(c);
		System.out.println(cc);
		boolean isSeperator= seperatorSet.contains(cc);
		System.out.println("isSeperator:"+isSeperator);
		return isSeperator;
	}
	
	
	private  boolean isSeperatorsNotQuote(char c){
		String cc= String.valueOf(c);
		System.out.println(cc);
		seperatorSet.remove(QUOTES_DOUBLE);
		boolean isSeperator= seperatorSet.contains(cc);
		seperatorSet.add(QUOTES_DOUBLE);
		System.out.println("isSeperator:"+isSeperator);
		return isSeperator;
	}
	
	public void parser(){
		if(source==null) return;
		//开始设为零
		currentIndex=0;
		len = source.length();
		System.out.println("len:"+len);
		
		for(int i=0;i<len;i++){
			char c= readch();
			if(Character.isWhitespace(c)) System.out.print("@");
			else System.out.print("---"+charToString(c)+"|||");
		}
		
		currentIndex=0;
		for(int i=0;i<len;i++){
			if(currentIndex>=len) break;
			char c= readch();
			//System.out.println("char:"+charToString(c));
			//charLinkedList.add(charToString(c));
			//如果是空格读过去
//			while(isSpace(c)){
//				c= readch();
//			}
			if(isSeperators(c)){
				while(Character.isWhitespace(c)){
					//最后多读了一个
					c=readch();
				}
				if(isAlpha(c)){
					currentIndex--;
				}else if(isQuoteDouble(c)){
					tokeList.add(getQuoteToke());
				}
				else if (isSeperatorsNotQuote(c)) {
					tokeList.add(getTokeSep(c));
				}
			}else if (Character.isLetter(c)) {
				tokeList.add(getTokeWord());//回溯
			}
		}
	}
	
	
	private Toke getTokeSep(char c){
		Toke toke = new Toke(c);
		toke.setBegin(currentIndex);
		toke.setType(Toke.TYPE_SEP);
		return toke;
	}
	
	private Toke getTokeWord(){
		int begin= currentIndex;
		String id=getWord();
		Toke toke = new Toke(id);
		toke.setBegin(begin);
		toke.setLen(id.length());
		toke.setEnd(begin+len);
		toke.setType(Toke.TYPE_ID);
		return toke;
	}
	
	private Toke getQuoteToke(){
		//currentIndex++;
		int begin = currentIndex;
		String id= getQuoteContent();
		Toke toke = new Toke(id);
		toke.setBegin(begin);
		toke.setLen(id.length());
		toke.setEnd(begin+len);
		toke.setType(Toke.TYPE_QUOTECONTENT);
		return toke;
	}
	
	
	public static void main(String[] args) {
		String fileName = "test1.html";

		//String fileName = "E:\\mobile\\backbone\\hellobackbone\\hello.html";

		String source = HtmlLexer.readString4(fileName);
		
		TokeParser tokeParser = new TokeParser();
		tokeParser.setSource(source);
		//解析
		tokeParser.parser();
		
		//解析出来的结果
		List<Toke> tokes = tokeParser.getTokeList();
		System.out.println("-----toke-----");
		for(Toke t:tokes){
			System.out.println("toke:"+t.getId());
		}
		
		System.out.println("---------------------------------------------------");
		
//		tokeParser.thinTokeList();
//		List<Toke> thinTokes = tokeParser.getThinList();
//		
//		for(Toke t:thinTokes){
//			System.out.println("toke:"+t.getId());
//		}
	}
	
	//将tokeList精简
	public void thinTokeList(){
		Stack<Toke> stack = new Stack<Toke>();
		
		//LinkedList<Toke> tLinkedList = new LinkedList<Toke>();
		//将最小引号中的内容合并
		int len = tokeList.size();
		List<Integer> quoteIndexList= new ArrayList<Integer>();
		List<Integer> beginQuoteIndexList= new ArrayList<Integer>();
		
		
		//先找到每个引号的位置
		for(int i=0;i<len;i++){
			//tLinkedList.add(e)
			Toke t= tokeList.get(i);
			Toke t1 = t;
			if(t.getId().equals("\"")){
				int index = i;
				quoteIndexList.add(index);
			}
		}
		
		System.out.println("size:"+quoteIndexList.size());
		for(Integer i:quoteIndexList){
			System.out.println("postion:"+i);
		}
		
		int positionLen = quoteIndexList.size();
		
		//找到引号对的开始和结束位置
		List<Pair> pairs = new ArrayList<Pair>();
		Map<Integer,Integer> beginEndMap= new HashMap<Integer, Integer>();
		
		for(int i=0;i<positionLen;i=i+2){
			if(isEven(i)){
				Pair pair = new Pair();
				pair.setBegin(quoteIndexList.get(i));
				beginQuoteIndexList.add(i);
				pair.setEnd(quoteIndexList.get(i+1));
				beginEndMap.put(pair.getBegin(),pair.getEnd());
				pairs.add(pair);
			}
		}

		for(int i=0;i<len;i++){
			if(beginQuoteIndexList.contains(i)){
				String id= source.substring(i+1, beginEndMap.get(i)-1);
				Toke toke = new Toke(id);
				toke.setBegin(i+1);
				toke.setLen(id.length());
				toke.setEnd(beginEndMap.get(i)-1);
			}
		}
	}
	
	
		private  boolean isEven(int num){
	        if(num%2==0){
	            return true;
	        }else{
	            return false;
	        }
	    }
	
	
	private static boolean isAlpha(char c){
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}
	
	
	private boolean isSpace(char c) {
		return Character.isSpaceChar(c);
	}


	public int getCurrentIndex() {
		return currentIndex;
	}


	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}


	public Set<String> getSeperatorSet() {
		return seperatorSet;
	}


	public void setSeperatorSet(Set<String> seperatorSet) {
		this.seperatorSet = seperatorSet;
	}


	public Set<State> getStateSet() {
		return stateSet;
	}


	public void setStateSet(Set<State> stateSet) {
		this.stateSet = stateSet;
	}


	public LinkedList<Toke> getTokeList() {
		return tokeList;
	}


	public void setTokeList(LinkedList<Toke> tokeList) {
		this.tokeList = tokeList;
	}


	public LinkedList<String> getCharLinkedList() {
		return charLinkedList;
	}


	public void setCharLinkedList(LinkedList<String> charLinkedList) {
		this.charLinkedList = charLinkedList;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public List<Toke> getThinList() {
		return thinList;
	}


	public void setThinList(List<Toke> thinList) {
		this.thinList = thinList;
	}
	
	
	
	
}
