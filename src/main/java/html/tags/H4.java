package html.tags;

public class H4 extends BlockTag {
	
	public static H4 n() {
		return new H4();
	}
	
	public H4() {
		super.name = "h4";
		super.frontTag = "<h4";
		super.rearTag = "</h4>";
	}
	
	public H4(String innerText) {
		super.name = "h4";
		super.frontTag = "<h4";
		super.rearTag = "</h4>";
		this.innerText = innerText;
	}

}
