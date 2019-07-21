package html.tags;

public class Dir extends BlockTag {
	
	public static Dir g() {
		return new Dir();
	}
	
	public static Dir n() {
		return new Dir();
	}
	
	public Dir() {
		super.name = "dir";
		super.frontTag = "<dir";
		super.rearTag = "</dir>";
	}

}
