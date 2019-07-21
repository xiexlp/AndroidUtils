package html.parse;

import html.tags.Tag;

public class Tagex extends Tag {

	public Tagex(){
		
	}

	//key id-beginIndex
	public String key;

	
	public int openBeginTokeIndex=-1;
	
	public int openEndIndex=-1;
	
	public int closeBeginIndex=-1;
	
	public int closeEndIndex=-1;


	public int getOpenBeginTokeIndex() {
		return openBeginTokeIndex;
	}

	public void setOpenBeginTokeIndex(int openBeginTokeIndex) {
		this.openBeginTokeIndex = openBeginTokeIndex;
	}

	public int getOpenEndIndex() {
		return openEndIndex;
	}

	public void setOpenEndIndex(int openEndIndex) {
		this.openEndIndex = openEndIndex;
	}

	public int getCloseBeginIndex() {
		return closeBeginIndex;
	}

	public void setCloseBeginIndex(int closeBeginIndex) {
		this.closeBeginIndex = closeBeginIndex;
	}

	public int getCloseEndIndex() {
		return closeEndIndex;
	}

	public void setCloseEndIndex(int closeEndIndex) {
		this.closeEndIndex = closeEndIndex;
	}


	public void buildKey(){
		String key1 = this.getName()+"-"+this.getOpenBeginTokeIndex();
		setKey(key1);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
