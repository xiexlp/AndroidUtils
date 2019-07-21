package html.tags;

import java.util.Iterator;
import java.util.Map;

public class Font extends Tag {
	
	public static Font g() {
		return new Font();
	}
	
	public static Font n() {
		return new Font();
	}
	
	public Font() {
		 init();
	}
	
	public Font(String innerText){
		super(innerText);
		init();
	}
	
	private void init(){
		super.name = "font";
		super.frontTag="<font";
		super.rearTag="</font>";
	}
	
	public void addColor(String value) {
		addAttr(ACONSTANT.COLOR, value);
	}
	
	public String getColor() {
		return (String)getAttr(ACONSTANT.COLOR);
	}
	
	public boolean hasColor(){
		return getAttr(ACONSTANT.COLOR)!=null;
	}
	
	public boolean hasAttr(String key){
		return getAttr(key)!=null;
	}
	

	public String wrap(String text){
		StringBuilder sb = new StringBuilder(frontTag);
		Map<String,String> map = getAttrMap();
		int size = map.size();
		Iterator<String> it=map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			sb.append(" ").append(key).append("=\"").append(value).append("\" ").append(getFrontClose()).append(text).append(getRearTag());
		}
		return sb.toString();
	}

}
