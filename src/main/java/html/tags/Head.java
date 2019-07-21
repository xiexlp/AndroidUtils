package html.tags;

public class Head extends Tag {
	
	public static Head n() {
		return new Head();
	}
	
	public Head() {
		super.name = "head";
		super.frontTag="<head";
		super.rearTag="</head>";
	}

}
