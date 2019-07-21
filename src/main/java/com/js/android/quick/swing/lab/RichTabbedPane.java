package com.js.android.quick.swing.lab;

import javax.swing.*;
import java.awt.*;


public class RichTabbedPane extends JTabbedPane{
	
	public static int NO_HAS_TITLE=-1;
	public static int HAS_TITLE=1;
	
	/**
	 * @param title
	 * @return
	 */
	public int hasTitle(String title) {
		int result=NO_HAS_TITLE;
		int count = this.getTabCount();
		for (int i = 0; i < count; i++) {
			String title1 = this.getTitleAt(i);
			if(title1.equalsIgnoreCase(title)){
				result=HAS_TITLE;
			}
		}
		return result;
	}
	
	/**
	 * @param title
	 * @return
	 */
	public int titleIndex(String title) {
		int index=-1;
		int count = this.getTabCount();
		for (int i = 0; i < count; i++) {
			String title1 = this.getTitleAt(i);
			
			if(title1.equalsIgnoreCase(title)){
				index=i;
			}
		}
		return index;
	}
	
	
	public int pathIndex(String path){
		int index=-1;
		
		return index;
		
	}
	
	/**
	 * ����compent,�����������Ϊѡ����������ڣ������������ҷ���component����index
	 * @param title
	 * @param component
	 * @return
	 */
	public int addRich(String title,Component component) {
		int titleIndex= titleIndex(title);
		int resultIndex=-1;
		int tabCount = getTabCount();
		//����Ѿ����ڣ�����Ϊ�״̬
		if(titleIndex>=0){
			super.setSelectedIndex(titleIndex);
			resultIndex = titleIndex;
			//��������ڣ�������
		}else {
			super.add(title, component);
			resultIndex= tabCount;
		}
		return resultIndex;
	}
	
	
	public int addRichTab(String tabTitle,ImageIcon icon,Component container,String tip) {
		int count= getTabCount();
		addTab(tabTitle, IconUtils.getIconExample1(), container, tip);
		setSelectedIndex(count);
		return count+1;
	}
	
	
	
	
	/***
	 * ���ݱ���ѡ��
	 * @param title
	 */
	public void setActiveForTitle(String title) {
		int count = this.getTabCount();
		int titleIndex=-1;
		for (int i = 0; i < count; i++) {
			String title1 = this.getTitleAt(i);
			if(title1.equalsIgnoreCase(title)){
				titleIndex = i;
			}
		}
		super.setSelectedIndex(titleIndex);
	}

}
