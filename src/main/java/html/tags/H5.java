package html.tags;

public class H5 extends BlockTag {
	
	public static H5 n() {
		return new H5();
	}
	
	public H5() {
		super.name = "h5";
		super.frontTag = "<h5";
		super.rearTag = "</h5>";
	}
	
	public H5(String innerText) {
		super.name = "h5";
		super.frontTag = "<h5";
		super.rearTag = "</h5>";
		this.innerText = innerText;
	}

}
