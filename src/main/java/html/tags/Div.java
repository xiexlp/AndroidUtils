package html.tags;

public class Div extends BlockTag {
	
	public static Div g() {
		return new Div();
	}
	
	public static Div n() {
		return new Div();
	}
	
	public Div() {
		 init();
	}
	
	public Div(String innerText){
		setInnerText(innerText);
		init();
	}
	
	public Div addRowStyle() {
		classes.add("row");
		return this;
	}
	
	public Div row() {
		classes.add("row");
		return this;
	}
	
	public Div r() {
		classes.add("row");
		return this;
	}
	
	public Div aligncenter() {
		maxwidth("62.5rem").marginleft("auto").marginright("auto");
		return this;
	}
	
	private void init(){
		super.name = "div";
		super.frontTag="<div";
		super.rearTag="</div>";
		isBlock=true;
	}

}
