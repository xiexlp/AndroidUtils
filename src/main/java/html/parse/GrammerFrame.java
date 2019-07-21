package html.parse;

import html.tags.Tag;
import html.util.GuiUtil;
import html.util.SButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2017-3-6.
 */
public class GrammerFrame extends JFrame implements ActionListener{


    JMenuBar jmenuBar;
    JMenu fileMenu;
    JMenuItem openFileItem;
    JMenuItem saveFileItem;
    JMenuItem saveAsFileItem;


    JToolBar jtoolBar;
    SButton copyButton;
    SButton pasteButton;
    SButton cutButton;
    SButton openFileButton;
    SButton tokeParserButton;
    SButton grammerParserButton;
    SButton parserGraceButton;


    JSplitPane contentSplitPane;
    JScrollPane treeScrollPane;
    JTree tree;

    JSplitPane infoSplitPane;


    JTabbedPane fileTab;
    JScrollPane contentScrollpane;
    JTextArea contentTextArea;
    JTextPane contentTextPane;


    JScrollPane parseInfoScrollpane;
    JTextArea parseInfoTextArea;

    //manager the opened file list and directory list
    LinkedList<String> fileLinkedList;
    LinkedList<String> dirLinkedList;

    LinkedList<Toke> tokeLinkedList;

    JFileChooser fc=null;


    String initDir = "E:\\mobile\\typescript";

    String infoMsg ="";


    {
        init();
    }


    private void init(){
        initComponent();
        initVaribles();
    }

    private void initVaribles(){
        fileLinkedList = new LinkedList<>();
        dirLinkedList = new LinkedList<>();
        dirLinkedList.add(initDir);
        fc = new JFileChooser(new File(getLastDir()));
    }


    private void initComponent(){
        jmenuBar = new JMenuBar();
        fileMenu = new JMenu();
        fileMenu.setText("文件管理");
        openFileItem = new JMenuItem("open File");
        openFileItem.addActionListener(this);
        saveAsFileItem = new JMenuItem("save as ....");
        saveFileItem = new JMenuItem("save File");
        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(saveAsFileItem);
        jmenuBar.add(fileMenu);
        //menubar
        setJMenuBar(jmenuBar);


        copyButton = new SButton("copy");
        copyButton.setMargin(new Insets(2,5,2,5));

        //copyButton.setBackground(new Color(180,180,180));
        //copyButton.setFont(new Font());

        cutButton = new SButton("cut");
        pasteButton = new SButton("paster");
        openFileButton = new SButton("openfile");
        openFileButton.addActionListener(this);
        tokeParserButton = new SButton("tokeparser");
        grammerParserButton = new SButton("grammerparser");
        parserGraceButton = new SButton("graceparser");

        tokeParserButton.addActionListener(this);
        grammerParserButton.addActionListener(this);
        parserGraceButton.addActionListener(this);

        jtoolBar = new JToolBar();
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


        tree = new JTree();
        treeScrollPane = new JScrollPane(tree);


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

        parseInfoTextArea = new JTextArea();
        parseInfoTextArea.setText("info");
        parseInfoScrollpane = new JScrollPane(parseInfoTextArea);

        parseInfoScrollpane.setPreferredSize(new Dimension(150,100));

        //pane.add(parseInfoScrollpane,BorderLayout.SOUTH);


        infoSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        infoSplitPane.setDividerLocation(0.5);

        infoSplitPane.add(contentSplitPane,JSplitPane.TOP);
        infoSplitPane.add(parseInfoScrollpane,JSplitPane.BOTTOM);

        pane.add(infoSplitPane,BorderLayout.CENTER);


        //init list

    }




    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                GrammerFrame jFrame=new GrammerFrame();
                //windows styles
                String windows="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                try {
                    UIManager.setLookAndFeel(windows);
                } catch (ClassNotFoundException | InstantiationException
                        | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(jFrame);;


                Dimension dimension = GuiUtil.getScreenDimensionHalf();



                jFrame.setSize(dimension);
                jFrame.setLocation(LocationUtils.getLocationPointTopAjust(dimension, 0));
                jFrame.setVisible(true);

                jFrame.setTitle("html语法分析器");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
                //jFrame.innerJSplitPane.setDividerLocation(0.3);
                //jFrame.initSize();
                //jFrame.articlesListPanel2.getjSplitPane().setDividerLocation(0.5);
                //jFrame.addWindowStateListener();
                //���Ӽ���
                //jFrame.addWindowStateListener(jFrame);
                //jFrame.addComponentListener(jFrame);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source==openFileItem){
            System.out.println("open file menu itme click");
        }else if(source==openFileButton){
            System.out.println("open file button click");
            openFile();
        }else if(source==tokeParserButton) {
            System.out.println("toke parser");
            tokeParserAction();
        }else if(source== grammerParserButton){
            System.out.println("grammer parser");
            grammerParserAction();
        }else if(source == parserGraceButton){
            System.out.println("parser grace");
            graceParserAction();
        }
    }


    private void openFile() {
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        String dir = "";
        File file = null;
        int flag = fc.showOpenDialog(null);
        if (flag == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();

            System.out.println("parent:"+file.getParent());

            fileLinkedList.add(file.getAbsolutePath());
            dirLinkedList.add(file.getParent());


            //刷新viewdir
            System.out.println("select file path:" + file.getAbsolutePath());
            String readyFile = file.getAbsolutePath();
            String text = readString4(readyFile);
            setSrcContent(text);
        }
    }


    private void setCurrentTabText(){
        int activeIndex = fileTab.getSelectedIndex();


    }


    private void appendInfoMsg(){
        parseInfoTextArea.append(infoMsg+"\n");
    }

    private void appendInfoMsg(String msg){
        infoMsg = msg;
        parseInfoTextArea.append(infoMsg+"\n");
    }

    private void tokeParserAction(){

        parseInfoTextArea.append("---------------------------------------------------");

        String source = getSrcContent();
        TokeParser tokeParser = new TokeParser();
        tokeParser.setSource(source);
        //解析
        tokeParser.parser();

        //解析出来的结果
        LinkedList<Toke> tokes = tokeParser.getTokeList();
        parseInfoTextArea.append("-----toke-----");
        int i=0;
        for(Toke t:tokes){
            parseInfoTextArea.append("toke index:"+i+"--"+t.getId());
            i++;
        }

        parseInfoTextArea.append("total toke size:"+tokes.size());

        setTokeLinkedList(tokes);

        parseInfoTextArea.append("---------------------------------------------------");
    }

    private void grammerParserAction(){
        GrammerParser grammerParser = new GrammerParser();
        grammerParser.setTokeList(getTokeLinkedList());

        grammerParser.parser();

        parseInfoTextArea.append("最后的tagStack大小:"+grammerParser.stackTag.size());

        Stack<Tagex> stack = grammerParser.stackTag;

        java.util.List<Tagex> list = grammerParser.tagsList;

        parseInfoTextArea.append("list:"+list.get(0).getName());

        Map<String,Tagex> map = grammerParser.tagexMap;

        while (stack.size()>0){
            Tag tag = stack.pop();
            parseInfoTextArea.append("tag id:"+tag.getId());
            parseInfoTextArea.append("tag name:"+tag.getName());
        }

        Tagex rootex = list.get(0);
        String el = rootex.renderHtml();
        parseInfoTextArea.append("el:"+"\n"+el);

        grammerParser.htmlDoc.setRootTag(rootex);
        String htmlDocEl = grammerParser.htmlDoc.renderHtml();
        parseInfoTextArea.append("html doc:\n"+htmlDocEl);
    }

    private String getSrcContent(){
        return contentTextPane.getText();
    }

    private void setSrcContent(String src){
        contentTextPane.setText(src);
    }

    private void graceParserAction(){
        GrammerParser grammerParser = new GrammerParser();
        grammerParser.setTokeList(getTokeLinkedList());

        grammerParser.parserGrace();

        parseInfoTextArea.append("最后的tagStack大小:"+grammerParser.stackTag.size());

        Stack<Tagex> stack = grammerParser.stackTag;

        java.util.List<Tagex> list = grammerParser.tagsList;

        parseInfoTextArea.append("list:"+list.get(0).getName());

        Map<String,Tagex> map = grammerParser.tagexMap;

        while (stack.size()>0){
            Tag tag = stack.pop();
            parseInfoTextArea.append("tag id:"+tag.getId());
            parseInfoTextArea.append("tag name:"+tag.getName());
        }

        Tagex rootex = list.get(0);
        String el = rootex.renderHtml();
        parseInfoTextArea.append("el:"+"\n"+el);

        grammerParser.htmlDoc.setRootTag(rootex);
        String htmlDocEl = grammerParser.htmlDoc.renderHtml();
        parseInfoTextArea.append("html doc:"+htmlDocEl);
    }

    public LinkedList<Toke> getTokeLinkedList() {
        return tokeLinkedList;
    }

    public void setTokeLinkedList(LinkedList<Toke> tokeLinkedList) {
        this.tokeLinkedList = tokeLinkedList;
    }

    private String getLastDir(){
        System.out.println(dirLinkedList.size());
        String lastFilePath =dirLinkedList.getLast();
        return  lastFilePath;
    }

    private static String readString4(String filepath)
    {
        int len=0;
        StringBuffer str=new StringBuffer("");
        File file=new File(filepath);
        try {
            FileInputStream is=new FileInputStream(file);
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader in= new BufferedReader(isr);
            String line=null;
            while( (line=in.readLine())!=null )
            {
                if(len != 0)  // 处理换行符的问题
                {
                    str.append("\r\n"+line);
                }
                else
                {
                    str.append(line);
                }
                len++;
            }
            in.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str.toString();
    }
}
