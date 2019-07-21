package com.js.android.quick.html;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.util.LinkedList;


public class BootstrapSplit extends JFrame implements ActionListener {

	JMenuBar menuBar;
	
	JToolBar toolBar; 
	JButton cutButton;
	JButton copyButton;
	JButton pasteButton;
	JButton clearButton;
	
	JCheckBox appendOrNewCheckBox;
	
	BootstrapTemplate btt;

	JSplitPane mainSplitPane;
	
	JTabbedPane contentTab;
	JScrollPane contentScrollPane;
	JTextArea contentTextArea;
	

	JScrollPane treeJScrollPane;
	JTree tree;
	
	
	String[] menuTags={"Bootstrap基本组件","Bootstrap表单组件","Bootstrap菜单组件","Bootstrap组件","javascript组件"};
	String[] menuNick={"basic基本组件","form表单组件","nav菜单组件","component组件","javascript"};

	public BootstrapSplit() {
		
		btt= new BootstrapTemplate();
		
		// BootstrapUtil.init();
		initMenu();
		setJMenuBar(menuBar);
		initToolBar();
		initTree();
		initTab();
		
		initMainSplit();
		
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		getContentPane().add(mainSplitPane, BorderLayout.CENTER);
		//getContentPane().add(contentTab,BorderLayout.CENTER);
	}
	
	private void initMainSplit(){
		mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeJScrollPane, contentTab);
		//设置分隔条的大小
		mainSplitPane.setDividerSize(5);
		//是否可以收起来
		mainSplitPane.setOneTouchExpandable(true);
	}
	
	
	private void initToolBar(){
		toolBar= new JToolBar();
		
		cutButton = new JButton("剪切");
		copyButton = new JButton("复制");
		pasteButton = new JButton("粘贴");
		clearButton = new JButton("清空");
		
		toolBar.add(cutButton);
		toolBar.add(copyButton);
		toolBar.add(pasteButton);
		toolBar.addSeparator();

		ToolbarButtonActionListener toolbarButtonActionListener = new ToolbarButtonActionListener();
		cutButton.addActionListener(toolbarButtonActionListener);
		copyButton.addActionListener(toolbarButtonActionListener);
		pasteButton.addActionListener(toolbarButtonActionListener);
		clearButton.addActionListener(toolbarButtonActionListener);

		appendOrNewCheckBox = new JCheckBox("添加或替换");
		appendOrNewCheckBox.setSelected(true);;
		toolBar.add(appendOrNewCheckBox);
		
		toolBar.add(clearButton);
	}
	
	/**
	 * 数的构造
	 */
	private void initTree(){
		// 创建没有父节点和子节点、但允许有子节点的树节点，并使用指定的用户对象对它进行初始化。
        // public DefaultMutableTreeNode(Object userObject)
       
		//DefaultMutableTreeNode top = getTreeRoot();
		
		TreeNode top = treeData();
		
        tree = new JTree(top);
		
		treeJScrollPane = new JScrollPane(tree);
		treeJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		treeJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//tree = new JTree();
		
		SizeComponentListener sizeComponentListener = new SizeComponentListener();
		
		tree.addComponentListener(sizeComponentListener);
		
		
		TreeMouseListener treeMouseListener = new TreeMouseListener();
		tree.addMouseListener(treeMouseListener);
		
		
		TreeSelectChangeListener treeSelectChangeListener = new TreeSelectChangeListener();
		
		tree.addTreeSelectionListener(treeSelectChangeListener);
		
		
	}
	
	
	private TreeNode treeData(){
		 TreeNode top = new TreeNode();
		 top.setName("bootstrap");
		 
		 TreeNode node1 = new TreeNode();
	     node1.setName(menuTags[0]);
	     node1.setNickName(menuNick[0]);
	     LinkedList<String> items= btt.getControlLayoutList();
	     System.out.println("boot list size:"+items.size());
	     for(String item:items){
	    	 TreeNode nodeItem = new TreeNode();
	    	 nodeItem.setName(item);
	    	 nodeItem.setNickName(item);
	    	 node1.add(nodeItem);
	     }
	     
	     System.out.println("node1 child count:"+node1.getChildCount());
	     top.add(node1);
	     
	     
	     TreeNode node2 = new TreeNode();
	     node2.setName(menuTags[1]);
	     node2.setNickName(menuNick[1]);
	     items= btt.getActivityFragmentList();
	     for(String item:items){
	    	 TreeNode nodeItem = new TreeNode();
	    	 nodeItem.setName(item);
	    	 nodeItem.setNickName(item);
	    	 node2.add(nodeItem);
	     }
	    
	     top.add(node2);
	     TreeNode node3 = new TreeNode();
	     node3.setName(menuTags[2]);
	     node3.setNickName(menuNick[2]);
	     items= btt.getControlAdapterList();
	     for(String item:items){
	    	 TreeNode nodeItem = new TreeNode();
	    	 nodeItem.setName(item);
	    	 nodeItem.setNickName(item);
	    	 node3.add(nodeItem);
	     }
	     top.add(node3);
	     
	     
	     TreeNode node4 = new TreeNode();
	     node4.setName(menuTags[3]);
	     node4.setNickName(menuNick[3]);
	     items= btt.getCommonToolsList();
	     for(String item:items){
	    	 TreeNode nodeItem = new TreeNode();
	    	 nodeItem.setName(item);
	    	 nodeItem.setNickName(item);
	    	 node4.add(nodeItem);
	     }
	     top.add(node4);
	     
	     TreeNode node5 = new TreeNode();
	     node5.setName(menuTags[4]);
	     node5.setNickName(menuNick[4]);
	     items= btt.getCustomizationList();
	     for(String item:items){
	    	 TreeNode nodeItem = new TreeNode();
	    	 nodeItem.setName(item);
	    	 nodeItem.setNickName(item);
	    	 node5.add(nodeItem);
	     }
	     top.add(node5);
	     
		 
		 return top;
	}
	
	private DefaultMutableTreeNode getTreeRoot(){
		 DefaultMutableTreeNode group1 = new DefaultMutableTreeNode("软件部");

	        TreeNode node1 = new TreeNode();
	        node1.setName("王雨");
	        node1.setNickName("漫天飞舞");
	        group1.add(new DefaultMutableTreeNode(node1));

	        TreeNode node2 = new TreeNode();
	        node2.setName("陈梦");
	        node2.setNickName("梦");
	        group1.add(new DefaultMutableTreeNode(node2));

	        TreeNode node3 = new TreeNode();
	        node3.setName("上官飞儿");
	        node3.setNickName("飞儿");
	        group1.add(new DefaultMutableTreeNode(node3));

	        DefaultMutableTreeNode group2 = new DefaultMutableTreeNode("销售部");

	        TreeNode node4 = new TreeNode();
	        node4.setName("上官婉儿");
	        node4.setNickName("婉儿");
	        group2.add(new DefaultMutableTreeNode(node4));

	        TreeNode node5 = new TreeNode();
	        node5.setName("上官巧儿");
	        node5.setNickName("巧儿");
	        group2.add(new DefaultMutableTreeNode(node5));


	        DefaultMutableTreeNode top = new DefaultMutableTreeNode("职员管理");

	        top.add(group1);
	        top.add(group2);
	        return top;
	}
	
	
	private void initTab(){
		contentTab = new JTabbedPane();
		contentTextArea = new JTextArea();
		contentScrollPane  =new JScrollPane(contentTextArea);
		//contentTab.add(contentTextArea);
		contentTab.add("文件", contentScrollPane);
	}
	
	
	private class ToolbarButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        
        	Object o = e.getSource();
        	if(o==cutButton){
        		onCut();
        	}else if (o==copyButton) {
				onCopy();
			}else if(o==pasteButton){
				onPaste();
			}else if (o==clearButton) {
				onClear();
			}
        	
            //System.out.println("你按了按钮一");     
        }     
    }  
	
	
	private class TreeMouseListener extends MouseAdapter{
		
		public void mouseClicked(java.awt.event.MouseEvent evt) {
            
			if(evt.getClickCount()==2){
				System.out.println("双击树");
				//DefaultMutableTreeNode node =(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				TreeNode node =(TreeNode)tree.getLastSelectedPathComponent();
				
				
				System.out.println("双击的节点:"+node.toString()+"--"+node.getPath()+" 名称:"+node.getName());
				
				if(node.isLeaf()){
					commandAction(node.getName());
				}
			}else {
				//System.out.println("单击树");
			}
			
        }
		
	}
	
	private class TreeSelectChangeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println("选择事件改变");
			
			
			
		}
	}
	
	
	private class SizeComponentListener implements ComponentListener{

		@Override
		public void componentHidden(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("resize");
			
		}

		@Override
		public void componentShown(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	private void onCopy(){
		System.out.println("copybutton");
		String selectTxt = contentTextArea.getSelectedText();
		ClipboradOperate.setToClipboardText(selectTxt);
	}
	
	private void onPaste(){
		System.out.println("pastebutton");
		String clipStr="";
		try {
			clipStr = ClipboradOperate.getClipboardText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int caret = contentTextArea.getCaretPosition();
		contentTextArea.insert(clipStr, caret);
	}
	private void onClear(){
		System.out.println("clearbutton");
		contentTextArea.setText("");
	}
	
	
	private void onCut(){
		System.out.println("cutbuton");
		
		int start = contentTextArea.getSelectionStart();
		int end = contentTextArea.getSelectionEnd();
		String selectTxt = contentTextArea.getSelectedText();
		
		
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//获取系统剪贴板
		ClipboradOperate.setClipboardText(clip, selectTxt);
		
		
		String originTxt  = contentTextArea.getText();
		String front=originTxt.substring(0, start);
		String forward = originTxt.substring(end);
		
		
		StringBuffer sb = new StringBuffer(front).append(forward);
		contentTextArea.setText(sb.toString());
	}
	
	
	
	
	

	/**
	 * 
	 * init menu
	 */
	private void initMenu() {
		
		menuBar = new JMenuBar();

		JMenu sysMenu = new JMenu("系统");
		
		
		
		
		
		
		JMenu bootstrapMenu = new JMenu(menuTags[0]);
		JMenu formMenu = new JMenu(menuTags[1]);
		JMenu navMenu = new JMenu(menuTags[2]);
		JMenu componentMenu = new JMenu(menuTags[3]);
		JMenu javascriptMenu = new JMenu(menuTags[4]);
		
	
		

		initMenuItem(bootstrapMenu, btt.getControlLayoutList());
		initMenuItem(formMenu, btt.getActivityFragmentList());
		initMenuItem(navMenu, btt.getControlAdapterList());
		initMenuItem(componentMenu, btt.getCommonToolsList());
		initMenuItem(javascriptMenu, btt.getCustomizationList());

		menuBar.add(bootstrapMenu);
		menuBar.add(formMenu);
		menuBar.add(navMenu);
		menuBar.add(componentMenu);
		menuBar.add(javascriptMenu);
	}

	private void initMenuItem(JMenu menu, LinkedList<String> list) {
		// 初始化基本组件
		// LinkedList<String> list = btt.getBootstrapList();
		System.out.println("list size:" + list.size());

		for (String key : list) {
			System.out.println("key.." + key);
			JMenuItem menuItem = new JMenuItem(key);
			menuItem.addActionListener(this);
			menu.add(menuItem);
		}
	}

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				BootstrapSplit auto = new BootstrapSplit();
				//Dimension dimension = new Dimension(800, 800);
				
				Dimension dimension = ScreenUtils.screenDimension();
				
				Point point = LocationUtils.getLocationPointTopAjust(dimension,
						0);
				auto.setSize(dimension);
				auto.setLocation(point);
				// auto.setLocation(300, 100);
				auto.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		commandAction(command);
	}
	
	
	private void commandAction(String command){
		System.out.println("command:" + command);
		String sql = btt.getBootstrapTemplate(command);
		
		
		//是替换还是增加
		boolean appendOrNew = appendOrNewCheckBox.isSelected();

		if(appendOrNew){
			appendContentStr(sql);
		}else {
			setContentStr(sql);
		}
	}
	
	
	private void setContentStr(String yourstr){
		//contentTextArea.setText("");
		contentTextArea.setText(yourstr);
		int len = yourstr.length();
		contentTextArea.setCaretPosition(len);
	}
	
	
	private void appendContentStr(String youstr){
		int caret = contentTextArea.getCaretPosition();
		int len = contentTextArea.getText().length();
		if(caret<len){
			contentTextArea.append(youstr);
		}else {
			contentTextArea.append("\n");
			contentTextArea.append(youstr);
		}
	}
	
}
