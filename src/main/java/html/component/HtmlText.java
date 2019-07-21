package html.component;

import html.attr.Color;
import html.tags.Font;

public class HtmlText extends HtmlEntity {
	
//	private String innerText;
	private Font fontTag;
	
	public HtmlText(String text) {
		fontTag = new Font(text);
		getBodyTag().add(fontTag);
	}
	
	public HtmlText(String text,String color){
		fontTag = new Font(text);
		getBodyTag().add(fontTag);
		fontTag.addColor(color);
	}

	@Override
	public String render() {
		return renderHtml();
	}
	
	public Font getFontTag() {
		return fontTag;
	}

	public void setFontTag(Font fontTag) {
		this.fontTag = fontTag;
	}
	
	public static void main(String[] args) {
		HtmlText htmlText = new HtmlText("���", Color.RED);
		String xx=htmlText.render();
		System.out.println(xx);
	}

	public static void test(String[] args) {
		HtmlText htmlText = new HtmlText("haha");
		htmlText.getFontTag().addColor("red");
		String xx=htmlText.render();
		System.out.println(xx);
	}

}
