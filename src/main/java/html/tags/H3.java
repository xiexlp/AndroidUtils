package html.tags;

public class H3 extends BlockTag {
	
	public static H3 n() {
		return new H3();
	}
	
	public H3() {
		super.name = "h3";
		super.frontTag = "<h3";
		super.rearTag = "</h3>";
	}
	
	public H3(String innerText) {
		super.name = "h3";
		super.frontTag = "<h3";
		super.rearTag = "</h3>";
		this.innerText = innerText;
	}

}
