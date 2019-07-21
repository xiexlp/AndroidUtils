package html.tags;

public class TextArea extends BlockTag {
	
	public TextArea() {
		// TODO Auto-generated constructor stub
		super.name ="textarea";
		super.frontTag="<textarea";
		super.rearTag="</textarea>";
	}
	
	public TextArea value(String value) {
		return setValue(value);
	}
	
	public TextArea setValue(String value){
		attrMap.put("value", value);
		return this;
	}
	
	public TextArea setSize(String size){
		styleAttrMap.put("size", size);
		return this;
	}
	
	public TextArea setHeight(String height){
		styleAttrMap.put("height", height);
		return this;
	}
	
	public TextArea setWidth(String width){
		styleAttrMap.put("width", width);
		return this;
	}
	
}
