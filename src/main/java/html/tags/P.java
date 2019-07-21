package html.tags;

public class P extends BlockTag {
	
	public static P n() {
		return new P();
	}
	
	public P() {
		super.name = "p";
		super.frontTag = "<p";
		super.rearTag = "</p>";
	}
	
	public P(String innerText) {
		this.innerText = innerText;
	}

}
