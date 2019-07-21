package html.tags;

public class Th extends Tag {
	
	public static Th n() {
		return new Th();
	}
	
	public Th() {
		super.name = "th";
		super.frontTag = "<th";
		super.rearTag = "</th>";
	}
	
	public Th(String innerText) {
		super.name = "th";
		super.frontTag = "<th";
		super.rearTag = "</th>";
		this.innerText = innerText;
	}

}
