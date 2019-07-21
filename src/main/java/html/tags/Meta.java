package html.tags;

import java.util.Iterator;

public class Meta extends Tag {
	
	public static Meta n() {
		return new Meta();
	}
	
	public Meta() {
		super.name = "meta";
		super.frontTag="<meta";
		super.rearTag="</meta>";
	}
	
	public Meta setCharSet(String charSet) {
		attrMap.put("charSet", charSet);
		return this;
	}
	
	public Meta setCharSetUtf8() {
		attrMap.put("charSet", "utf-8");
		return this;
	}
	
	
	public Meta setAName(String name) {
		attrMap.put("name", name);
		return this;
	}
	
	public Meta setViewPort(String contetn) {
		attrMap.put("name", "viewport");
		attrMap.put("content", contetn);
		return this;
	}
	
	public Meta name(String name) {
		attrMap.put("name", name);
		return this;
	}
	
	public Meta setContent(String content) {
		attrMap.put("content", content);
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
