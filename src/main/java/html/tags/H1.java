package html.tags;

public class H1 extends BlockTag {
	
	public static H1 g() {
		return new H1();
	}
	
	public static H1 n() {
		return new H1();
	}

	public H1() {
		super.name = "h1";
		super.frontTag = "<h1";
		super.rearTag = "</h1>";
	}
	
	public H1(String innerText) {
		super.name = "h1";
		super.frontTag = "<h1";
		super.rearTag = "</h1>";
		this.innerText = innerText;
	}
	
	public static void main(String[] args) {
		H1 h1 =new H1();
		System.out.println(h1.isBlock);
		System.out.println(h1.renderHtml());
	}

}
