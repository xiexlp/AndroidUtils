package html.tags;

public class Address extends BlockTag{
	
	public static Address g() {
		return new Address();
	}
	
	public static Address n() {
		return new Address();
	}

	public Address() {
		super.name = "address";
		super.frontTag = "<address";
		super.rearTag = "</address>";
	}
	
}
