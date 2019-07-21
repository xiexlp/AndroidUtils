package html.component;

import html.tags.BodyTag;
import html.tags.HtmlTag;

public abstract class HtmlEntity extends HtmlTag{
	
	BodyTag bodyTag;
	
	public HtmlEntity() {
		bodyTag = new BodyTag();
		this.add(bodyTag);
	}

	
	public BodyTag getBodyTag() {
		return bodyTag;
	}




	public void setBodyTag(BodyTag bodyTag) {
		this.bodyTag = bodyTag;
	}




	public abstract String render();

}
