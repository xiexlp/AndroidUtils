package html.tags;

public class Td extends Tag {
	
	public static Td n() {
		return new Td();
	}

	public Td() {
		super.name = "td";
		super.frontTag = "<td";
		super.rearTag = "</td>";
	}
	
	public Td(String innerText) {
		super.name = "td";
		super.frontTag = "<td";
		super.rearTag = "</td>";
		this.innerText = innerText;
	}
	
	public Td(Integer innerText){
		super.name = "td";
		super.frontTag = "<td";
		super.rearTag = "</td>";
		this.innerText = Integer.toString(innerText);
	}
	
	public Td colspan(String num) {
		attrMap.put("colspan", num);
		return this;
	}
}
