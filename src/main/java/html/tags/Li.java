package html.tags;

public class Li extends BlockTag {
	
	public static Li n() {
		return new Li();
	}
	
	public Li() {
		super.name = "li";
		super.frontTag = "<li";
		super.rearTag = "</li>";
	}
	
	public Li(String innerText) {
		super.name = "li";
		super.frontTag = "<li";
		super.rearTag = "</li>";
		this.innerText = innerText;
	}

}
