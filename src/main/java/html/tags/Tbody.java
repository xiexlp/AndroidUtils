package html.tags;

public class Tbody extends BlockTag{
	
	public static Tbody n() {
		return new Tbody();
	}
	
	public Tbody() {
		super.name = "tbody";
		super.frontTag = "<tbody";
		super.rearTag = "</tbody>";
	}

}
