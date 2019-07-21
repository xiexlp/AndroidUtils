package html.tags;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Select extends BlockTag {
	
//	List<Option> options = new ArrayList<Option>();
	 
	public Select() {
		super.name="select";
		super.frontTag="<select";
		super.rearTag="</select>";
	}
	
	public Select setOptions(Map map) {
		Set keySet=map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			Option option = new Option();
			option.setValue(key);
			option.setLabel((String)map.get(key));
			getChildTags().add(option);
		}
		return this;
	}
	
	public Select addOption(Option option) {
		getChildTags().add(option);
		return this;
	}
	
	public Select add(Option option) {
		getChildTags().add(option);
		return this;
	}

}


