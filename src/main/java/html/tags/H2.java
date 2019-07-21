package html.tags;

public class H2 extends BlockTag {
	
	public static H2 g() {
		return new H2();
	}
	
	public static H2 n() {
		return new H2();
	}

	public H2() {
		super.name = "h2";
		super.frontTag = "<h2";
		super.rearTag = "</h2>";
	}
	
	public H2(String innerText) {
		super.name = "h2";
		super.frontTag = "<h2";
		super.rearTag = "</h2>";
		this.innerText = innerText;
	}

}
