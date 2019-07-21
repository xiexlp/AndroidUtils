package com.js.android.quick.html;

/***
 * it is a file scan result
 * @author Administrator
 *
 */

public class FileScan {
	
	
	//文件内容
	private String content;
	
	//源文件的行数
	private int lineOriginal;
	
	//字符串内容的行数，增加文件名等内容
	private int line;
	
	//分区的指标
	private int basicIndex;
	
	//在分区内的指标
	private int partIndex;
	
	
	private int totalIndex;
	
	//basic total
	private int fromLine;
	
	
	private int endLine;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLineOriginal() {
		return lineOriginal;
	}
	public void setLineOriginal(int lineOriginal) {
		this.lineOriginal = lineOriginal;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getBasicIndex() {
		return basicIndex;
	}
	public void setBasicIndex(int basicIndex) {
		this.basicIndex = basicIndex;
	}
	public int getPartIndex() {
		return partIndex;
	}
	public void setPartIndex(int partIndex) {
		this.partIndex = partIndex;
	}
	public int getFromLine() {
		return fromLine;
	}
	public void setFromLine(int fromLine) {
		this.fromLine = fromLine;
	}
	public int getEndLine() {
		return endLine;
	}
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}
	public int getTotalIndex() {
		return totalIndex;
	}
	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
