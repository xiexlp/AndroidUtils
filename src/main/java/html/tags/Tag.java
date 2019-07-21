package html.tags;

import java.util.*;

public class Tag {
	
	final String DISPLAY_STYLE="display";
	String name;
	String frontTag="<";
	String frontClose=">";
	String rearTag="";
	//slash is 0 represents full close,1 represents half close
	int slash=0;
	//�����ǰ��tag�Ĺ�ϵ sibling��child
	int relationPre;
	//����ں���tag�Ĺ�ϵsibling��parents
	int relationNext;
	
	boolean isBlock=false;
	
	String id;
	String csstag;
	
	String innerText;
	String innerHTML;
	
	Tag parentTag;
	List<Tag> childTags=new ArrayList<Tag>();
	List<Tag> parentList = new ArrayList<Tag>();
	
	String display;
	
	Map<String,String> attrMap=new HashMap<String, String>();
	Map<String,String> styleAttrMap=new HashMap<String, String>();
	List<String> classes = new ArrayList<String>();
	
	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	public Tag(String innerText) {
		this.innerText = innerText;
		// TODO Auto-generated constructor stub
	}
	
	public Tag setBackground(String color) {
		styleAttrMap.put("background", color);
		return this;
	}
	
	
	public Tag background(String color) {
		styleAttrMap.put("background", color);
		return this;
	}
	
	
	public Tag setBlock(){
		isBlock= true;
		return this;
	}
	
	public Tag block() {
		isBlock =true;
		attrMap.put("display", "block");
		return this;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Tag name(String name) {
		attrMap.put("name", name);
		return this;
	}
	public String getFrontTag() {
		return frontTag;
	}
	public void setFrontTag(String frontTag) {
		this.frontTag = frontTag;
	}
	public String getRearTag() {
            if(slash!=1) rearTag = "</"+name+">";
            else rearTag="/>";
            return rearTag;
	}
	public void setRearTag(String rearTag) {
		this.rearTag = rearTag;
	}
	public String getFrontClose() {
		return frontClose;
	}
	public void setFrontClose(String frontClose) {
		this.frontClose = frontClose;
	}
	public Map<String, String> getAttrMap() {
		return attrMap;
	}
	public void setAttrMap(Map<String, String> attrMap) {
		this.attrMap = attrMap;
	}
	
	public void addAttr(String key,String value) {
		attrMap.put(key, value);
	}
	
	public Tag setDisplay(String display) {
		this.display = display;
		styleAttrMap.put(DISPLAY_STYLE, display);
		return this;
	}
	
	public Tag setDisplayBlock() {
		this.display = "block";
		styleAttrMap.put(DISPLAY_STYLE, display);
		return this;
	}
	
	public Tag setDisplayInline() {
		this.display = "inline";
		styleAttrMap.put(DISPLAY_STYLE, display);
		return this;
	}
	
	public Tag setDisplayListItem() {
		this.display = "list-item";
		styleAttrMap.put(DISPLAY_STYLE, display);
		return this;
	}
	
	public Tag setDisplayRunIn() {
		this.display = "run-in";
		styleAttrMap.put(DISPLAY_STYLE, display);
		return this;
	}
	
	public Tag setDisplayCompact() {
		this.display = "compact";
		styleAttrMap.put(DISPLAY_STYLE, display);
		return this;
	}
	
	public Tag addStyle(String attr, String value){
		styleAttrMap.put(attr, value);
		return this;
	}
	
	public Tag setDisplayTable() {
		this.display = "table";
		styleAttrMap.put(DISPLAY_STYLE, display);
		return this;
	}
	
	public Tag addClass(String classTag) {
		classes.add(classTag);
		return this;
	}
	/**
	 * ������ʽ
	 * @param classTag
	 * @return
	 */
	public Tag c(String classTag) {
		classes.add(classTag);
		return this;
	}
	
	public String getAttr(String key) {
		return (String)attrMap.get(key);
	}
	
	public List<Tag> addTag(List<Tag> tagList) {
		tagList.add(this);
		return tagList;
	}
	
	public Tag add(Tag tag) {
		tag.setParentTag(this);
		getChildTags().add(tag);
		return this;
	}
	
	
	public int getRelationPre() {
		return relationPre;
	}
	public void setRelationPre(int relationPre) {
		this.relationPre = relationPre;
	}
	public int getRelationNext() {
		return relationNext;
	}
	public void setRelationNext(int relationNext) {
		this.relationNext = relationNext;
	}
	
	public Tag getParentTag() {
		return parentTag;
	}
	public void setParentTag(Tag parentTag) {
		this.parentTag = parentTag;
	}
	public List<Tag> getChildTags() {
		return childTags;
	}
	public void setChildTags(List<Tag> childTags) {
		this.childTags = childTags;
	}
	public boolean hasChild() {
		return childTags.size()>0;
	}
	
	/**
	 * �ڵڼ���λ��������tag
	 * @param tag
	 * @param index
	 */
	public void addChildIndex(Tag tag, int index) {
		tag.setParentTag(this);
		getChildTags().add(index, tag);
	}
        
        public void addChild(Tag tag) {
		tag.setParentTag(this);
		getChildTags().add(tag);
	}
	
	/**
	 * �Ƴ�tag
	 * @param index
	 */
	public void removeChildIndex(int index) {
		int size= getChildTags().size();
		if(size>=index+1){
			getChildTags().remove(index);
		}else {
			return;
		}
	}
	
	public void insertSiblingTag(Tag tag, int index) {
		tag.setParentTag(this);
		this.getParentTag().getChildTags().add(index-1, tag);
	}
	
	
	public void removeSiblingTag(int index) {
		this.getParentTag().getChildTags().remove(index-1);
	}
	
	
	public void removeSiblingTag(Tag tag) {
		this.getParentTag().getChildTags().remove(tag);
	}
	
	
	public String getCsstag() {
		int size = parentList.size();
		StringBuffer sb = new StringBuffer();
		for(int i=size-1;i>=0;i--){
			Tag tag = parentList.get(i);
			Map<String,String> attrMap = tag.getAttrMap();
			if(attrMap.containsKey("id")){
				sb.append("#").append(attrMap.get("id"));
			}else if (attrMap.containsKey("class")) {
				sb.append(".").append(attrMap.get("class"));
			}else {
				sb.append(tag.name);
			}
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public List<Tag> findParentTagList(List<Tag> parentList) {
		StringBuffer cssBuffer=new StringBuffer();
		this.parentList = parentList;
		if(parentTag!=null){
			parentList.add(parentTag);
			parentTag.findParentTagList(parentList);
		}
		return parentList;
	}
	
	/**
	 * �ݹ�ķ�������html�ļ�
	 * @return
	 */
	public String renderHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append(getFrontTag());
                sb.append(getName());
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
                        if(value!=null) sb.append(" ").append(key).append("=").append("\"").append(value).append("\"");
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
		if(slash!=1) sb.append(getFrontClose());
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
        
        public String renderHtmlSlash() {
		StringBuffer sb=new StringBuffer();
		sb.append(getFrontTag());
                sb.append(getName());
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
                        if(value!=null) sb.append(" ").append(key).append("=").append("\"").append(value).append("\"");
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
		
		//sb.append(getFrontClose());
//		if(innerHTML!=null){
//			sb.append(innerHTML);
//		}
//		if(hasChild()){
////			int size= childTags.size();
//			for(Tag childTag:childTags){
//				sb.append(childTag.renderHtml());
//			}
//		}
		//if(this.getInnerText()!=null) sb.append(this.getInnerText());
		sb.append(getRearTag());
                
                if(this.innerText!=null&&!this.innerText.equalsIgnoreCase("")){
                    sb.append(this.innerText);
                }
                
		return sb.toString();
	}
	
	public boolean equal(Tag tag) {
		boolean nameEqual= this.name.equalsIgnoreCase(tag.getName());
		if(nameEqual&&MapEqual(this.getAttrMap(),tag.getAttrMap())) return true;
		else {
			return false;
		}
	}
	
	public Tag addText(String innerText) {
		this.innerText = innerText;
		return this;
	}



	
	
	public String getInnerText() {
		return innerText;
	}
	public void setInnerText(String innerText) {
		this.innerText = innerText;
	}
	
	public Tag innerText(String innerText){
		setInnerText(innerText);
		return this;
	}
	/**
	 * �����м�����
	 * @param innerText
	 * @return
	 */
	public Tag it(String innerText){
		setInnerText(innerText);
		return this;
	}
	
	public Tag id(String id) {
		attrMap.put("id", id);
		return this;
	}
	
	public String getId() {
		return id;
	}

	public Tag setId(String id) {
		attrMap.put("id", id);
		return this;
	}

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public boolean isIsBlock() {
        return isBlock;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public List<Tag> getParentList() {
        return parentList;
    }

    public void setParentList(List<Tag> parentList) {
        this.parentList = parentList;
    }

    public String getDisplay() {
        return display;
    }

   

    public Map<String, String> getStyleAttrMap() {
        return styleAttrMap;
    }

    public void setStyleAttrMap(Map<String, String> styleAttrMap) {
        this.styleAttrMap = styleAttrMap;
    }

    public int getSlash() {
        return slash;
    }

    public void setSlash(int slash) {
        this.slash = slash;
    }
	
	

	public String getInnerHTML() {
		return innerHTML;
	}

	public void setInnerHTML(String innerHTML) {
		this.innerHTML = innerHTML;
	}

	/**
	 * �Ƚ�name������
	 * @param map1
	 * @param map2
	 * @return
	 */
	public boolean MapEqual(Map<String,String> map1,Map<String,String> map2) {
		Set<String> keySet  = map1.keySet();
		Set<String> keySet2  = map2.keySet();
//		boolean equal = true;
		Iterator<String> keyIt = keySet.iterator();
		while (keyIt.hasNext()) {
			String key1 = (String) keyIt.next();
			if(!(keySet2.contains(key1)&&map1.get(key1).equals(map2.get(key1)))) return false;
		}
		return true;
	}
	
	
	
	
	
}
