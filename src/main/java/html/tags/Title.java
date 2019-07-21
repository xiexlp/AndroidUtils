package html.tags;


public class Title extends Tag {
	
	public static Title n() {
		return new Title();
	}
	
	public Title() {
		super.name = "title";
		super.frontTag = "<title";
		super.rearTag = "</title>";
	}
	
	public Title(String innerText) {
		super.name = "title";
		super.frontTag = "<title";
		super.rearTag = "</title>";
		this.innerText = innerText;
	}
	
	public static void main(String[] args) {
		Title title =new Title("aaa");
		System.out.println(title.renderHtml());
	}

}
