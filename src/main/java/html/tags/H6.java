package html.tags;

public class H6 extends BlockTag{
	
	public static H6 n() {
		return new H6();
	}
	
	public H6() {
		super.name = "h6";
		super.frontTag = "<h6";
		super.rearTag = "</h6>";
	}
	
	public H6(String innerText) {
		super.name = "h6";
		super.frontTag = "<h6";
		super.rearTag = "</h6>";
		this.innerText = innerText;
	}

}
