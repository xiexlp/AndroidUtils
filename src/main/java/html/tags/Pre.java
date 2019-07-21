package html.tags;

public class Pre extends BlockTag{
	
	public static Pre n() {
		return new Pre();
	}
	
	public Pre() {
		super.name = "pre";
		super.frontTag = "<pre";
		super.rearTag = "</pre>";
	}

}
