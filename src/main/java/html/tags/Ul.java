package html.tags;

public class Ul extends BlockTag{
	
	public static Ul n() {
		return new Ul();
	}
	
	public Ul() {
		super.name = "ul";
		super.frontTag = "<ul";
		super.rearTag = "</ul>";
	}
}
