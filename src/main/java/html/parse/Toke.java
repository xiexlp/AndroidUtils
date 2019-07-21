package html.parse;


public class Toke{
	
	
	public final static int TYPE_ID=1;
	public final static int TYPE_SEP=2;
	public final static int TYPE_QUOTECONTENT=3;
	//public final static int TYPE_ID=1;
	//public final static int TYPE_ID=1;
	
	
	public String name;
	public String id;
	public int begin;
	public int end;
	public int len;
	
	//tag operator seperator
	public int type;
	
	
	public Toke(String id){
		this.id = id;
	}
	
	public Toke(char id){
		this.id = String.valueOf(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
	
}