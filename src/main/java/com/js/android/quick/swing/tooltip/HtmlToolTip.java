package com.js.android.quick.swing.tooltip;

import javax.swing.*;
import java.awt.*;

public class HtmlToolTip extends JToolTip {
  
     private static final long serialVersionUID = 1L;  
//     private JButton jb;
      
     public HtmlToolTip() {
          super();

          //jb = new JButton("Push me!");
          //jb.setLocation(10, 30);
          //jb.setSize(100,30);
          //add(jb);
     }

     public HtmlToolTip(int width, int height) {
          super();
          setPreferredSize(new Dimension(width,height));
          //jb = new JButton("Push me!");
          //jb.setLocation(10, 30);
          //jb.setSize(100,30);
          //add(jb);
     }

//     public Dimension getPreferredSize() {
//          return new Dimension(500,600);
//     }
      
     public void paintComponent(Graphics g) {

          String tipText = getTipText();
          System.out.println("tiptext:"+tipText);

          String[] tipLines = tipText.split("\\n");
          for(String line:tipLines){
               System.out.println("line:"+line);
          }
          int l= tipLines.length;
          System.out.println("lines:"+l);

          int needHeight = (l+1)*20+20;
          Graphics2D g2d = (Graphics2D)g;
          //int width = (int)(getPreferredSize().getWidth());
          //int height = (int)(getPreferredSize().getHeight());
          Paint oldPaint = g2d.getPaint();
          g2d.setPaint(Color.CYAN);
          g2d.fillRect(0, 0, 500, needHeight);
          g2d.setPaint(oldPaint);






          if(tipText!=null){
               for(int i=0;i<l;i++){
                    System.out.println("line:"+tipLines[i]);
                    g2d.drawString(tipLines[i], 10, 20*i+20);
               }
          }
           
//          if (getTipText() != null) {
//               g2d.drawString(tipText, 10, 20);
//          }
           
     }  
      
//    public void paintChildren(Graphics g) {
//          jb.repaint();
//     }
//
//     public JButton getButton() {
//          return jb;
//     }
  
}  