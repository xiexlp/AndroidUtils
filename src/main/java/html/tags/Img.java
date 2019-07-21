package html.tags;

import java.util.Iterator;

public class Img extends Tag {
	
	public static Img g() {
		return new Img();
	}
	
	public static Img n() {
		return new Img();
	}
	
	public Img() {
		super.name = "img";
		super.frontTag = "<img";
		super.rearTag = "</img>";
	}
	
	public Img src(String src) {
		attrMap.put("src", src);
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
