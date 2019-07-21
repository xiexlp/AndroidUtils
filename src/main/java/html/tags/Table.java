package html.tags;

public class Table extends BlockTag {
	
	public static Table n() {
		return new Table();
	}
	
	public Table() {
		super.name = "table";
		super.frontTag = "<table";
		super.rearTag = "</table>";
	}
	
	
	public Table border(String bordattr) {
		addAttr("border", bordattr);
		return this;
	}
	
	public Table nthead(Tablehead thread) {
		getChildTags().add(thread);
		return this;
	}
	
	public Table thead(Tablehead thread) {
		getChildTags().add(thread);
		return this;
	}
	
	public Table aTr(Tr tr){
		getChildTags().add(tr);
		return this;
	}
	
	public Table tr(Tr tr){
		getChildTags().add(tr);
		return this;
	}

}
