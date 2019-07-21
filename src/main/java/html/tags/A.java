package html.tags;

public class A extends BlockTag {
	
	public static A g() {
		return new A();
	}
	
	public static A n() {
		return new A();
	}
	
	String href="#";
	
	public A() {
		super.name = "a";
		super.frontTag = "<a";
		super.rearTag = "</a>";
		attrMap.put("href", "#");
	}
	
	public A(String innerText) {
		super.name = "a";
		super.frontTag = "<a";
		super.rearTag = "</a>";
		attrMap.put("href", "#");
		this.innerText = innerText;
	}
	
	public A(Integer innerText) {
		super.name = "a";
		super.frontTag = "<a";
		super.rearTag = "</a>";
		attrMap.put("href", "#");
		this.innerText = Integer.toString(innerText);
	}
	
	public A href(String href) {
		attrMap.put("href", href);
		return this;
	}
	
	public A setHref(String href) {
		return href(href);
	}
}
