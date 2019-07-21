package html.tags;

public class Javascript extends Script {
	
	public static Javascript n() {
		return new Javascript();
	}
	
	public Javascript() {
		super();
	}
	
	public Javascript setType() {
		attrMap.put("type", "text/javascript");
		return this;
	}

}
