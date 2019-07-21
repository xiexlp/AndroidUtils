package html.tags;

public class Center extends BlockTag {
	
	public static Center g() {
		return new Center();
	}
	
	public static Center n() {
		return new Center();
	}
	
	public Center() {
		super.name = "center";
		super.frontTag = "<center";
		super.rearTag = "</center>";
	}

}
