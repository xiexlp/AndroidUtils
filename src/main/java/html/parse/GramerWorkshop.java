package html.parse;

import html.util.SButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017-10-30.
 */
public class GramerWorkshop extends JFrame implements ActionListener {

    JMenuBar jmenuBar=new JMenuBar();
    JMenu fileMenu = new JMenu("文件");
    JMenuItem openFileItem = new JMenuItem("打开文件");
    JMenuItem saveFileItem = new JMenuItem("保存文件");
    JMenuItem saveAsFileItem = new JMenuItem("文件另存为...");

    public GramerWorkshop(){
        init();
    }

    void init(){
        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(saveAsFileItem);
        jmenuBar.add(fileMenu);
    //menubar
        setJMenuBar(jmenuBar);

        jtoolBar.add(copyButton);
        jtoolBar.add(cutButton);
        jtoolBar.add(pasteButton);
        jtoolBar.add(openFileButton);
        jtoolBar.add(tokeParserButton);
        jtoolBar.add(grammerParserButton);
        jtoolBar.add(parserGraceButton);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(jtoolBar,BorderLayout.NORTH);

        contentTextArea = new JTextArea();
        contentTextArea.setText("content");

        contentTextPane = new JTextPane();
        contentTextPane.setText("");

        contentScrollpane = new JScrollPane(contentTextPane);
        fileTab = new JTabbedPane();
        //fileTab.add(contentScrollpane,0);
        fileTab.add("content1",contentScrollpane);

        contentSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        contentSplitPane.setDividerLocation(0.4);

        contentSplitPane.add(treeScrollPane,JSplitPane.LEFT);
        contentSplitPane.add(fileTab,JSplitPane.RIGHT);
        //pane.add(contentSplitPane,BorderLayout.CENTER);

        //pane.add(contentScrollpane,BorderLayout.CENTER);


        parseInfoTextArea.setText("info");
        JScrollPane parseInfoScrollpane = new JScrollPane(parseInfoTextArea);
        parseInfoScrollpane.setPreferredSize(new Dimension(150,100));

        //pane.add(parseInfoScrollpane,BorderLayout.SOUTH);


        infoSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        infoSplitPane.setDividerLocation(0.5);

        infoSplitPane.add(contentSplitPane,JSplitPane.TOP);
        infoSplitPane.add(parseInfoScrollpane,JSplitPane.BOTTOM);

        pane.add(infoSplitPane,BorderLayout.CENTER);

    }

    JToolBar jtoolBar =new JToolBar();
    SButton copyButton=new SButton("复制");
    SButton pasteButton=new SButton("粘贴");
    SButton cutButton=new SButton("剪切");
    SButton openFileButton=new SButton("打开");
    SButton tokeParserButton =new SButton("词法分析");
    SButton grammerParserButton =new SButton("语法分析");
    SButton parserGraceButton=new SButton("语法分析优雅");

    JSplitPane contentSplitPane;
    JTree tree = new JTree();
    //JScrollPane treeScrollPane = new JScrollPane(tree);


    JSplitPane infoSplitPane;


    JTabbedPane fileTab;
    JScrollPane contentScrollpane;
    JTextArea contentTextArea = new JTextArea();
    JTextPane  contentTextPane = new JTextPane();;


    JScrollPane treeScrollPane = new JScrollPane(tree);
    JTextArea parseInfoTextArea =new JTextArea();

    //manager the opened file list and directory list
    LinkedList<String> fileLinkedList;
    LinkedList<String> dirLinkedList;

    LinkedList<Toke> tokeLinkedList;

    JFileChooser fc=null;

    String initDir = "E:\\mobile\\typescript";

    String infoMsg ="";

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
