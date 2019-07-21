package html.tags;

public class Tr extends Tag {
	
	public static Tr n() {
		return new Tr();
	}
	
	public Tr() {
		super.name = "tr";
		super.frontTag = "<tr";
		super.rearTag = "</tr>";
	}
	
	public Tr nTd(Td td) {
		add(td);
		return this;
	}
	
	public Tr td(Td td) {
		add(td);
		return this;
	}

}
