package html.tags;

public class Form extends BlockTag {

	
	
	public static Form g() {
		return new Form();
	}
	
	public static Form n() {
		return new Form();
	}
	
	public Form() {
		super.name ="form";
		super.frontTag="<form";
		super.rearTag="</form>";
	}
	
	public Form action(String action){
		attrMap.put("action", action);
		return this;
	}
	
	public Form setActionUrl(String actionUrl){
		attrMap.put("action", actionUrl);
		return this;
	}
	
	public Form post(){
		attrMap.put("method", "post");
		return this;
	}
	
	
	public Form method(String method) {
		attrMap.put("method", method);
		return this;
	}
	
	public Form setMethod(String method) {
		attrMap.put("method", method);
		return this;
	}
	
	/**
	 * ���ļ��ϴ�
	 * @return
	 */
	public Form enctype() {
		attrMap.put("enctype", "multipart/form-data");
		return this;
	}
	
}
