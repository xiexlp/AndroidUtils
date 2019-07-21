package html.tags;

public class BodyTag extends Tag {
	
	public static BodyTag g() {
		return new BodyTag();
	}
	
	public static BodyTag n() {
		return new BodyTag();
	}
	
	
	public BodyTag() {
		 init();
	}
	
	public BodyTag(String innerText){
		super(innerText);
		init();
	}
	
	private void init(){
		super.name = "body";
		 super.frontTag="<body";
		 super.rearTag="</body>";
	}

}
