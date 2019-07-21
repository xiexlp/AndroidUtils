package com.js.android.quick.swing.mytooltip;

import javax.swing.*;
import java.awt.*;

public class MyToolTip extends JToolTip {  
  
     private static final long serialVersionUID = 1L;  
     private JButton jb;  
      
     public MyToolTip() {  
          super();
          //setLocation(0,0);
          //setBounds(-10,-10,100,100);
          jb = new JButton("Push me!");  
          jb.setLocation(10, 30);
          jb.setSize(100,30);  
          add(jb);  
     }  
      
     public Dimension getPreferredSize() {  
          return new Dimension(200,100);  
     }

//     @Override
//     public void setTipText(String tipText){
//          //System.out.println("settiptext");
//          //setTipText("11111111111111");
//     }



     public void paintComponent(Graphics g) {  
          Graphics2D g2d = (Graphics2D)g;  
           
          int width = (int)(getPreferredSize().getWidth());  
          int height = (int)(getPreferredSize().getHeight());  
          Paint oldPaint = g2d.getPaint();  
          g2d.setPaint(Color.CYAN);  
          g2d.fillRect(0, 0, width, height);
          g2d.setPaint(oldPaint);  
           
          if (getTipText() != null) {  
               g2d.drawString("<html><body bgcolor='white'>点击我</body></html>", 10, 20);
          }  
           
     }  
      
     public void paintChildren(Graphics g) {  
          jb.repaint();  
     }  
      
     public JButton getButton() {  
          return jb;  
     }  
  
}  