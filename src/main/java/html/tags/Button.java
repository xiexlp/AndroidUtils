package html.tags;

public class Button extends Tag {
	
	public static Button g() {
		return new Button();
	}
	
	public static Button n() {
		return new Button();
	}
	
	public Button() {
		super.name = "button";
		super.frontTag = "<button";
		super.rearTag = "</button>";
	}
	
	public Button submit() {
		attrMap.put("type", "submit");
		return this;
	}
	
	public Button reset() {
		attrMap.put("type", "reset");
		return this;
	}
	
	public Button(String innerText) {
		super.name = "button";
		super.frontTag = "<button";
		super.rearTag = "</button>";
		this.innerText = innerText;
	}

}
