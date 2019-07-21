package com.js.android.quick.swing.mytooltip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyToolTipTest extends JFrame implements ActionListener {  
  
     private static final long serialVersionUID = -8760252318430347150L;  
     private MyButton mb;  
     private JTextField jtf;  
      
     public MyToolTipTest() {  
          setSize(600,400);  
          setLocation(200,200);  
          setTitle("自定义ToolTip测试");  
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          Container c = getContentPane();  
          c.setLayout(new FlowLayout(FlowLayout.CENTER));  
           
          mb = new MyButton();  
          mb.setText("Button");  
          mb.addActionListener(this);  
          mb.setToolTipText("这是一个自定义的ToolTip");
          //mb.setToolTipText("<html><body bgcolor='white'>点击我</body></html>");

          mb.addToolTipBtnListener(this);  
           
          jtf = new JTextField(20);
          c.add(mb);  
          c.add(jtf);  
     }  
  
     @Override  
     public void actionPerformed(ActionEvent e) {  
          if (e.getSource() == mb) {  
               jtf.setText("From \"Button\"");  
          } else if (e.getSource() == mb.getToolTipButton()) {  
               jtf.setText("From \"Push me\" in the tooltip");  
          }  
     }  
  
     public static void main(String[] args) {  
          MyToolTipTest test = new MyToolTipTest();  
          test.setVisible(true);  
     }  
  
}  