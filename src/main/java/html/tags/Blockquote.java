package html.tags;

public class Blockquote extends BlockTag {
	
	public static Blockquote g() {
		return new Blockquote();
	}
	
	public static Blockquote n() {
		return new Blockquote();
	}
	
	public Blockquote() {
		super.name = "blockquote";
		super.frontTag = "<blockquote";
		super.rearTag = "</blockquote>";
	}

}
