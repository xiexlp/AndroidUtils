package com.js.android.quick.swing.editor;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JTextPane1 {
    private JTextPane textPane;

    public JTextPane1() {
        textPane = new JTextPane();
        textPane.setBackground(Color.black);
        textPane.setEditable(false);
    }

    public void setYellow_Bold_20(String str) {
        SimpleAttributeSet attrset = new SimpleAttributeSet();
        StyleConstants.setForeground(attrset, Color.yellow);
        StyleConstants.setBold(attrset, true);
        insert(str, attrset);
    }

    public void setBlue_Italic_Bold_22(String str) {
        SimpleAttributeSet attrset = new SimpleAttributeSet();
        StyleConstants.setForeground(attrset, Color.blue);
        StyleConstants.setItalic(attrset, true);
        StyleConstants.setFontSize(attrset, 24);
        insert(str, attrset);
    }

    public void setRed_UnderLine_Italic_24(String str) {
        SimpleAttributeSet attrset = new SimpleAttributeSet();
        StyleConstants.setForeground(attrset, Color.red);
        StyleConstants.setUnderline(attrset, true);
        StyleConstants.setItalic(attrset, true);
        StyleConstants.setFontSize(attrset, 24);
        insert(str, attrset);
    }

    //这个方法最主要的用途是将字符串插入到JTextPane中。
    public void insert(String str, AttributeSet attrset) {
        Document docs = textPane.getDocument();//利用getDocument()方法取得JTextPane的Document instance.0
        str = str + "\n";
        try {
            docs.insertString(docs.getLength(), str, attrset);
        } catch (BadLocationException ble) {
            System.out.println("BadLocationException:" + ble);
        }
    }

    public Component getComponent() {
        return textPane;
    }

    public static void main(String[] args) {
        JTextPane1 pane = new JTextPane1();
        pane.setYellow_Bold_20("This is Line 1,yellow,Bold,Size 20");
        pane.setBlue_Italic_Bold_22("This is Line 2,blue,Italic,Bold,Size 22");
        pane.setRed_UnderLine_Italic_24("This is Line 3,red,UnderLine,Italic,Size 24");

        JFrame f = new JFrame("JTextPane1");
        f.getContentPane().add(pane.getComponent());
        f.setSize(450, 180);
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}