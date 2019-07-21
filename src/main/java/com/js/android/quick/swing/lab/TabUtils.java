package com.js.android.quick.swing.lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TabUtils extends JTabbedPane{
	
	
	public static void installCloseButton(String title, final JTabbedPane jTabbedPane){
		   JPanel tabPanel = new JPanel(true);
			tabPanel.setOpaque(true);
			final JButton tabCloseButton = new JButton("X");
			tabCloseButton.setBorder(BorderFactory.createEtchedBorder());
			tabCloseButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("close click:"+e.getSource());
					if(e.getSource()==tabCloseButton){
						for (int i = 0; i < jTabbedPane.getTabCount(); i ++) {
	                        Rectangle rect = jTabbedPane.getBoundsAt(i);
	                        if(rect.contains(tabCloseButton.getLocation())){
	                        	jTabbedPane.remove(i);
	                        }
	                 }
					}
				}
			});
			JLabel label = new JLabel(title);
//			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel headLabel = new JLabel(IconUtils.getIconExample3());
			headLabel.setPreferredSize(new Dimension(10, 10));
//			tabPanel.add(headLabel);
//			tabPanel.add(label);
			tabPanel.add(tabCloseButton);
			
//			tabPanel.setBorder(BorderFactory.createLoweredBevelBorder());
			tabPanel.setPreferredSize(new Dimension(20, 20));
			
			jTabbedPane.setTabComponentAt(0, tabPanel); 
	   }
	   
	
	
	public static void installTabPopMenu(JTabbedPane jTabbedPane){
		   
		   int popMenuIndex=-1;
		   JPopupMenu popMenu = new JPopupMenu();
		   JMenuItem closeMenuItem = new JMenuItem("Close");
		   JMenuItem closeOtherItem = new JMenuItem("Close Other");
		   JMenuItem closeAllItem = new JMenuItem("Close All");
	       popMenu.add(closeMenuItem);
	       popMenu.add(closeOtherItem);
	       popMenu.add(closeAllItem);
	       
	       closeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object source = e.getSource();
				System.out.println("close this");
				int selectIndex=jTabbedPane.getSelectedIndex();
	   			System.out.println("select index11111:"+selectIndex);
				jTabbedPane.remove(selectIndex);
			}
		});
	       
	       
	       closeOtherItem.addActionListener(new ActionListener() {
	   		
	   		@Override
	   		public void actionPerformed(ActionEvent e) {
	   			// TODO Auto-generated method stub
	   			int selectIndex=-1;
	   			Object source = e.getSource();
	   			
	   			System.out.println("close others");
	   			selectIndex=jTabbedPane.getSelectedIndex();
	   			System.out.println("select index11111:"+selectIndex);
	   			System.out.println("tabCount:"+jTabbedPane.getTabCount());
	   			int count = jTabbedPane.getTabCount();
	   			int index=0;
	   			for (int i = 0; i < count; i ++) {
	                if(i<selectIndex){
	                	jTabbedPane.remove(index);
//	                	selectIndex=selectIndex-1;
	                }else if (i>selectIndex) {
	                	jTabbedPane.remove(1);
					}
	   			}
	   		}
	   	});
	       
	       closeAllItem.addActionListener(new ActionListener() {
	      		
	      		@Override
	      		public void actionPerformed(ActionEvent e) {
	      			// TODO Auto-generated method stub
	      			Object source = e.getSource();
	      			int selectIndex=jTabbedPane.getSelectedIndex();
	       			jTabbedPane.removeAll();
	      		}
	      	});
	       //�Ҽ���������ֲ˵�
	       jTabbedPane.addMouseListener(new MouseAdapter(){
	    	   //���˫���¼�,��رոô���
//	    	   public void mouseClicked(MouseEvent e) {
//	                if (e.getClickCount() == 2) {
//	                	for (int i = 0; i < jTabbedPane.getTabCount(); i ++) {
//	                          Rectangle rect = jTabbedPane.getBoundsAt(i);
//	                          if (rect.contains(e.getX(), e.getY())) {
//	                        	  
//	                        	  System.out.println(e.getComponent()+" i "+i);	
//	                        	  jTabbedPane.remove(i);
////	                              popMenu.show(e.getComponent(), e.getX(), e.getY());
//	                           return;
//	                          }
//	                   }
//	                }
//	            }
	    	   
	           public void mouseReleased(MouseEvent e) {
	        	   
//	        	   Object source = e.getSource();
//	        	   System.out.println("source111:"+source);
	        	   
	               if(e.isPopupTrigger()){
	                   if (jTabbedPane.getTabCount() <= 0) {
	                       popMenu.show(e.getComponent(), e.getX(), e.getY());
	                          return;
	                   }
	                   for (int i = 0; i < jTabbedPane.getTabCount(); i ++) {
	                          Rectangle rect = jTabbedPane.getBoundsAt(i);
	                          if (rect.contains(e.getX(), e.getY())) {
	                        	  
//	                        	  System.out.println(e.getComponent()+" i "+i);	  
	                              popMenu.show(e.getComponent(), e.getX(), e.getY());
	                           return;
	                          }
	                   }
	               }
					
				}
	           
	            
	       });
	   }

}
