package html.tags;

public class Option extends Tag {

	String value;
	String label;
	
	public Option() {
		super.name="option";
		super.frontTag="<option";
		super.rearTag="</option>";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
}
