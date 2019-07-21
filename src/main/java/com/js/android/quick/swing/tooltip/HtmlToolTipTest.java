package com.js.android.quick.swing.tooltip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HtmlToolTipTest extends JFrame implements ActionListener {
  
     private static final long serialVersionUID = -8760252318430347150L;  
     private TipButton mb;
     private JTextField jtf;  
      
     public HtmlToolTipTest() {
          setSize(600,600);
          setLocation(200,200);  
          setTitle("自定义ToolTip测试");  
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          Container c = getContentPane();  
          c.setLayout(new FlowLayout(FlowLayout.CENTER));  
           
          mb = new TipButton();
          mb.setText("Button");  
          mb.addActionListener(this);  
          mb.setToolTipText("这是一个自定义的ToolTip");  
          //mb.addToolTipBtnListener(this);
           
          jtf = new JTextField(20);  
          c.add(mb);  
          c.add(jtf);  
     }  
  
     @Override
     public void actionPerformed(ActionEvent e) {

          System.out.println("i am clicked");
//          if (e.getSource() == mb) {
//               jtf.setText("From \"Button\"");
//          } else if (e.getSource() == mb.getToolTipButton()) {
//               jtf.setText("From \"Push me\" in the tooltip");
//          }
     }

     public static void main(String[] args) {  
          HtmlToolTipTest test = new HtmlToolTipTest();
          test.setVisible(true);  
     }  
  
}  