package html.tags;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Style extends Tag{
	
	Map<String,String> cssMap =new HashMap<String, String>();
	
	public Style() {
		super.name="style";
		super.frontTag="<style";
		super.rearTag="</style>";
	}
	
	@Override
	public String renderHtml() {
		StringBuffer sb = new StringBuffer(getFrontTag());
		sb.append(getFrontClose());
		Iterator<String> it= styleAttrMap.keySet().iterator();
		while (it.hasNext()) {
			String tagKey = (String) it.next();
			sb.append(tagKey);sb.append("{");sb.append((String)styleAttrMap.get(tagKey)).append(";}\n");
		}
		sb.append(getRearTag());
		return sb.toString();
	}

}
