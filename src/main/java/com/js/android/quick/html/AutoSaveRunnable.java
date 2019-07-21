package com.js.android.quick.html;


import com.js.android.quick.swing.lab.RichTabbedPane;

public class AutoSaveRunnable implements Runnable{
	
	
	private RichTabbedPane tabbedPane;
	private String path;
	
	
	public AutoSaveRunnable(RichTabbedPane tabbedPane,String path) {
		this.tabbedPane = tabbedPane;
		this.path = path;
		// TODO Auto-generated constructor stub
	}
	
	
	public AutoSaveRunnable(RichTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		//this.path = path;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void run() {
		
		//每秒钟刷新一次
		
		
		// TODO Auto-generated method stub
		
	}

}
