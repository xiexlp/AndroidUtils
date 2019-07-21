package html.parse;

import java.io.*;
import java.util.*;


public class HtmlLexer {


	public static final String BEGIN_OPEN_TAG="<";
	public static final String END_OPEN_TAG=">";

	public static final String BEFORE_CLOSE_TAG="</";
	public static final String END_CLOSE_TAG=">";
	public static final String END_CLOSE_HALF_TAG="/>";

	public static final String SINGLE_QUOTES="'";
	public static final String DOUBLE_QUOTES="\"";


	public static final String EQUAL_TAG="=";
	public static final String SPACE_TAG=" ";
	public static final String LINE_TAG="\n";
	public static final String UNIX_LINE_TAG="\r\n";

	public static Set<String> seperatorSet = new HashSet<String>();
	public static Set<State> stateSet= new HashSet<State>();
	
	public static List<Toke> tokeList= new ArrayList();
	
	public static LinkedList<String> charLinkedList = new LinkedList<String>();
	
	

	static{
		init();
	}

	private static void init(){
		seperatorSet.add(BEGIN_OPEN_TAG);
		seperatorSet.add(END_OPEN_TAG);
		seperatorSet.add(BEFORE_CLOSE_TAG);
		seperatorSet.add(END_CLOSE_TAG);
		seperatorSet.add(END_CLOSE_HALF_TAG);
		seperatorSet.add(SINGLE_QUOTES);
		seperatorSet.add(DOUBLE_QUOTES);
		seperatorSet.add(EQUAL_TAG);
		seperatorSet.add(SPACE_TAG);
		seperatorSet.add(LINE_TAG);
		seperatorSet.add(UNIX_LINE_TAG);
	}



	public static void main(String[] args) {

		String source = readString4("test1.html");

		System.out.println(source);

		int currentIndex=0;

		int l=source.length();

		for(int i=0;i<l;i++){
			char c= source.charAt(i);
			
			charLinkedList.add(charToString(c));
			
			System.out.println(c+":"+(int)c+":");

			//如果是开始字符则
			if(String.valueOf(c).equals(BEGIN_OPEN_TAG)){
				StringBuffer sb = new StringBuffer();
				currentIndex = i+1;
				c= source.charAt(currentIndex);
				while(isAlpha(c)){
					sb.append(c);
					currentIndex++;
					c= source.charAt(currentIndex);
				}

				System.out.println(sb.toString());

				System.out.println(String.valueOf(c));
				String cs= String.valueOf(c);
				if(isSeperators(c)){
					//如果是空格，则将上一个toke加入tokeList
					if(charToString(c).equals(" ")){
						String id= sb.toString();
						Toke toke = new Toke(id);
						toke.setBegin(currentIndex-id.length());
						toke.setEnd(currentIndex);
						toke.setLen(id.length());
						tokeList.add(toke);
					}
				}
				currentIndex++;
				c = source.charAt(currentIndex);
			}

		}


//		String s = System.getProperty("line.separator");
//		byte[] c = s.getBytes();
//		for(byte cc : c){
//		    System.out.println("0x0"+Integer.toHexString(cc));
//		}
//
//		System.out.println (Integer.toString ('\r', 16));
//		System.out.println (Integer.toHexString ('\n'));

	}


	private static String charToString(char c){
		return String.valueOf(c);
	}


	private static boolean isAlpha(char c){
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}


	private static boolean isEqualTag(char c){
		return String.valueOf(c).equals(EQUAL_TAG);
	}

	private static boolean isSingleQuote(char c){
		return String.valueOf(c).equals(SINGLE_QUOTES);
	}

	private static boolean isDoublQuote(char c){
		return String.valueOf(c).equals(DOUBLE_QUOTES);
	}

	private static boolean isSeperators(char c){
		String cc= String.valueOf(c);
		return seperatorSet.contains(cc);
	}


	public static String readString4(String filename)

    {
        int len=0;
        StringBuffer str=new StringBuffer("");
        File file=new File(filename);
        try {
            FileInputStream is=new FileInputStream(file);
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader in= new BufferedReader(isr);
            String line=null;
            while( (line=in.readLine())!=null )
            {
                if(len != 0)  // 处理换行符的问题
                {
                    str.append("\n"+line);
                }
                else
                {
                    str.append(line);
                }
                len++;
            }
            in.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str.toString();
    }


	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }



}
