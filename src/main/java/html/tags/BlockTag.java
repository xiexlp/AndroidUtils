package html.tags;

import java.util.Iterator;
import java.util.Set;


public class BlockTag extends Tag {
	
	public static BlockTag g() {
		return new BlockTag();
	}
	
	public static BlockTag n() {
		return new BlockTag();
	}
	
	final static String MARGINTOP="margin-top";
	final static String MARGINLEFT="margin-left";
	final static String MARGINBOTTOM="margin-bottom";
	final static String MARGINRIGHT="margin-right";
	
	final static String PADDINGTOP="padding-top";
	final static String PADDINGLEFT="padding-left";
	final static String PADDINGBOTTOM="padding-bottom";
	final static String PADDINGRIGHT="padding-right";
	
	final static String FLOAT="float";
	final static String CLEAR="clear";
	
	int marginTop=0;
	int marginLeft=0;
	int marginBottom=0;
	int marginRight=0;
	
	int width=0;
	int height=0;
	
	int paddingTop=0;
	int paddingLeft=0;
	int paddingBottom=0;
	int paddingRight=0;
	
	String floatDirection;
	String clearDirection;
	
	public void setMargin(String marginTop,String marginLeft,String marginBottom,String marginRight){
		styleAttrMap.put(MARGINTOP, marginTop);
		styleAttrMap.put(MARGINLEFT, marginLeft);
		styleAttrMap.put(MARGINBOTTOM,marginBottom);
		styleAttrMap.put(MARGINRIGHT,marginRight);
	}
	
	public void setMarginInt(int marginTop,int marginLeft,int marginBottom,int marginRight){
		this.marginTop =marginTop;
		this.marginLeft=marginLeft;
		this.marginBottom=marginBottom;
		this.marginRight=marginRight;
		styleAttrMap.put(MARGINTOP, Integer.toString(marginTop)+"px");
		styleAttrMap.put(MARGINLEFT, Integer.toString(marginLeft)+"px");
		styleAttrMap.put(MARGINBOTTOM, Integer.toString(marginBottom)+"px");
		styleAttrMap.put(MARGINRIGHT, Integer.toString(marginRight)+"px");
	}
	
	public BlockTag row() {
		classes.add("row");
		return this;
	}
	
	public BlockTag r() {
		classes.add("row");
		return this;
	}
	
	public BlockTag aligncenter() {
		maxwidth("62.5rem").marginleft("auto").marginright("auto");
		return this;
	}
	
	public BlockTag center() {
		marginleft("auto").marginright("auto");
		return this;
	}
	
	public BlockTag setFloat(String direction) {
		floatDirection=direction;
		styleAttrMap.put(FLOAT, direction);
		return this;
	}
	
	public BlockTag setFloatLeft() {
		floatDirection="left";
		styleAttrMap.put(FLOAT, floatDirection);
		return this;
	}
	
	public BlockTag setFloatRight() {
		floatDirection="right";
		styleAttrMap.put(FLOAT, floatDirection);
		return this;
	}
	
	public BlockTag setFloatNone() {
		floatDirection="none";
		styleAttrMap.put(FLOAT, floatDirection);
		return this;
	}
	
	public BlockTag setFloatInherit() {
		floatDirection="inherit";
		styleAttrMap.put(FLOAT, floatDirection);
		return this;
	}
	
	
	public String getMarginTop() {
		return styleAttrMap.get(MARGINTOP);
	}

	public BlockTag setMarginTop(String marginTop) {
		styleAttrMap.put(MARGINTOP, marginTop);
		return this;
	}
	
	public BlockTag margintop(String marginTop) {
		styleAttrMap.put(MARGINTOP, marginTop);
		return this;
	}

	public String getMarginLeft() {
		return styleAttrMap.get(MARGINLEFT);
	}

	public BlockTag setMarginLeft(String marginLeft) {
		styleAttrMap.put(MARGINLEFT, marginLeft);
		return this;
	}

	public BlockTag marginleft(String marginLeft) {
		styleAttrMap.put(MARGINLEFT, marginLeft);
		return this;
	}


	public String getMarginBottom() {
		return styleAttrMap.get(MARGINBOTTOM);
	}



	public BlockTag setMarginBottom(String marginBottom) {
		styleAttrMap.put(MARGINBOTTOM, marginBottom);
		return this;
	}

	public BlockTag marginbottom(String marginBottom) {
		styleAttrMap.put(MARGINBOTTOM, marginBottom);
		return this;
	}

	public String getMarginRight() {
		return styleAttrMap.get(MARGINRIGHT);
	}


	public BlockTag setMarginRight(String marginRight) {
		styleAttrMap.put(MARGINRIGHT, marginRight);
		return this;
	}
	
	public BlockTag marginright(String marginRight) {
		styleAttrMap.put(MARGINRIGHT, marginRight);
		return this;
	}
	
	public BlockTag setClear(String clear) {
		this.clearDirection = clear;
		styleAttrMap.put("clear", clear);
		return this;
	}
	
	public BlockTag clear(String clear) {
		this.clearDirection = clear;
		styleAttrMap.put("clear", clear);
		return this;
	}

	public BlockTag setClearLeft() {
		this.clearDirection = "left";
		styleAttrMap.put("clear", "left");
		return this;
	}
	
	public BlockTag clearleft() {
		this.clearDirection = "left";
		styleAttrMap.put("clear", "left");
		return this;
	}
	
	public BlockTag setClearRight() {
		this.clearDirection = "right";
		styleAttrMap.put("clear", "right");
		return this;
	}
	
	public BlockTag clearRight() {
		this.clearDirection = "right";
		styleAttrMap.put("clear", "right");
		return this;
	}
	
	public BlockTag setClearBoth() {
		this.clearDirection = "both";
		styleAttrMap.put("clear", "both");
		return this;
	}
	
	public BlockTag clearboth() {
		this.clearDirection = "both";
		styleAttrMap.put("clear", "both");
		return this;
	}

	public boolean isBlock() {
		return true;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}
	
	
	public BlockTag width(String width){
		styleAttrMap.put("width", width);
		return this;
	}
	
	public BlockTag maxwidth(String maxwidth){
		styleAttrMap.put("max-width", maxwidth);
		return this;
	}
	
	public BlockTag postion(String position) {
		styleAttrMap.put("position", position);
		return this;
	}
	
	public BlockTag top(String top) {
		styleAttrMap.put("top", top);
		return this;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getPaddingTop() {
		return styleAttrMap.get(PADDINGTOP);
	}


	public BlockTag setPaddingTop(String paddingTop) {
		styleAttrMap.put(PADDINGTOP, paddingTop);
		return this;
	}


	public String getPaddingLeft() {
		return styleAttrMap.get(PADDINGLEFT);
	}


	public BlockTag setPaddingLeft(String paddingLeft) {
		styleAttrMap.put(PADDINGLEFT, paddingLeft);
		return this;
	}


	public String getPaddingBottom() {
		return styleAttrMap.get(PADDINGBOTTOM);
	}


	public BlockTag setPaddingBottom(String paddingBottom) {
		styleAttrMap.put(PADDINGBOTTOM, paddingBottom);
		return this;
	}


	public String getPaddingRight() {
		return styleAttrMap.get(PADDINGRIGHT);
	}


	public BlockTag setPaddingRight(String paddingRight) {
		styleAttrMap.put(PADDINGRIGHT, paddingRight);
		return this;
	}
	
	@Override
	public String renderHtml() {
		StringBuffer sb=new StringBuffer(getFrontTag());
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
		if(hasChild()){
//			int size= childTags.size();
			for(Tag childTag:childTags){
				sb.append(childTag.renderHtml());
			}
		}
		if(this.getInnerText()!=null) sb.append(this.getInnerText());
		sb.append(getRearTag());
		//�����blockԪ��,�����ӻ���
		if(isBlock){	
			sb.append("\n");
		}
		return sb.toString();
	}
	

}
