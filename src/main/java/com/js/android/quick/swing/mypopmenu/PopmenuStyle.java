package com.js.android.quick.swing.mypopmenu;

import com.js.android.quick.html.LocationUtils;
import html.parse.GrammerParser;
import html.parse.Tagex;
import html.parse.Toke;
import html.parse.TokeParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017-11-4.
 * 这个测试已经成功，所以下段时间的目标就是组装到主程序中
 */
public class PopmenuStyle  extends JFrame {
    JPanel basicPanel = new JPanel();
    JPopupMenu jPopupMenu =new JPopupMenu();
    JPanel popPanel = new JPanel();
    //JLabel popLabel = new JLabel("aaa\nbbb\nccc");
    JTextArea textArea = new JTextArea("aaa\nbbb\nccc");
    JButton button1 = new JButton("打印当前组件");
    JButton button2 = new JButton("前进");
    JScrollPane textScrollPane = new JScrollPane(textArea);
    JButton testButton = new JButton("鼠标测试");


    String htmlText = "<p>\n" +
            "    <button type=\"button\" class=\"btn btn-default\">\n" +
            "        <span class=\"glyphicon glyphicon-sort-by-attributes\"></span>\n" +
            "    </button>\n" +
            "    <button type=\"button\" class=\"btn btn-default\">\n" +
            "        <span class=\"glyphicon glyphicon-sort-by-attributes-alt\"></span>\n" +
            "    </button>\n" +
            "    <button type=\"button\" class=\"btn btn-default\">\n" +
            "        <span class=\"glyphicon glyphicon-sort-by-order\"></span>\n" +
            "    </button>\n" +
            "    <button type=\"button\" class=\"btn btn-default\">\n" +
            "        <span class=\"glyphicon glyphicon-sort-by-order-alt\"></span>\n" +
            "    </button>\n" +
            "</p>";

    //JPopupMenu textPopmenu = new JPopupMenu();
    //JMenuItem menuItem = new JMenuItem("粘贴组件");


    public PopmenuStyle(){
        jPopupMenu.setPreferredSize(new Dimension(600,300));
        jPopupMenu.add(popPanel);
        //textArea.add(button1);
        //textArea.add(button2);
        textArea.setText(htmlText);
        popPanel.add(textScrollPane);
        popPanel.add(button1);
        popPanel.add(button2);

        button1.addActionListener(pasteActionListener);

        textArea.addCaretListener(new  CaretListener(){
            public void caretUpdate(CaretEvent e)
            {
                try
                {
                    int pos=textArea.getCaretPosition();
                    //获取行数
                    int lineOfC = textArea.getLineOfOffset(pos)+1;
                    //获取列数
                    int col = pos - textArea.getLineStartOffset(lineOfC - 1)+1;
                    System.out.println( "当前光标位置"   +   lineOfC   +   "行,"   +col +   "列");
                }
                catch(Exception ex)
                {
                    System.out.println( "无法获得当前光标位置 ");
                }
            }
        });

        //textPopmenu.add(menuItem);
        getContentPane().add(basicPanel);
        basicPanel.add(testButton);
        testButton.addMouseListener(mouseAdapter1);

        //getContentPane().addMouseListener(mouseAdapter);
        //textArea.addMouseListener(textAreaMouseAdapter);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopmenuStyle auto = new PopmenuStyle();
                Dimension dimension = new Dimension(800, 800);

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


    /**
     * 文本区鼠标监听事件，右键弹出菜单。
     */
    private MouseAdapter mouseAdapterPopmenuShow = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            if (e.getButton() == MouseEvent.BUTTON3) {
                jPopupMenu.show(getContentPane(), e.getX(), e.getY());
            }
        }
    };




   private MouseAdapter mouseAdapter1=new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
           System.out.println("mouse clicked");
           jPopupMenu.show(basicPanel, e.getX(), e.getY());
           super.mouseClicked(e);
       }

       @Override
       public void mousePressed(MouseEvent e) {
           System.out.println("mouse pressed");
           super.mousePressed(e);
       }

       @Override
       public void mouseReleased(MouseEvent e) {
           System.out.println("mouse released");
           super.mouseReleased(e);
       }

       @Override
       public void mouseEntered(MouseEvent e) {
           System.out.println("mouse entered");
           //jPopupMenu.show(basicPanel, e.getX(), e.getY());
           super.mouseEntered(e);
       }

       @Override
       public void mouseExited(MouseEvent e) {
           System.out.println("mouse exit");
           super.mouseExited(e);
       }

       @Override
       public void mouseWheelMoved(MouseWheelEvent e) {
           System.out.println("mousewheel moved");
           super.mouseWheelMoved(e);
       }

       @Override
       public void mouseDragged(MouseEvent e) {
           System.out.println("dragged");
           super.mouseDragged(e);
       }

       @Override
       public void mouseMoved(MouseEvent e) {
           System.out.println("mouse moved");
           super.mouseMoved(e);
       }
   };
    /***
     * 这个搞定了，非常好
     */
    private ActionListener pasteActionListener= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
//            int caret = textArea.getCaretPosition();
//            if(caret==-1) System.out.println("请选择占位符");
//            Caret caret1 = textArea.getCaret();
//            System.out.println("caret:"+caret);
//            System.out.println("dot:"+caret1.getDot());
//            System.out.println("mark:"+caret1.getMark());
//            Point p = textArea.getCaret().getMagicCaretPosition();
                int   pos   =   textArea.getCaretPosition();
                //获取行数
                int   lineOfC   =   textArea.getLineOfOffset(pos)   +   1;
               // System.out.println("px %s py %s",p.getX(),p.getY() );
                System.out.println("haha");
                String htmlComponent = htmlText.substring(pos);
                System.out.println(htmlComponent);

                Document doc1 = Jsoup.parse(htmlComponent);
                System.out.println(doc1.body().childNode(0).toString());


            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
    };

    private ActionListener getPositionActionListener =new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button2");
        }
    };

    /**
     * 用自己的包来解析
     * @param htmlComponent
     */
    private void doParserWithGrammer(String htmlComponent){
        TokeParser tokeParser = new TokeParser();
        tokeParser.setSource(htmlComponent);
        tokeParser.parser();
        LinkedList<Toke> tokes = tokeParser.getTokeList();
        GrammerParser grammerParser = new GrammerParser();
        grammerParser.setTokeList(tokes);
        grammerParser.parser();
        List<Tagex> list = grammerParser.tagsList;
        Tagex rootex = list.get(0);
        String el = rootex.renderHtml();
        System.out.println("el:"+"\n"+el);
    }






}
