package com.js.android.quick.html;

import javax.swing.tree.DefaultMutableTreeNode;

public class FileNode extends DefaultMutableTreeNode{
	
	String absolutePath;
	String name;
	
	String fileSimpleName;
	
	boolean hasChild;
	boolean isLeaf;
	
	public FileNode(String name){
		this.name =name;
	}
	
	
	public FileNode(String name,boolean isLeaf){
		this.name =name;
		this.isLeaf = isLeaf;
	}
	
	
	public FileNode(String name,String absolutePath){
		this.name =name;
		this.absolutePath = absolutePath;
	}
	
	
	public FileNode(String name,String absolutePath,boolean isLeaf){
		this.name =name;
		this.absolutePath = absolutePath;
		this.isLeaf = isLeaf;
	}

	
	
	
	
	public String getAbsolutePath() {
		return absolutePath;
	}


	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public boolean isLeaf() {
		return isLeaf;
	}


	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public String toString(){
		return this.name;
	}


	public String getFileSimpleName() {
		return fileSimpleName;
	}


	public void setFileSimpleName(String fileSimpleName) {
		this.fileSimpleName = fileSimpleName;
	}
	
	
	
	
	

}
