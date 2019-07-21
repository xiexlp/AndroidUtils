package com.js.android.quick.html;

//import org.beetl.sql.core.annotatoin.AssignID;
//import org.beetl.sql.core.db.TableDesc;

public class HtmlSource {
	
	private String id;
	private String template;
	private int line = 0;
	//private TableDesc tableDesc;
	//数据库插入用
	//private Map<String,AssignID> assignIds;
	private int idType;
	
	public HtmlSource() {
	}

	public HtmlSource(String id, String template) {
		this.id = id;
		this.template = template;
	}

	public HtmlSource(String template) {

		this.template = template;
	}
	
	


	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	


	
}
