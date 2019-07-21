package com.js.android.quick.swing.lab;

import javax.swing.*;
import java.awt.*;

public class IconUtils {
	
	public static int HEIGH=20;
	public static int WIDTH=20;
	public static ImageIcon icon1=new ImageIcon("images/7633.png");
	public static ImageIcon icon2=new ImageIcon("images/7634.png");
	public static ImageIcon icon3=new ImageIcon("images/7635.png");
	
	public static ImageIcon setDimission(ImageIcon icon) {
		icon.setImage(icon.getImage().getScaledInstance(WIDTH,HEIGH,Image.SCALE_DEFAULT));
		return icon;
	}
	
	public static ImageIcon getIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		setDimission(icon);
		return icon;
	}
	
	public static ImageIcon getIconExample1() {
		return setDimission(icon1);
	}
	
	public static ImageIcon getIconExample2() {
		return setDimission(icon2);
	}
	
	public static ImageIcon getIconExample3() {
		return setDimission(icon3);
	}
	
	

}
