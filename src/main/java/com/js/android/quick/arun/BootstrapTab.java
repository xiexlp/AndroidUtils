package com.js.android.quick.arun;

import com.js.android.quick.bean.AndroidControlInfo;
import com.js.android.quick.bean.JavaClassInfo;
import com.js.android.quick.dialog.DDialog;
import com.js.android.quick.dialog.Data;
import com.js.android.quick.dialog.MainDialogTest;
import com.js.android.quick.html.*;
import com.js.android.quick.swing.lab.IconUtils;
import com.js.android.quick.swing.lab.RichTabbedPane;
import com.js.android.quick.swing.lab.TabUtils;
import com.js.android.quick.swing.tooltip.TipButton;
import com.js.android.quick.swing.undo.UndoWrapper;
import com.js.android.quick.utils.G;
import com.js.android.quick.utils.StringTool;
import com.sun.org.apache.bcel.internal.generic.DDIV;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Timer;


public class BootstrapTab extends JFrame implements ActionListener {


	VelocityEngine velocityEngine = new VelocityEngine();
	VelocityContext context = new VelocityContext();

	JMenuBar menuBar;
	JMenuItem fileOpenItem;
	JMenuItem dirOpenItem;
	JMenuItem fileSaveItem;
	JMenuItem fileSaveAsItem;

	public JTextField projectDirTextField;
	public JTextField packageNameTextField;
	public JTextField nameActivityTextField;
	public JTextField nameFragmentTextField;
	public JTextField namePagerTextField;
	public JTextField moudleNameTextField;

	
	JFileChooser fc=new JFileChooser();
	
	
	JToolBar toolBar; 
	JButton cutButton;
	JButton copyButton;
	JButton pasteButton;
	JButton clearButton;
	
	JButton saveButton;
	JButton saveAsButton;
	JButton openFileButton;
	JButton openDirButton;
	
	
	JButton undoButton;
	JButton redoButton;
	
	JCheckBox appendOrNewCheckBox;
	
	BootstrapTemplate btt;

	JSplitPane mainSplitPane;
	
	JSplitPane rightSplitPane;
	JPanel rightPanel;
	RichTabbedPane contentTab;
	JScrollPane contentScrollPane;
	public static JTextArea contentTextArea;
	JTextPane contentTextPane;
	
	JScrollPane infoScrollPane;
	JTextArea infoTextArea;
	String infoMsg="";
	
	
	JScrollPane buttonsScrollPane;
	JTabbedPane buttonsTabbedPane;
	
	JPanel jPanel;
	JPanel jPanel2;
	JPanel jPanel3;
	JPanel jPanel4;
	JPanel jPanel5;

	JPanel propertiesJPanel;

	JPanel autoJPanel;

	
	
	//String initPath="E:\\jfinal\\beetl series\\jfinal_demo_for_maven\\src\\main\\webapp";
	//String currentPath ="F:\\jfinal\\jfinalseries\\jfinal-3.3_demo_for_maven_310\\jfinal_demo_for_maven_iforum\\src\\main\\webapp";
	String currentPath="F:\\git\\android\\androidshop2019\\MyApplication";
	String projectDir="F:\\git\\android\\androidshop2019\\MyApplication";
	String moduleDir= "feature";
	String packageName = "android.js.com.myapplication.feature";
	DefaultTreeModel newModel;

	JScrollPane treeJScrollPane;
	JTree tree;
	JPopupMenu treePopupMenu;
	JMenuItem menuItem;
	JMenuItem refresthItem;
	JMenuItem addFileItem;
	JMenuItem expandCurrentNodeItem;


	JPopupMenu textAreaPopupMenu;
	JMenuItem copyItem;
	JMenuItem cutItem;
	JMenuItem pasteItem;
	JMenuItem clearItem;
	JMenuItem newLineItem;
	
	
	//col参数，大小参数
	JLabel label,label2,label3;
	JTextField colsTextField;
    JTextField idTextField;
	JTextField colsTextField2;
	JTextField colsTextField3;
	
	
	String[] menuTags={"Bootstrap基本组件","Bootstrap表单组件","Bootstrap菜单组件","Bootstrap组件","javascript组件"};
	String[] menuNick={"basic基本组件","form表单组件","nav菜单组件","component组件","javascript"};
	
	
	Map<String, JScrollPane> contentMap = new HashMap();
	public Map<JScrollPane, JTextArea> paneTextAreaMap = new HashMap();
	public Map<JScrollPane, String> panePathMap=new HashMap<JScrollPane, String>();
	
	Map<JScrollPane, UndoWrapper> paneUnWarraperMap=new HashMap<JScrollPane, UndoWrapper>();

	public Map<String,Long> fileLastModifyMap = new HashMap<String, Long>();

	FileNode lastNode;
	TreePath lastTreePath;
	FileNode top;
	//Map<String, >

	List<String> recentDirList = new ArrayList();
	String charset ="UTF-8";

	String recentfiles = "src/main/resources/recentfiles.properties";
	String initSourceFile="src/main/resources/blank.html";
	String dataResource="src/main/resources/";
	InputStream recentFilesInputStream=null;

	public BootstrapTab()  {

		//读取最近目录列表
		readRecentDirList();

		fc.setCurrentDirectory(new File(currentPath));
		
		//数据初始化
		btt= new BootstrapTemplate();
		
		// BootstrapUtil.init();
		//initMenu();
		
		initMenuFile();
		setJMenuBar(menuBar);
		initToolBar();
		//initTree();
		initTreeDir();
		//左边树的右键
		initTreePopMenu();
		//编辑器中的右键
		initTextPopMenu();
		//init 标签
		initTab();
		//init里面的内容，包括bootstrap内容
		initJPanel();
		
		initMainSplit();
		
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		getContentPane().add(mainSplitPane, BorderLayout.CENTER);
		
		
		//每秒钟执行文件外部更新检查
		 Timer timer = new Timer();     
	     timer.schedule(new AutoLoaderTasker(), 1000, 3000);
		
		//getContentPane().add(contentTab,BorderLayout.CENTER);
	}

	private void showRecentDirList(){
		System.out.println("查看最近文件列表.....");
		for(String s:recentDirList){
			System.out.println("recent dirs:"+s);
		}
	}

	/**
	 * 读取最近目录列表
	 */
	private void readRecentDirList(){

		System.out.println("读取最近文件列表.....");
		try {
			recentFilesInputStream = new FileInputStream(new File(recentfiles));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(recentFilesInputStream!=null)
			recentDirList = FileUtil.readFileByLines(recentFilesInputStream);
		else {
			System.out.println("文件不存在");
		}
		showRecentDirList();

		currentPath = recentDirList.get(0);
	}

	private void writeRecentDirsToFile(){
		System.out.println("将最近文件列表写入文件....");
		StringBuffer sb= new StringBuffer();
		for(String s:recentDirList){
			sb.append(s).append("\n");
		}
		FileUtil.writeToFileClear(recentfiles,sb.toString());
	}
	
	private void initMainSplit(){
		//mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeJScrollPane, contentTab);
		

		
		
		//rightPanel = new JPanel();
//		BorderLayout borderLayout=new BorderLayout();
//		rightPanel.setLayout(borderLayout);
//		rightPanel.add(buttonsTabbedPane,BorderLayout.NORTH);
		buttonsTabbedPane.setPreferredSize(new Dimension(800, 150));
//		rightPanel.add(contentTab,BorderLayout.CENTER);

		//JSplitPane rightPanelContainer = new JSplitPane(JSplitPane.VERTICAL_SPLIT, buttonsTabbedPane,infoScrollPane);
		//rightPanelContainer.setDividerSize(7);
//		rightPanelContainer.setDividerLocation(50);
//		rightPanelContainer.setOneTouchExpandable(true);

		JPanel opPanel = new JPanel();



		JPanel contentOpPanel = new JPanel();
		JPanel infoOpPanel = new JPanel();


		GridBagLayout containerLayout1=new GridBagLayout();
		opPanel.setLayout(containerLayout1);
		containerLayout1.setConstraints(contentOpPanel, G.nG().aGridXY(0, 0).anchor(G.WEST).afill(G.HORIZONTAL).weightX(1));
		//int level=1;
		containerLayout1.setConstraints(infoOpPanel, G.nG().aGridXY(1, 0).anchor(G.EAST).afill(G.HORIZONTAL).weightX(1));
		opPanel.add(contentOpPanel);opPanel.add(infoOpPanel);

		opPanel.setPreferredSize(new Dimension(800,100));

		JButton cutContentButton =new JButton("剪切");
		JButton copyContentButton = new JButton("复制");
		JButton pasteContentButton = new JButton("粘贴");
		JLabel label = new JLabel("上面的内容操作");
		contentOpPanel.add(label);
		contentOpPanel.add(cutContentButton);contentOpPanel.add(copyContentButton);contentOpPanel.add(pasteContentButton);

		cutContentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCut(contentTextArea);
			}
		});

		copyContentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCopy(contentTextArea);
			}
		});

		pasteContentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onPaste(contentTextArea);
			}
		});

		JButton cutButton =new JButton("剪切");
		JButton copyButton = new JButton("复制");
		JButton pasteButton = new JButton("粘贴");
		JLabel label2 = new JLabel("下面信息操作");
		infoOpPanel.add(label2);
		infoOpPanel.add(cutButton);infoOpPanel.add(copyButton);infoOpPanel.add(pasteButton);



		infoTextArea = new JTextArea();
		infoScrollPane = new JScrollPane(infoTextArea);
//		rightPanel.add(infoScrollPane,BorderLayout.SOUTH);
		infoScrollPane.setPreferredSize(new Dimension(800, 300));

		cutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCut(infoTextArea);
			}
		});

		copyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCopy(infoTextArea);
			}
		});

		pasteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onPaste(infoTextArea);
			}
		});


		JPanel rightPanelContainer =new JPanel();
		rightPanelContainer.add(buttonsTabbedPane);
		rightPanelContainer.add(contentTab);
		rightPanelContainer.add(opPanel);
		rightPanelContainer.add(infoScrollPane);
		GridBagLayout containerLayout=new GridBagLayout();
		rightPanelContainer.setLayout(containerLayout);
		containerLayout.setConstraints(buttonsTabbedPane, G.nG().aGridXY(0, 0).anchor(G.WEST).afill(G.HORIZONTAL).weightX(1));
		int level=1;
		containerLayout.setConstraints(contentTab, G.nG().aGridXY(0, 1).anchor(G.WEST).afill(G.BOTH).weightX(1).weightY(1));
		containerLayout.setConstraints(opPanel, G.nG().aGridXY(0, 2).anchor(G.WEST).afill(G.BOTH).weightX(1));
		containerLayout.setConstraints(infoScrollPane, G.nG().aGridXY(0, 3).anchor(G.WEST).afill(G.BOTH).weightX(1).weightY(1));

		//BorderLayout borderLayout=new BorderLayout();
		//rightPanelContainer.setLayout(borderLayout);

		


//		rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rightPanelContainer,infoScrollPane);
//
//		rightSplitPane.setDividerSize(7);
//		rightSplitPane.setDividerLocation(100);
//		rightSplitPane.setOneTouchExpandable(true);
		
		//rightPanel.add(buttonsTabbedPane, null, BorderLayout.NORTH);
		mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeJScrollPane, rightPanelContainer);
		//设置分隔条的大小
		mainSplitPane.setDividerSize(5);
		mainSplitPane.setDividerLocation(200);
		//是否可以收起来
		mainSplitPane.setOneTouchExpandable(true);
	}
	
	
	private void initToolBar(){
		toolBar= new JToolBar();
		
		cutButton = new JButton("剪切",IconUtils.getIconExample1());
		copyButton = new JButton("复制",IconUtils.getIconExample2());
		pasteButton = new JButton("粘贴",IconUtils.getIconExample3());
		clearButton = new JButton("清空",IconUtils.getIconExample1());
		
		toolBar.add(cutButton);
		toolBar.add(copyButton);
		toolBar.add(pasteButton);
		toolBar.addSeparator();
	
		ToolbarButtonActionListener toolbarButtonActionListener = new ToolbarButtonActionListener();
		cutButton.addActionListener(toolbarButtonActionListener);
		copyButton.addActionListener(toolbarButtonActionListener);
		pasteButton.addActionListener(toolbarButtonActionListener);
		clearButton.addActionListener(toolbarButtonActionListener);
		
		appendOrNewCheckBox = new JCheckBox("添加");
		appendOrNewCheckBox.setSelected(false);;
		toolBar.add(appendOrNewCheckBox);
		
		toolBar.add(clearButton);
		toolBar.addSeparator();
		 saveButton=new JButton("保存", IconUtils.getIconExample1());
		 
		 //saveButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		 
		 saveAsButton=new JButton("另存为..", IconUtils.getIconExample2());
		 openFileButton=new JButton("打开文件", IconUtils.getIconExample3());
		 openDirButton = new JButton("打开文件夹", IconUtils.getIconExample1());
		 
		 saveButton.addActionListener(toolbarButtonActionListener);
		 saveAsButton.addActionListener(toolbarButtonActionListener);
		 openFileButton.addActionListener(toolbarButtonActionListener);
		 openDirButton.addActionListener(toolbarButtonActionListener);
		 
		 toolBar.add(saveButton);
		 toolBar.add(saveAsButton);
		 toolBar.add(openFileButton);
		 toolBar.add(openDirButton);
		 
		 undoButton=new JButton("恢复", IconUtils.getIconExample3());
		 redoButton = new JButton("重做", IconUtils.getIconExample1());
		 
		 //undoButton.setAction(UndoWrappe);
		 
		toolBar.add(undoButton);
		toolBar.add(redoButton);
	}


	/**
	 * 当前使用的是这个函数，对文件夹进行遍历得到文件树
	 */
	private void initTreeDir(){
		//DefaultMutableTreeNode top = DirUtils.traverseFolder(initPath);

		top = DirUtils.traverseFolder(currentPath);
		newModel=new DefaultTreeModel(top);  
        tree=new JTree(newModel); 
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
		tree.addMouseListener(popMouseListener);
	}



	/***
	 * 刷新树，不更改树原来的展开状态
	 */
	public void updateTree() {
		Vector<TreePath> v = new Vector<TreePath>();
		getExpandNode(top, v);
		top.removeAllChildren();

		//addNode(root, 3);
		top= DirUtils.traverseFolder(currentPath);
		newModel.setRoot(top);
		newModel.reload();

		int n = v.size();
		for (int i = 0; i < n; i++) {
			Object[] objArr = v.get(i).getPath();
			Vector<Object> vec = new Vector<Object>();
			int len = objArr.length;
			for (int j = 0; j < len; j++) {
				vec.add(objArr[j]);
			}
			expandNode(tree, top, vec);
		}
	}

	public Vector<TreePath> getExpandNode(FileNode node, Vector<TreePath> v) {
		if (node.getChildCount() > 0) {
			TreePath treePath = new TreePath(newModel.getPathToRoot(node));
			if (tree.isExpanded(treePath)) v.add(treePath);
			for (Enumeration e = node.children(); e.hasMoreElements(); ) {
				FileNode n = (FileNode) e.nextElement();
				getExpandNode(n, v);
			}
		}
		return v;
	}


	/**
	 * @param myTree   树
	 * @param currNode 展开节点的父节点
	 * @param vNode    展开节点，路径字符串|路径Node组成的Vector，按从根节点开始，依次添加到Vector
	 */
	void expandNode(JTree myTree, FileNode currNode, Vector<Object> vNode) {
		if (currNode.getParent() == null) {
			vNode.removeElementAt(0);
		}
		if (vNode.size() <= 0) return;

		int childCount = currNode.getChildCount();
		String strNode = vNode.elementAt(0).toString();
		//DefaultMutableTreeNode child = null;
		FileNode child =null;
		boolean flag = false;
		for (int i = 0; i < childCount; i++) {
			child = (FileNode) currNode.getChildAt(i);
			if (strNode.equals(child.toString())) {
				flag = true;
				break;
			}
		}
		if (child != null && flag) {
			vNode.removeElementAt(0);
			if (vNode.size() > 0) {
				expandNode(myTree, child, vNode);
			} else {
				myTree.expandPath(new TreePath(child.getPath()));
			}
		}
	}

	private void initTreePopMenu(){
		treePopupMenu = new JPopupMenu();
		System.out.println("右键点击");
		 menuItem = new JMenuItem("增加文章");
		 refresthItem = new JMenuItem("刷新");
		 addFileItem = new JMenuItem("增加文件");
		expandCurrentNodeItem = new JMenuItem("展开当前节点");
		//addArticleHtmlMenuItem = new JMenuItem("增加Html文章");
		//addMultiArticleMenuItem = new JMenuItem("增加多媒体文章");
		treePopupMenu.add(menuItem);
		treePopupMenu.add(refresthItem);
		treePopupMenu.add(addFileItem);
		treePopupMenu.add(expandCurrentNodeItem);
		
		//右键动作绑定
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("i am clicked");
				JOptionPane.showMessageDialog(null,"测试信息");
			}
		});

		//右键动作绑定
		expandCurrentNodeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("expandnode am clicked");

				lastNode = (FileNode) tree.getLastSelectedPathComponent();
				lastTreePath = tree.getLeadSelectionPath();
				doExpandCurrentNode();

				//JOptionPane.showMessageDialog(null,"测试信息");
			}
		});

		//右键动作绑定
		addFileItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					FileNode parentNode = (FileNode) tree.getLastSelectedPathComponent();
					System.out.println("i am clicked");
					String parentPath = parentNode.getAbsolutePath();
					String name = JOptionPane.showInputDialog(null, "请输入文件名");
					if (name != null && !name.equals("")) {
						String filefullname = parentPath + "\\" + name;
						File file = new File(filefullname);
						if (file.exists()) {
							JOptionPane.showMessageDialog(null, "文件已经存在");
						} else{
							file.createNewFile();
							doRefreshTree(currentPath);
						}
					}
				}catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		
		//右键动作绑定
		refresthItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("刷新");
						String path = currentPath;
						//doRefreshTree(path);
						updateTree();
					}
				});
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

		tree.addMouseListener(treeMouseListener);
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
//		rightPanel = new JSplitPane();
		contentTab = new RichTabbedPane();
		
		//为tab增加close右键单击
		TabUtils.installTabPopMenu(contentTab);
		
		//选项卡切换事件
		contentTab.addChangeListener(new ChangeListener(){
			   public void stateChanged(ChangeEvent e){
			    JTabbedPane tabbedPane = (JTabbedPane)e.getSource();
			    int selectedIndex = tabbedPane.getSelectedIndex();
			   
			    //System.out.println("选项卡切换");
			    
			    //需要重置undo,redo
			    JScrollPane scrollPane = (JScrollPane)tabbedPane.getSelectedComponent();
			    UndoWrapper undoWrapper = paneUnWarraperMap.get(scrollPane);
			    
			    if(undoWrapper!=null){
				    undoButton.setAction(undoWrapper.getUndoAction());
					redoButton.setAction(undoWrapper.getRedoAction());
			    }
			    
			    /**
			      if(selectedIndex==0)
			         JOptionPane.showMessageDialog(null,"you suck");
			    */
			   }
			});

		contentTextArea = new JTextArea();
		contentScrollPane  =new JScrollPane(contentTextArea);

		String initBlankFile = FileUtil.readFileByLinesPure(initSourceFile);
		File file = new File(initSourceFile);
		contentTextArea.setText(initBlankFile);
		paneTextAreaMap.put(contentScrollPane,contentTextArea);
		panePathMap.put(contentScrollPane,file.getAbsolutePath());

		//contentTab.add(contentTextArea);
		contentTab.add("文件", contentScrollPane);
		
		rightPanel = new JPanel();
		buttonsTabbedPane = new JTabbedPane();
		buttonsScrollPane  = new JScrollPane(buttonsTabbedPane);
		
		 jPanel=new JPanel();
		 jPanel2=new JPanel();
		 jPanel3=new JPanel();
		 jPanel4=new JPanel();
		 jPanel5=new JPanel();
		autoJPanel = new JPanel();
		propertiesJPanel = new JPanel();
		//nestFragmentJPanel =new JPanel();

		 
		 label = new JLabel("第一列");
		 colsTextField = new JTextField(10);
		 label2 = new JLabel("第二列");
		 colsTextField2 = new JTextField(10);
		 label3 = new JLabel("第三列");
		 colsTextField3 = new JTextField(10);
		 
		 
		 buttonsTabbedPane .add("布局控件(包含layout,control)",jPanel);
		 buttonsTabbedPane .add("活动碎片(包含activity,fragment)",jPanel2);
		 buttonsTabbedPane .add("控件Adapter(包含control,adapter设置)",jPanel3);
		 buttonsTabbedPane .add("通用工具(common tools third plug)",jPanel4);
		 buttonsTabbedPane .add("自动化定制(customize)",jPanel5);

		//JScrollPane autoJScrollPane = new JScrollPane(autoJPanel);
		 buttonsTabbedPane.add("activity fragment pager代码生成",autoJPanel);
		//buttonsTabbedPane.add("嵌套fragment代码生成",nestFragmentJPanel);

		 //选择第三个面板
		 buttonsTabbedPane.setSelectedIndex(1);
		 
	}
	
	
	private class ToolbarButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        
        	Object o = e.getSource();
        	if(o==cutButton){
        		onCut(getActiveTextArea());
        	}else if (o==copyButton) {
				onCopy(getActiveTextArea());
			}else if(o==pasteButton){
				onPaste(getActiveTextArea());
			}else if (o==clearButton) {
				onClear(getActiveTextArea());
			}else if(o==saveButton){
				doFileSave();
			}else if(o==saveAsButton){
				doFileSaveAs();
			}else if(o==openFileButton){
				doFileOpen();
			}else if(o==openDirButton){
				doDirOpen();
			}
        	
        	
            //System.out.println("你按了按钮一");     
        }     
    }  
	
	
	private class MyFileActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o==fileOpenItem){
				//应该有个filechoose对话框
				doFileOpen();
				
			}else if (o==dirOpenItem) {
				doDirOpen();
			}else if (o==fileSaveItem) {
				//直接保存,得到当前的文件，保存
				//String path =;
				doFileSave();
			}else if (o==fileSaveAsItem) {
				//保存的框，选择文件夹，键入文件名，保存
				doFileSaveAsFilter();
			}
			
		}
		
	}


	private class MyRecentFileActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem)e.getSource();
			String path = menuItem.getToolTipText();
			currentPath = path;
			//切换当前path，并且打开
			//doDirOpen();
			refreshTree(path);
		}

	}
	
	
	private void doFileOpen(){
		
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//只能选择目录
		String path=null;
		File f=null;
		int flag=-1;
		try{     
		            flag=fc.showOpenDialog(null);     
		        }    
		        catch(HeadlessException head){     
		             System.out.println("Open File Dialog ERROR!");    
		        }        
		        if(flag==JFileChooser.APPROVE_OPTION){
		             //获得该文件    
		            f=fc.getSelectedFile();    
		            path=f.getPath();
		            System.out.println("您所选择的文件夹 是:"+path);
		            infoMsg = "您所选择的文件 是:"+path;
		            appendInfoMsg();
		         }    
	}
	
	
	
	private void doFileSave(){
		
		JScrollPane selectJScrollPane = (JScrollPane)contentTab.getSelectedComponent();
		String path = panePathMap.get(selectJScrollPane);
		
		JTextArea textArea = paneTextAreaMap.get(selectJScrollPane);
		
		String content = textArea.getText();
		
		//FileUtil.writeToFileClear(path,content);
		writeToFileClear(path, content);
		
		//打开文件的时候把最后修改时间更新到目录
		fileLastModifyMap.put(path, System.currentTimeMillis());
		
		
	}
	
	
	private void writeToFileClear(String path,String content){
		FileUtil.writeToFileClear(path,content);
		//修改文件最后修改时间,相对于本程序
		fileLastModifyMap.put(path, System.currentTimeMillis());
	}


	private void doExpandCurrentNode(){
		//FileNode node = (FileNode) tree.getLastSelectedPathComponent();
		//lastNode =
		//TreePath treePath=tree.getLeadSelectionPath();
		//lastNode = (FileNode) tree.getLastSelectedPathComponent();
		//lastTreePath = tree.getLeadSelectionPath();
		String path = lastNode.getAbsolutePath();
		File f = new File(path);
		if(f.isDirectory()){
			//TreePath treePath = new TreePath()
			tree.expandPath(lastTreePath);
			//expandAllNode(tree, new TreePath(node), true);
		}else return;

	}


	private void expandAllNode(JTree tree, TreePath parent, boolean expand) {
		// Traverse children
		FileNode node = (FileNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration<?> e = node.children(); e.hasMoreElements();) {
				FileNode n = (FileNode) e.nextElement();
				System.out.println("node:"+n.toString());
				TreePath path = parent.pathByAddingChild(n);
				expandAllNode(tree, path, expand);
			}
		}

		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
		}
	}
	
	
	private void doFileSaveAs(){
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//只能选择目录
		String path=null;
		File f=null;
		int flag=-1;
		try{     
		            flag=fc.showSaveDialog(null);     
		        }    
		        catch(HeadlessException head){     
		             System.out.println("Save File Dialog ERROR!");    
		        }        
		        if(flag==JFileChooser.APPROVE_OPTION){
		             //获得该文件    
		            f=fc.getSelectedFile();    
		            path=f.getPath();
		            System.out.println("您所选择的文件夹 是:"+path);
		            infoMsg = "您所选择的文件 是:"+path;
		            appendInfoMsg();
		         }    
	}
	
	
	private void doFileSaveAsFilter(){
	
		    //弹出文件选择框  
		    fc = new JFileChooser();  
		      
		    //后缀名过滤器  
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(  
		            "网页(*.html)", "html");  
		    fc.setFileFilter(filter);  
		    fc.setCurrentDirectory(new File(currentPath));
		      
		    //下面的方法将阻塞，直到【用户按下保存按钮且“文件名”文本框不为空】或【用户按下取消按钮】  
		    int option = fc.showSaveDialog(null);  
		    if(option==JFileChooser.APPROVE_OPTION){    //假如用户选择了保存  
		        File file = fc.getSelectedFile();  
		          
		        String fname = fc.getName(file);   //从文件名输入框中获取文件名  
		          
		        //假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀  
		        if(fname.indexOf(".html")==-1){  
		            file=new File(fc.getCurrentDirectory(),fname+".html");  
		            System.out.println("renamed");  
		            System.out.println("保存的文件名："+file.getName());  
		            
		            infoMsg = "保存的文件名："+file.getName()+"绝对路径:"+file.getAbsolutePath();
		            appendInfoMsg();
		        }  
		          
		        try {  
		            //FileOutputStream fos = new FileOutputStream(file);  
		            String content = getActiveTextAreaContent();
		            //FileUtil.writeToFileClear(file, content);
		            writeToFileClear(file.getAbsolutePath(), content);
		              
		            //写文件操作……  
		              
		            //fos.close();  
		              
		        } catch (Exception e) {  
		            System.err.println("IO异常");  
		            e.printStackTrace();  
		        }     
		    }  
		
	}
	
	
	private String getActiveTextAreaContent(){
		String aa = contentTextArea.getText();
		return aa;
	}


	
	
	private void doRefreshTree(String path){
		System.out.println("您所选择的文件是:"+path);
        infoMsg = "正在刷新，请稍候:"+path;
        appendInfoMsg();

		lastNode = (FileNode) tree.getLastSelectedPathComponent();
		lastTreePath = tree.getLeadSelectionPath();

        refreshTree(path);
        //doExpandCurrentNode();
	}
	
	private void doDirOpen(){
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
		String path=null;
		File f=null;
		int flag=-1;
		try{     
		            flag=fc.showOpenDialog(null);     
		        }    
		        catch(HeadlessException head){     
		             System.out.println("Open File Dialog ERROR!");    
		        }        
		        if(flag==JFileChooser.APPROVE_OPTION){
		             //获得该文件    
		            f=fc.getSelectedFile();    
		            path=f.getPath();

		            //对tree树进行更新
					currentPath = path;
					//放入到recentDirList中去
					recentDirList.add(path);
					if(recentDirList.contains(currentPath)){
						//删掉
						recentDirList.remove(currentPath);
						//放入最近的list,方便下次读取
						recentDirList.add(currentPath);
						writeRecentDirsToFile();
					}

		            System.out.println("您所选择的文件是:"+path);
		            infoMsg = "正在刷新，请稍候:"+path;
		            appendInfoMsg();
		            refreshTree(path);
		           
		            System.out.println("您所选择的文件是:"+path);
		            infoMsg = "您所选择的文件夹 是:"+path;
		            appendInfoMsg();
		            
		         }    
		
	}
	
	
	private void refreshTree(String dir){
		
		//FileNode fn = DirUtils.traverseFolder(dir);
		DefaultMutableTreeNode top = DirUtils.traverseFolder(dir);
		newModel=new DefaultTreeModel(top);
		//这种方式更好

		tree.setModel(newModel);
		newModel.reload();
        //tree=new JTree(newModel); 
        //tree.updateUI();
		
	}

	/**
	 * 对文件的操作
	 */
	private class TreeMouseListener extends MouseAdapter{
		
		public void mouseClicked(MouseEvent evt) {

			if(evt.getClickCount()==2){
				System.out.println("双击树");
				FileNode node =(FileNode)tree.getLastSelectedPathComponent();
				//TreeNode node =(TreeNode)tree.getLastSelectedPathComponent();

				System.out.println("双击的节点:"+node.toString()+"--"+node.getPath()+" 名称:"+node.toString());

				if(node.isLeaf()){
					System.out.println("click:"+node.toString()+" abstract path:"+node.getAbsolutePath());
					String name = node.getName();
					//检查是否允许
					if(FilterUtils.checkFileType(name)){
						//String content = FileUtil.readFileByLinesPure(node.getAbsolutePath());
						//
						System.out.println("sssss:"+node.getName());
						doShowContent(node);

						//setContentStr(content);
					}else{
						infoMsg="不支持的文件类型";
						appendInfoMsg();
					}
					//commandAction(node.getName());
				}
			}else {
				//System.out.println("单击树");
			}
        }

		public void mouseEntered(MouseEvent e) {
			System.out.println("mouse entering ");
		}

		public void mouseExited(MouseEvent e) {
			System.out.println("mouse exit...");
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


	private void doShowContent(FileNode node){
		String path = node.getAbsolutePath();

		//JScrollPane scrollPane = pa

		//		JScrollPane scrollPane=(JScrollPane)contentTab.getSelectedComponent();
		int titleIndex = contentTab.titleIndex(node.getName());
		//已经打开
		if(titleIndex>=0){
			contentTab.setSelectedIndex(titleIndex);
			//JScrollPane pane = (JScrollPane)contentTab.getSelectedComponent();
			//JTextArea textArea = paneTextAreaMap.get(pane);

			String contentstr = FileUtil.readFileByLinesPure(path);
			replaceContentStrToActive(contentstr);

			//打开文件的时候把最后修改时间更新到目录
			fileLastModifyMap.put(path, System.currentTimeMillis());

		//未打开
		}else{
			JTextArea textArea = new JTextArea();
			textArea.addMouseListener(textAreaMouseListener);

			UndoWrapper undoWrapper=new UndoWrapper(textArea);
			undoButton.setAction(undoWrapper.getUndoAction());
			redoButton.setAction(undoWrapper.getRedoAction());

			JScrollPane contentScrollPane = new JScrollPane(textArea);
			contentTab.addRichTab(node.getName(), IconUtils.getIconExample1(), contentScrollPane, path);


			String content = FileUtil.readFileByLinesPure(path);
			textArea.setText(content);

			//打开文件的时候把最后修改时间更新到目录
			fileLastModifyMap.put(path, System.currentTimeMillis());

			contentMap.put(path, contentScrollPane);
			paneTextAreaMap.put(contentScrollPane, textArea);
			panePathMap.put(contentScrollPane, path);

			paneUnWarraperMap.put(contentScrollPane, undoWrapper);

		}

	}


	private void onCopy(JTextArea textArea){
		System.out.println("copybutton");
		String selectTxt = textArea.getSelectedText();
		ClipboradOperate.setToClipboardText(selectTxt);
	}

	private void onPaste(JTextArea textArea){
		System.out.println("pastebutton");
		String clipStr="";
		try {
			clipStr = ClipboradOperate.getClipboardText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int caret = textArea.getCaretPosition();
		textArea.insert(clipStr, caret);
	}
	private void onClear(JTextArea textArea){
		System.out.println("clearbutton");
		textArea.setText("");
	}


	private void onCut(JTextArea textArea){
		System.out.println("cutbuton");

		int start = textArea.getSelectionStart();
		int end = textArea.getSelectionEnd();
		String selectTxt = textArea.getSelectedText();

		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//获取系统剪贴板
		ClipboradOperate.setClipboardText(clip, selectTxt);
		String originTxt  = textArea.getText();
		String front=originTxt.substring(0, start);
		String forward = originTxt.substring(end);


		StringBuffer sb = new StringBuffer(front).append(forward);
		textArea.setText(sb.toString());
	}






	/**
	 *
	 * init menu
	 */
	private void initMenu() {

		menuBar = new JMenuBar();

		JMenu sysMenu = new JMenu("系统菜单");

		JMenu controlLayoutMenu = new JMenu(menuTags[0]);
		JMenu activityFragmentMenu = new JMenu(menuTags[1]);
		JMenu controlAdapterMenu = new JMenu(menuTags[2]);
		JMenu commonToolsMenu = new JMenu(menuTags[3]);
		JMenu customizationMenu = new JMenu(menuTags[4]);


		initMenuItem(controlLayoutMenu, btt.getControlLayoutList());
		initMenuItem(activityFragmentMenu, btt.getActivityFragmentList());
		initMenuItem(controlAdapterMenu, btt.getControlAdapterList());
		initMenuItem(commonToolsMenu, btt.getCommonToolsList());
		initMenuItem(customizationMenu, btt.getCustomizationList());

		menuBar.add(controlLayoutMenu);
		menuBar.add(activityFragmentMenu);
		menuBar.add(controlAdapterMenu);
		menuBar.add(commonToolsMenu);
		menuBar.add(customizationMenu);
	}


	private void initMenuFile(){

		menuBar = new JMenuBar();

		JMenu sysMenu = new JMenu("系统");

		 fileOpenItem = new JMenuItem("打开文件");
		 dirOpenItem = new JMenuItem("打开文件夹");

		 JMenu recentMenu = new JMenu("最近文件>>>");
		 MyRecentFileActionListener myRecentFileActionListener= new MyRecentFileActionListener();

		 for(String s:recentDirList){
		 	int index = s.indexOf("\\");
		 	String lastDir = s.substring(index+1,s.length());
		 	JMenuItem jMenuItem = new JMenuItem(lastDir);
		 	jMenuItem.setToolTipText(s);
		 	jMenuItem.addActionListener(myRecentFileActionListener);
		 	recentMenu.add(jMenuItem);
		 }
		 sysMenu.add(recentMenu);

		 fileSaveItem = new JMenuItem("保存当前文件");
		 fileSaveAsItem = new JMenuItem("文件另存为...");

		 fileOpenItem.addActionListener(new MyFileActionListener());
		 fileOpenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));

		 dirOpenItem.addActionListener(new MyFileActionListener());

		 fileSaveItem.addActionListener(new MyFileActionListener());
		 fileSaveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		 fileSaveItem.setMnemonic('S');

		 fileSaveAsItem.addActionListener(new MyFileActionListener());

		sysMenu.add(fileOpenItem);
		sysMenu.add(dirOpenItem);
		sysMenu.add(fileSaveItem);
		sysMenu.add(fileSaveAsItem);

		menuBar.add(sysMenu);
	}

	private void doCreateActivityAndLayoutCodeFile(){
        try{
            System.out.println("先跳出个输入框，输入activity的名称，必须是NameAcitvity模式");
            System.out.println("自动生成NameActivity,");
            String s=nameActivityTextField.getText();
            if(!s.endsWith(Constant.ACTIVITY)){
                System.out.println("输入有误，输入名以Activity结束");
                JOptionPane.showMessageDialog(null,"Activity输入名尽量名以Activity结束");
                return;
            }else {
                String javaName = s+".java";
                int indexActivity = javaName.lastIndexOf("Activity");
                String name = javaName.substring(0,indexActivity);
                System.out.println("驼峰式的名称:"+name);
                String nameUnderLine = StringTool.humpToUnderLine(name);
                System.out.println("驼峰变为下划线:"+nameUnderLine);
                String noSuffixXmlName = "activity_"+nameUnderLine;
                noSuffixXmlName = noSuffixXmlName.replace("__","_");
                String xmlName = "activity_"+nameUnderLine+".xml";
                //如果有__替换为单下划线
                xmlName = xmlName.replace("__","_");

                System.out.println("activity xml名称:"+xmlName);


                packageName = packageNameTextField.getText();
                String className = packageName+"."+s;
                System.out.println("类名:"+className);

                System.out.println("包名:"+packageName);

                String activityDeclare = "<activity android:name=\""+className+"\"/>";
                contentTextArea.setText("activity声明,放到manifest中:\n"+activityDeclare);

                String packageDir =  packageName.replace(".", "/");
                System.out.println("包名转换之后:"+packageDir);
                String javaDir = projectDir+"\\"+moduleDir+"\\src\\main\\java\\"+packageDir;
                String resDir = projectDir+"\\"+moduleDir+"\\src\\main\\res\\layout";

                File javaFile = new File(javaDir);
                File resFile = new File(resDir);

                if(!javaFile.exists()){
                    System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
                    javaFile.mkdirs();
                }else {
                    System.out.println("文件夹:"+javaFile.getAbsolutePath()+"存在");
                }
                if(!resFile.exists()){
                    System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
                    resFile.mkdirs();
                }else {
                    System.out.println("文件夹:"+resFile.getAbsolutePath()+"存在");
                }

                File javaCodeFile = new File(javaDir+"\\"+javaName);
                File xmlCodeFile = new File(resDir+"\\"+xmlName);
                System.out.println("java code file是否存在:"+javaCodeFile.exists());
                //将样板代码内容写入文件
                JavaClassInfo javaClassInfo = new JavaClassInfo();
                javaClassInfo.setFullName(nameActivityTextField.getText().trim());
                javaClassInfo.setPackageName(packageNameTextField.getText().trim());
                javaClassInfo.setNoSuffixXmlName(noSuffixXmlName);

                if(!javaCodeFile.exists()){
                    try {
                        System.out.println("java 代码文件不存在,新建一个:"+javaCodeFile.getName());
                        javaCodeFile.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }else {
                    int result = JOptionPane.showConfirmDialog(null,javaCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");

                    System.out.println("result:"+result);
                    if(result==0){
                        //肯定
                        System.out.println("肯定");System.out.println("覆盖");
                    }else if(result==1) {
                        System.out.println("否定");System.out.println("返回");
                        return ;
                    }
                    javaCodeFile.delete();
                    javaCodeFile.createNewFile();
                }
                context.put("jci", javaClassInfo);
                StringWriter sw = new StringWriter();
                velocityEngine.mergeTemplate("src/main/resources/templates/activity.vm", "utf-8", context, sw);
                //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
                System.out.println(sw.toString());
                infoMsg = sw.toString();
                appendInfoMsg();
                //activity程序的内容
                FileUtil.writeToFileClear(javaCodeFile,sw.toString());
                System.out.println("xml code file 是否存在:"+xmlCodeFile.exists());
                if(!xmlCodeFile.exists()){
                    try {
                        System.out.println("xml 代码文件不存在,新建一个:"+xmlCodeFile.getName());
                        xmlCodeFile.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }else {
                    int result = JOptionPane.showConfirmDialog(null,xmlCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");
                    System.out.println("result:"+result);
                    if(result==0){
                        //肯定
                        System.out.println("肯定");System.out.println("覆盖");
                        xmlCodeFile.delete();
                        xmlCodeFile.createNewFile();
                    }else if(result==1) {
                        System.out.println("否定");System.out.println("返回");
                        return ;
                    }
                }
				StringWriter sw2 = new StringWriter();
				velocityEngine.mergeTemplate("src/main/resources/templates/activity_layout.vm", "utf-8", context, sw2);
				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw2.toString());
				infoMsg = sw2.toString();
				appendInfoMsg();
				//activity程序的内容
				FileUtil.writeToFileClear(xmlCodeFile,sw2.toString());
            }
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

	private void doCreateFragmentAndLayoutCodeFile(){
		try{
			System.out.println("先跳出个输入框，输入Fragment的名称，必须是NameFragment模式");
			System.out.println("自动生成NameFragment,");
			String s=nameFragmentTextField.getText();
			if(!s.endsWith(Constant.FRAGMENT)||s.equalsIgnoreCase(Constant.FRAGMENT)){
				System.out.println("输入有误，输入名以Fragment结束");
				JOptionPane.showMessageDialog(null,"Fragment输入名尽量名以Fragment结束");
				return;
			}else {
				String javaName = s+".java";
				int indexFragment = javaName.lastIndexOf("Fragment");
				String name = javaName.substring(0,indexFragment);
				System.out.println("驼峰式的名称:"+name);
				String nameUnderLine = StringTool.humpToUnderLine(name);
				System.out.println("驼峰变为下划线:"+nameUnderLine);
				String noSuffixXmlName = "fragment_"+nameUnderLine;
				noSuffixXmlName = noSuffixXmlName.replace("__","_");
				String xmlName = "fragment_"+nameUnderLine+".xml";
				//如果有__替换为单下划线
				xmlName = xmlName.replace("__","_");

				System.out.println("Fragment xml名称:"+xmlName);

				packageName = packageNameTextField.getText();
				String className = packageName+"."+s;
				System.out.println("类名:"+className);

				System.out.println("包名:"+packageName);
				//fragment不需要declare
				//String activityDeclare = "<activity android:name=\""+className+"\"/>";
				//contentTextArea.setText("activity声明,放到manifest中:\n"+activityDeclare);

				String packageDir =  packageName.replace(".", "/");
				System.out.println("包名转换之后:"+packageDir);
				String javaDir = projectDir+"\\"+moduleDir+"\\src\\main\\java\\"+packageDir;
				String resDir = projectDir+"\\"+moduleDir+"\\src\\main\\res\\layout";

				File javaFile = new File(javaDir);
				File resFile = new File(resDir);

				if(!javaFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					javaFile.mkdirs();
				}else {
					System.out.println("文件夹:"+javaFile.getAbsolutePath()+"存在");
				}
				if(!resFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					resFile.mkdirs();
				}else {
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"存在");
				}

				File javaCodeFile = new File(javaDir+"\\"+javaName);
				File xmlCodeFile = new File(resDir+"\\"+xmlName);
				System.out.println("java code file是否存在:"+javaCodeFile.exists());
				//将样板代码内容写入文件
				JavaClassInfo javaClassInfo = new JavaClassInfo();
				javaClassInfo.setFullName(nameFragmentTextField.getText().trim());
				javaClassInfo.setPackageName(packageNameTextField.getText().trim());
				javaClassInfo.setNoSuffixXmlName(noSuffixXmlName);

				if(!javaCodeFile.exists()){
					try {
						System.out.println("java 代码文件不存在,新建一个:"+javaCodeFile.getName());
						javaCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,javaCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");

					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
					javaCodeFile.delete();
					javaCodeFile.createNewFile();
				}
				context.put("jci", javaClassInfo);
				StringWriter sw = new StringWriter();
				velocityEngine.mergeTemplate("src/main/resources/templates/fragment.vm", "utf-8", context, sw);
				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw.toString());
				infoMsg = sw.toString();
				appendInfoMsg();
				//activity程序的内容
				FileUtil.writeToFileClear(javaCodeFile,sw.toString());
				System.out.println("xml code file 是否存在:"+xmlCodeFile.exists());
				if(!xmlCodeFile.exists()){
					try {
						System.out.println("xml 代码文件不存在,新建一个:"+xmlCodeFile.getName());
						xmlCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,xmlCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");
					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
						xmlCodeFile.delete();
						xmlCodeFile.createNewFile();
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
				}
				StringWriter sw2 = new StringWriter();
				velocityEngine.mergeTemplate("src/main/resources/templates/fragment_layout.vm", "utf-8", context, sw2);
				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw2.toString());
				infoMsg = sw2.toString();
				appendInfoMsg();
				//activity程序的内容
				FileUtil.writeToFileClear(xmlCodeFile,sw2.toString());
			}
		}catch (Exception ee){
			ee.printStackTrace();
		}
	}

	private void doCreatePagerAndLayoutCodeFile(){
		try{
			System.out.println("先跳出个输入框，输入Fragment的名称，必须是NameFragment模式");
			System.out.println("自动生成NameFragment,");
			String s=namePagerTextField.getText();
			if(!s.endsWith(Constant.PAGER)){
				System.out.println("输入有误，输入名以Fragment结束");
				JOptionPane.showMessageDialog(null,"Fragment输入名尽量名以Fragment结束");
				return;
			}else {
				String javaName = s+".java";
				int indexFragment = javaName.lastIndexOf("Pager");
				String name = javaName.substring(0,indexFragment);
				System.out.println("驼峰式的名称:"+name);
				String nameUnderLine = StringTool.humpToUnderLine(name);
				System.out.println("驼峰变为下划线:"+nameUnderLine);
				String noSuffixXmlName = "pager_"+nameUnderLine;
				noSuffixXmlName = noSuffixXmlName.replace("__","_");
				String xmlName = "pager_"+nameUnderLine+".xml";
				//如果有__替换为单下划线
				xmlName = xmlName.replace("__","_");

				System.out.println("Pager xml名称:"+xmlName);


				packageName = packageNameTextField.getText();
				String className = packageName+"."+s;
				System.out.println("类名:"+className);

				System.out.println("包名:"+packageName);
				//fragment不需要declare
				//String activityDeclare = "<activity android:name=\""+className+"\"/>";
				//contentTextArea.setText("activity声明,放到manifest中:\n"+activityDeclare);

				String packageDir =  packageName.replace(".", "/");
				System.out.println("包名转换之后:"+packageDir);
				String javaDir = projectDir+"\\"+moduleDir+"\\src\\main\\java\\"+packageDir;
				String resDir = projectDir+"\\"+moduleDir+"\\src\\main\\res\\layout";

				File javaFile = new File(javaDir);
				File resFile = new File(resDir);

				if(!javaFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					javaFile.mkdirs();
				}else {
					System.out.println("文件夹:"+javaFile.getAbsolutePath()+"存在");
				}
				if(!resFile.exists()){
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"不存在，新建一个");
					resFile.mkdirs();
				}else {
					System.out.println("文件夹:"+resFile.getAbsolutePath()+"存在");
				}

				File javaCodeFile = new File(javaDir+"\\"+javaName);
				File xmlCodeFile = new File(resDir+"\\"+xmlName);
				System.out.println("java code file是否存在:"+javaCodeFile.exists());
				//将样板代码内容写入文件
				JavaClassInfo javaClassInfo = new JavaClassInfo();
				javaClassInfo.setFullName(namePagerTextField.getText().trim());
				javaClassInfo.setPackageName(packageNameTextField.getText().trim());
				javaClassInfo.setNoSuffixXmlName(noSuffixXmlName);

				if(!javaCodeFile.exists()){
					try {
						System.out.println("java 代码文件不存在,新建一个:"+javaCodeFile.getName());
						javaCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,javaCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");

					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
					javaCodeFile.delete();
					javaCodeFile.createNewFile();
				}
				context.put("jci", javaClassInfo);
				StringWriter sw = new StringWriter();
				velocityEngine.mergeTemplate("src/main/resources/templates/pager.vm", "utf-8", context, sw);
				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw.toString());
				infoMsg = sw.toString();
				appendInfoMsg();
				//activity程序的内容
				FileUtil.writeToFileClear(javaCodeFile,sw.toString());
				System.out.println("xml code file 是否存在:"+xmlCodeFile.exists());
				if(!xmlCodeFile.exists()){
					try {
						System.out.println("xml 代码文件不存在,新建一个:"+xmlCodeFile.getName());
						xmlCodeFile.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					int result = JOptionPane.showConfirmDialog(null,xmlCodeFile.getAbsolutePath()+"将修改文件内容,是否继续?");
					System.out.println("result:"+result);
					if(result==0){
						//肯定
						System.out.println("肯定");System.out.println("覆盖");
						xmlCodeFile.delete();
						xmlCodeFile.createNewFile();
					}else if(result==1) {
						System.out.println("否定");System.out.println("返回");
						return ;
					}
				}
				StringWriter sw2 = new StringWriter();
				velocityEngine.mergeTemplate("src/main/resources/templates/pager_layout.vm", "utf-8", context, sw2);
				//velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
				System.out.println(sw2.toString());
				infoMsg = sw2.toString();
				appendInfoMsg();
				//activity程序的内容
				FileUtil.writeToFileClear(xmlCodeFile,sw2.toString());
			}
		}catch (Exception ee){
			ee.printStackTrace();
		}
	}

    private void initAutoJPanel(){
        //
        JButton newActivityJButton = new JButton("新建activity");
        JButton newFragmentJButton = new JButton("新建fragment");
		JButton nestFragmentJButton = new JButton("新建nest fragment");
		JButton newPagerJButton = new JButton("新建pager");

        newActivityJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建activity layout代码文件
                doCreateActivityAndLayoutCodeFile();
            }
        });


        nestFragmentJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("嵌套fragment生成");
				Data data =new Data();data.setMoudleNameTextFieldStr(moudleNameTextField.getText());
				data.setProjectDirTextFieldStr(projectDirTextField.getText());
				data.setPackageNameTextFieldStr(packageNameTextField.getText());
				DDialog.showDialog(BootstrapTab.this,data);

			}
		});

		newFragmentJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doCreateFragmentAndLayoutCodeFile();
			}
		});

		newPagerJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("create pager file");
				//doCreatePagerAndLayoutCodeFile();
			}
		});
        JLabel projectDirLabel =new JLabel("工程根目录:");
        JLabel moudleNameLabel = new JLabel("模块名");
        JLabel packageNameLabel = new JLabel("包名");
        JLabel nameActivityLabel = new JLabel("活动");
        JLabel nameFragmentLabel = new JLabel("碎片");
        JLabel namePagerLabel =new JLabel("页面");

        projectDirTextField = new JTextField(projectDir);
        projectDirTextField.setColumns(40);
        //projectDirTextField.setText(projectDir);

        packageNameTextField= new JTextField(packageName);
        packageNameTextField.setColumns(40);

        nameActivityTextField = new JTextField("Activity");
        nameActivityTextField.setColumns(40);
        nameActivityTextField.setToolTipText("在此填入需要新建的activity,这个作为java文件存在");

        nameFragmentTextField =new JTextField("Fragment");
        nameFragmentTextField.setColumns(40);
        nameFragmentTextField.setToolTipText("在此填入需要新建的fragment");

		namePagerTextField =new JTextField("Pager");
		namePagerTextField.setColumns(40);
		namePagerTextField.setToolTipText("在此填入需要新建的pager");

        moudleNameTextField = new JTextField(moduleDir);
        moudleNameTextField.setColumns(40);
        //moudleNameTextField.setText(moduleDir);

        GridBagLayout containerLayout=new GridBagLayout();
        //autoJPanel.setPreferredSize(new Dimension(600,400));
        autoJPanel.setLayout(containerLayout);
        autoJPanel.add(projectDirLabel);

        autoJPanel.add(projectDirTextField);
        autoJPanel.add(moudleNameTextField);
        autoJPanel.add(packageNameTextField);
        autoJPanel.add(nameActivityTextField);
        autoJPanel.add(nameFragmentTextField);
		autoJPanel.add(namePagerTextField);

        moudleNameTextField.setColumns(40);
        //autoJPanel.add(projectDirLabel);
        autoJPanel.add(moudleNameLabel);

        autoJPanel.add(packageNameLabel);
        autoJPanel.add(newActivityJButton);

        autoJPanel.add(nestFragmentJButton);


        autoJPanel.add(newFragmentJButton);
		autoJPanel.add(newPagerJButton);
        autoJPanel.add(nameActivityLabel);
        autoJPanel.add(nameFragmentLabel);
		autoJPanel.add(namePagerLabel);

        containerLayout.setConstraints(projectDirLabel,G.nG().aGridXY(0, 0).anchor(G.EAST));
        containerLayout.setConstraints(projectDirTextField,G.nG().aGridXY(1, 0).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

        containerLayout.setConstraints(moudleNameLabel,G.nG().aGridXY(2, 0).anchor(G.EAST));
        containerLayout.setConstraints(moudleNameTextField,G.nG().aGridXY(3, 0).gridWidth(3).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

        containerLayout.setConstraints(packageNameLabel,G.nG().aGridXY(0, 1).anchor(G.EAST));
        containerLayout.setConstraints(packageNameTextField,G.nG().aGridXY(1, 1).gridWidth(5).anchor(G.EAST).fill(G.HORIZONTAL));

        containerLayout.setConstraints(nameActivityLabel,G.nG().aGridXY(0, 2).anchor(G.EAST));
        containerLayout.setConstraints(nameActivityTextField,G.nG().aGridXY(1, 2).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

        containerLayout.setConstraints(nameFragmentLabel,G.nG().aGridXY(2, 2).anchor(G.EAST));
        containerLayout.setConstraints(nameFragmentTextField,G.nG().aGridXY(3, 2).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

		containerLayout.setConstraints(namePagerLabel,G.nG().aGridXY(4, 2).anchor(G.EAST));
		containerLayout.setConstraints(namePagerTextField,G.nG().aGridXY(5, 2).anchor(G.EAST).fill(G.HORIZONTAL).weightX(1));

        containerLayout.setConstraints(newActivityJButton,G.nG().aGridXY(1, 3).anchor(G.EAST).weightX(1));
		containerLayout.setConstraints(nestFragmentJButton,G.nG().aGridXY(3, 3).anchor(G.EAST).weightX(1));
        containerLayout.setConstraints(newFragmentJButton,G.nG().aGridXY(4, 3).anchor(G.EAST).weightX(1));
		containerLayout.setConstraints(newPagerJButton,G.nG().aGridXY(5, 3).anchor(G.EAST).weightX(1));
    }

	/**
	 *
	 * 初始化标签里面的内容
	 */
	private void initJPanel(){
		initJPanelButtons(jPanel, btt.getControlLayoutList(),"controllayout");
		initJPanelButtons(jPanel2, btt.getActivityFragmentList(),"activityfragment");
		initJPanelButtons(jPanel3, btt.getControlAdapterList(),"controladapter");
		initJPanelButtons(jPanel4, btt.getCommonToolsList(),"commontolls");
		initJPanelButtons(jPanel5, btt.getCustomizationList(),"customization");

		//最后一个JPanel的初始化
		initAutoJPanel();
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

	private void initJPanelButtons(JPanel panel,LinkedList<String> list,String type){
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//JToolBar toolBar = new JToolBar();
		//toolBar.setPreferredSize(new Dimension(1600, 160));
		for (String key : list) {
			System.out.println("key.." + key);
			TipButton mybutton = new TipButton();
			mybutton.setText(key);
			mybutton.addActionListener(this);
			String sql = btt.getBootstrapTemplate(key);

			int l = getTextNeedHeight(sql);
			//目前使用的还是toop text
			mybutton.createToolTip(600,l);
			mybutton.setToolTipText(sql);

			panel.add(mybutton);

			//toolBar.add(button);
		}

		if(type.equalsIgnoreCase("controllayout")){
		    JLabel idLabel =new JLabel("id");
		    idTextField = new JTextField();idTextField.setColumns(40);
			panel.add(idLabel);
			panel.add(idTextField);
//			panel.add(label2);
//			panel.add(colsTextField2);
//			panel.add(label3);
//			panel.add(colsTextField3);
		}
		//panel.add(toolBar);

	}


	private int getTextNeedHeight(String tipText){
		String[] tipLines = tipText.split("\\n");
		for(String line:tipLines){
			System.out.println("line:"+line);
		}
		int l= tipLines.length;
		System.out.println("lines:"+l);

		int needHeight = (l+1)*20+20;
		return needHeight;
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
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
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
				BootstrapTab auto = new BootstrapTab();
				Dimension dimension = new Dimension(1600, 900);
				//屏幕大小
				//Dimension dimension = ScreenUtils.screenDimension();
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
		String id = idTextField.getText();
		if(StringUtils.isEmpty(id)){

        }else {
		    //需要初始化的资料
            AndroidControlInfo aci=new AndroidControlInfo();
            aci.setClassName(command);
            aci.setId(id);aci.setInstanceName(id);
            context.put("aci", aci);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/main/resources/templates/control.vm", "utf-8", context, sw);
            //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
            System.out.println(sw.toString());
            infoMsg = sw.toString();
            appendInfoMsg();

            //在sql中增加id属性
            int firstSpaceIndex = sql.indexOf(" ");
            String sql1 =new String(sql);
            String beforeStr = sql1.substring(0,firstSpaceIndex);
            String idAttrStr = " android:id=\"@+id/"+id+"\"";
            String afterStr = sql1.substring(firstSpaceIndex+1,sql1.length());
            sql = beforeStr+idAttrStr+"\n"+afterStr;
        }

		if(command.equalsIgnoreCase("row-col-split-2")){
			col2SplitAction(sql);
		}else if(command.equalsIgnoreCase("row-col-split-3")){
			col3SplitAction(sql);
		}else{
			//是替换还是增加
			boolean appendOrNew = appendOrNewCheckBox.isSelected();

			System.out.println("添加或替换:"+appendOrNew);

			if(appendOrNew){
				//appendContentStr(sql);
				appendContentStrToActive(sql);
			}else {
				//默认是false
				//insertContentStr(sql);
				insertContentStrToActive(sql);
				//setContentStr(sql);
			}
		}
	}

	private boolean checkColsInput(){
		String col1 = colsTextField.getText().trim();
		String col2=  colsTextField2.getText().trim();
		String col3=  colsTextField3.getText().trim();
		if(col1.equalsIgnoreCase("")){
			col1="0";
		}

		if(col2.equalsIgnoreCase("")){
			col2="0";
		}

		if(col3.equalsIgnoreCase("")){
			col3="0";
		}

		int coli1= Integer.parseInt(col1);
		int coli2= Integer.parseInt(col2);
		int coli3= Integer.parseInt(col3);
		int sum = coli1+coli2+coli3;
		if(sum==12){
			return true;
		}else {
			return false;
		}

	}

	private void col2SplitAction(String template){
		String col1 = colsTextField.getText().trim();
		String col2=  colsTextField2.getText().trim();

		if(checkColsInput()){
			String sql = BeetlBasic.merge2(template, col1, col2);
			insertContentStrToActive(sql);
		}else {
			System.out.println("输入总和应该为12，请检查输入");
			infoMsg = "输入总和应该为12，请检查输入";
			infoTextArea.append(infoMsg);
		}
	}


	private void appendInfoMsg(){
		infoTextArea.append(infoMsg+"\n");
	}

	private void col3SplitAction(String template){
		String col1 = colsTextField.getText().trim();
		String col2=  colsTextField2.getText().trim();
		String col3=  colsTextField3.getText().trim();

		if(checkColsInput()){
			String sql = BeetlBasic.merge3(template, col1, col2,col3);
			insertContentStrToActive(sql);
		}else {
			System.out.println("输入总和应该为12，请检查输入");
			infoMsg = "输入总和应该为12，请检查输入";
			infoTextArea.append(infoMsg);
		}
	}


	private void setContentStr(String yourstr){
		//contentTextArea.setText("");
		contentTextArea.setText(yourstr);
		int len = yourstr.length();
		contentTextArea.setCaretPosition(len);
	}


	private void insertContentStr(String youstr){
		int caret = contentTextArea.getCaretPosition();
		int len = contentTextArea.getText().length();
		if(caret<len){
			contentTextArea.insert(youstr,caret);
		}else {
			contentTextArea.append("\n");
			contentTextArea.append(youstr);
		}
	}

	private void initTextPopMenu(){
		textAreaPopupMenu = new JPopupMenu();
		cutItem = new JMenuItem("剪切");
		copyItem = new JMenuItem("拷贝");
		pasteItem = new JMenuItem("粘贴");
		clearItem = new JMenuItem("清空");
		newLineItem = new JMenuItem("新行");
		textAreaPopupMenu.add(cutItem);
		textAreaPopupMenu.add(copyItem);
		textAreaPopupMenu.add(pasteItem);
		textAreaPopupMenu.add(clearItem);
		textAreaPopupMenu.add(newLineItem);


		cutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("cut item clicked...");
				JTextArea selectArea = getActiveTextArea();
				String selectContent = selectArea.getSelectedText();
				onCut(selectArea);
				//onCut();
			}
		});
		copyItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("cut item clicked...");
				onCopy(getActiveTextArea());
				//onCopy();
			}
		});
		pasteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("cut item clicked...");
				onPaste(getActiveTextArea());
				//onPaste();
			}
		});

		clearItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("cut item clicked...");
				getActiveTextArea().setText("");
				//onPaste();
			}
		});

		newLineItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("new line item clicked...");
				JTextArea textArea= getActiveTextArea();
				//int caret = textArea.getCaretPosition();
				//onPaste(getActiveTextArea());
				//onPaste();
			}
		});

	}

	public JTextArea getActiveTextArea(){
		JScrollPane selectComponent = (JScrollPane)contentTab.getSelectedComponent();
		//selectComponent.ge

//		JPanel jPanel = new JPanel();
//		jPanel.get
		JTextArea textArea = paneTextAreaMap.get(selectComponent);
		return textArea;
	}

	public String getActivePath(){
		JScrollPane selectComponent = (JScrollPane)contentTab.getSelectedComponent();
		//selectComponent.ge
//		JPanel jPanel = new JPanel();
//		jPanel.get
		//JTextArea textArea = paneTextAreaMap.get(selectComponent);
		String path = panePathMap.get(selectComponent);
		return path;
	}


	private void insertContentStrToActive(String youstr){
		JScrollPane selectComponent = (JScrollPane)contentTab.getSelectedComponent();
		//selectComponent.ge

//		JPanel jPanel = new JPanel();
//		jPanel.get
		JTextArea textArea = paneTextAreaMap.get(selectComponent);
		String path = panePathMap.get(selectComponent);
		//selectComponent.

		int caret = textArea.getCaretPosition();
		int len = textArea.getText().length();
		if(caret<len){
			textArea.insert(youstr,caret);
		}else {
			textArea.append("\n");
			textArea.append(youstr);
		}


		//将文件内容存盘并且更新
		String newcontent= textArea.getText();
		FileUtil.writeToFileClear(path, newcontent);

	}


private void replaceContentStrToActive(String youstr){


		JScrollPane selectComponent = (JScrollPane)contentTab.getSelectedComponent();
		//selectComponent.ge

//		JPanel jPanel = new JPanel();
//		jPanel.get

		JTextArea textArea = paneTextAreaMap.get(selectComponent);
		//selectComponent.

		textArea.setText("");
		textArea.setText(youstr);
	}


	private void treeMenu(MouseEvent e){
		   TreePath path = tree.getPathForLocation(e.getX(),e.getY());
	       tree.setSelectionPath(path);
	       treePopupMenu.show(e.getComponent(),e.getX(),e.getY());
	   }

	   private void textAreaMenu(MouseEvent e){
			textAreaPopupMenu.show(e.getComponent(),e.getX(),e.getY());
	   }


	MouseListener textAreaMouseListener = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("文本区域右键单击");
			if(e.isMetaDown()){//检测鼠标右键单击
				textAreaMenu(e);
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stubte
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	};


	MouseListener popMouseListener = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.isMetaDown()){//检测鼠标右键单击
				treeMenu(e);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}


	};




	private void appendContentStrToActive(String yourstr){
			JScrollPane selectComponent = (JScrollPane)contentTab.getSelectedComponent();

			String path = panePathMap.get(selectComponent);

			JTextArea textArea = (JTextArea)selectComponent.getComponent(0);

			int caret = textArea.getCaretPosition();
			int len = textArea.getText().length();
			if(caret<len){
				textArea.append(yourstr);
			}else {
				textArea.append("\n");
				textArea.append(yourstr);
			}

			//将文件内容存盘并且更新
			String newcontent= textArea.getText();
			FileUtil.writeStringToFileAppend(path, newcontent);

		}


	private void appendContentStr(String yourstr){
		JScrollPane selectComponent = (JScrollPane)contentTab.getSelectedComponent();
		JTextArea textArea = (JTextArea)selectComponent.getComponent(0);
		int caret = contentTextArea.getCaretPosition();
		int len = contentTextArea.getText().length();
		if(caret<len){
			contentTextArea.append(yourstr);
		}else {
			contentTextArea.append("\n");
			contentTextArea.append(yourstr);
		}
	}



	class AutoLoaderTasker extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("检查外部更新:"+new Date().toString());
			Component[] components = contentTab.getComponents();
			
			int count=contentTab.getComponentCount();
			//System.out.println("count:"+count);
			
			
			for(int i=0;i<count;i++){
				//System.out.println("i:"+i);
				JComponent jComponent = (JComponent)contentTab.getComponent(i);
				JScrollPane scrollPane =(JScrollPane)jComponent;
				String path = panePathMap.get(scrollPane);
				
				if(path==null) continue;
				
				Long lastModefyTimeByMe = fileLastModifyMap.get(path);
				JTextArea textArea = paneTextAreaMap.get(scrollPane);
				
				File file = new File(path);
				Long lastModifyTime = file.lastModified();
				Long currentTime = System.currentTimeMillis();
				
				/**
				System.out.println("check file:"+path);
				System.out.println("lastmodefyTimeMe:"+lastModefyTimeByMe);
				System.out.println("lastmodefyTime:"+lastModifyTime);
				***/
				if(lastModifyTime>lastModefyTimeByMe){
					//说明被外部程序锁修改,loader进来，没关系
					System.out.println("发现文件外部发生改变,需要导入:"+path);
					String content = FileUtil.readFileByLinesPure(path);
					textArea.setText(content);
					fileLastModifyMap.put(path, System.currentTimeMillis());
				}else{
					System.out.println("外部没有修改，不需要导入");
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
}
