package html.tags;

public class Tablehead extends BlockTag {
	
	public static Tablehead n() {
		return new Tablehead();
	}
	
	public Tablehead() {
		super.name = "thead";
		super.frontTag = "<thead";
		super.rearTag = "</thead>";
	}
	
	public Tablehead nth(Th th){
		getChildTags().add(th);
		return this;
	}
	
	public Tablehead th(Th th){
		getChildTags().add(th);
		return this;
	}

}
