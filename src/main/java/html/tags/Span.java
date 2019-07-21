package html.tags;

public class Span extends Tag {
	
	public static Span n() {
		return new Span();
	}
	
	public Span() {
		super.name = "span";
		super.frontTag = "<span";
		super.rearTag = "</span>";
	}
	
	public Span(String innerText) {
		super.name = "span";
		super.frontTag = "<span";
		super.rearTag = "</span>";
		this.innerText = innerText;
	}

}
