package html.tags;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HtmlTag extends Tag {
	
	public static HtmlTag n() {
		return new HtmlTag();
	}
	
	
	Map<String,String> styleMap = new HashMap<String, String>();
	
	public HtmlTag() {
		 super.name = "html";
		 super.frontTag="<html";
		 super.rearTag="</html>";
	}
	
	public HtmlTag addStyle(String key, String value) {
		styleMap.put(key, value);
		return this;
	}
	
	public HtmlTag removeStyle(String key) {
		styleMap.remove(key);
		return this;
	}
	
	public String renderHtml() {
		StringBuffer sb=new StringBuffer("<!DOCTYPE html>\n");
		sb.append(getFrontTag());
//		int size = attrMap.size();
//		if(size>0) sb.append(" ");
		
		//class
		int classNum = classes.size();
		StringBuffer classSb=new StringBuffer();
		if(classNum>=1){
			for(String clas:classes){
				classSb.append(clas).append(" ");
			}
			String clasz = classSb.substring(0, classSb.length()-1);
			sb.append(" ").append("class=").append("\"").append(clasz).append("\"");
		}
		//���Բ���
		Iterator<String> keyIt = attrMap.keySet().iterator();
		while (keyIt.hasNext()) {
			String key = (String) keyIt.next();
			String value = attrMap.get(key);
			sb.append(" ").append(key).append("=").append("\"").append(value).append("\"");
		}
		//css style����
		int styleSize=styleAttrMap.size();
		if(styleSize>=1){
			sb.append(" ").append("style=\"");
			Set<String> keys = styleAttrMap.keySet();
			for(String key:keys){
//				System.out.println(key);
				sb.append(key).append(":").append((String)styleAttrMap.get(key)).append(";");
			}
			sb.append("\"");
		}
		
		sb.append(getFrontClose());
		if(innerHTML!=null){
			sb.append(innerHTML);
		}
		if(hasChild()){
//			int size= childTags.size();
			for(Tag childTag:childTags){
				sb.append(childTag.renderHtml());
			}
		}
		if(this.getInnerText()!=null) sb.append(this.getInnerText());
		sb.append(getRearTag());
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		HtmlTag htmlTag = new HtmlTag();
		System.out.println("tag:"+htmlTag.getName());
		BodyTag bodyTag = new BodyTag();
		Font fontTag=new Font("���");
		fontTag.addColor("red");
		
		htmlTag.add(bodyTag);
		bodyTag.add(fontTag);
		
		String renderHtml= htmlTag.renderHtml();
		System.out.println(renderHtml);
	}
	
	
	
}
