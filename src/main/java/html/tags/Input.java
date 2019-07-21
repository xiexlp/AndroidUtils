package html.tags;

import java.util.Iterator;

public class Input extends BlockTag {
	
	public Input() {
		super.name = "input";
		super.frontTag="<input";
		super.rearTag="</input>";
	}
	
	public Input name(String name) {
		attrMap.put("name", name);
		return this;
	}
	
	public Input setType(String type){
		attrMap.put("type", type);
		return this;
	}
	
	public Input type(String type){
		attrMap.put("type", type);
		return this;
	}
	
	public Input hide() {
		attrMap.put("type", "hidden");
		return this;
	}
	
	public Input file() {
		attrMap.put("type", "file");
		return this;
	}
	
	public Input value(String value) {
		return setValue(value);
	}
	
	public Input setValue(String value){
		attrMap.put("value", value);
		return this;
	}
	
	public Input setSize(String size){
		styleAttrMap.put("size", size);
		return this;
	}
	
	public Input setHeight(String height){
		styleAttrMap.put("height", height);
		return this;
	}
	
	public Input setWidth(String width){
		styleAttrMap.put("width", width);
		return this;
	}
	
	@Override
	public String renderHtml() {
		StringBuffer sb =new StringBuffer(getFrontTag());
		Iterator<String> keyIt = attrMap.keySet().iterator();
		while (keyIt.hasNext()) {
			String key = (String) keyIt.next();
			String value = attrMap.get(key);
			sb.append(" ").append(key).append("=").append("\"").append(value).append("\"");
		}
		sb.append("/").append(getFrontClose());
		return sb.toString();
	}
}
