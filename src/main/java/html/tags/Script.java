package html.tags;

public class Script extends Tag {
	
	public static Script n() {
		return new Script();
	}
	
	public Script() {
		super.name = "script";
		super.frontTag="<script";
		super.rearTag="</script>";
	}
	
	public Script setSrc(String src) {
		attrMap.put("src", src);
		return this;
	}
	
	public Script src(String src) {
		attrMap.put("src", src);
		return this;
	}
	
//	@Override
//	public String renderHtml() {
//		StringBuffer sb =new StringBuffer(getFrontTag());
//		Iterator<String> keyIt = attrMap.keySet().iterator();
//		while (keyIt.hasNext()) {
//			String key = (String) keyIt.next();
//			String value = attrMap.get(key);
//			sb.append(" ").append(key).append("=").append("\"").append(value).append("\"");
//		}
//		sb.append("/").append(getFrontClose());
//		return sb.toString();
//	}

}
