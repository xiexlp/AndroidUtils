package html.tags;

import java.util.Iterator;

public class Hr extends BlockTag {
	
	public static Hr n() {
		return new Hr();
	}
	
	public Hr() {
		super.name = "hr";
		super.frontTag = "<hr";
		super.rearTag = "</hr>";
	}
	
	@Override
	public String renderHtml() {
		StringBuffer sb =new StringBuffer();
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
