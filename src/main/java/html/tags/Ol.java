package html.tags;

public class Ol extends BlockTag {
	
	public static Ol n() {
		return new Ol();
	}
	
	public Ol() {
		super.name = "ol";
		super.frontTag = "<ol";
		super.rearTag = "</ol>";
	}

}
