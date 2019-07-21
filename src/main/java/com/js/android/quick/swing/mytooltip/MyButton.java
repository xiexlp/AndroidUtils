package com.js.android.quick.swing.mytooltip;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyButton extends JButton {  
  
     private static final long serialVersionUID = -4212536258012660909L;  
      
     private MyToolTip toolTip;  
     private ActionListener toolTipBtnListener;  
      
     public MyButton() {  
          super();  
     }  
  
     public JButton getToolTipButton() {  
          if (toolTip != null) {  
               return toolTip.getButton();  
          } else {  
               return null;  
          }  
     }  
      
     public void addToolTipBtnListener(ActionListener l) {  
          toolTipBtnListener = l;  
     }  
      
     public JToolTip createToolTip() {  
          if (toolTip == null) {  
               toolTip = new MyToolTip();  
               toolTip.getButton().addActionListener(toolTipBtnListener);  
          }
          //设置tooltip的位置
          //toolTip.setLocation(-30,-30);
           
          return toolTip;  
     }  
}  