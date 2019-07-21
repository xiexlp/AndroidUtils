package html.tags;

import java.util.Iterator;

public class Link extends Tag {
	
	public static Link n() {
		return new Link();
	}
	
	public Link() {
		super.name = "link";
		super.frontTag="<link";
		super.rearTag="</link>";
	}
	
	public Link setRelSheet(String src) {
		attrMap.put("rel", "Stylesheet");
		attrMap.put("type", "text/css");
		attrMap.put("href", src);
		return this;
	}
	
	public Link relSheet(String src) {
		attrMap.put("rel", "Stylesheet");
		attrMap.put("type", "text/css");
		attrMap.put("href", src);
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
