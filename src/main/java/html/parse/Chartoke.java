package html.parse;

public class Chartoke {
	
	public static final int TYPE_SEP=1;
	public static final int TYPE_OP=2;
	public static final int TYPE_CHAR=3;
	public static final int TYPE_BEGIN_BEGINTAG=4;
	public static final int TYPE_END_BEGINTAG=5;
	public static final int TYPE_BEGIN_ENDTAG=6;
	public static final int TYPE_END_ENDTAG=7;
	
	
	public String id;
	public int index;
	public int type;
	
	public Chartoke(char c){
		this.id=String.valueOf(c);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
