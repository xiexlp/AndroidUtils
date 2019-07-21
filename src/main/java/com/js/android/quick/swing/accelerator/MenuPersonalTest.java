package com.js.android.quick.swing.accelerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class MenuPersonalTest extends JFrame{
	public MenuPersonalTest()
    {
        super();
        setTitle("MenuTest");
        setBounds(100,100,350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        URL resource = this.getClass().getResource("7633.png");  //图片
        ImageIcon icon = new ImageIcon(resource);   //设置图片
        JMenuBar menuBar = new JMenuBar();   //创建菜单栏对象
        setJMenuBar(menuBar);    //添加至窗体
        final JMenu fileMenu = new JMenu("文件(F)");
        fileMenu.setMnemonic('F');  //快捷键
        
        final JMenuItem newitem = new JMenuItem("新建(N)");
        newitem.setMnemonic('N');
        newitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));  //ctrl+n;
        newitem.addActionListener(new ItemListener());
        fileMenu.add(newitem);
        fileMenu.addSeparator();  //添加分隔线.
        final JMenu openMenu = new JMenu("打开(O)");
        openMenu.setMnemonic('O');  //快捷键
        
        final JMenuItem OpenNewItem = new JMenuItem("未打开过的(N)");
        OpenNewItem.setMnemonic('N');
        OpenNewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK|InputEvent.ALT_MASK));  //ctrl+alt+n;
        OpenNewItem.addActionListener(new ItemListener());
        openMenu.add(OpenNewItem);
        
        final JMenuItem OpenClosedItem = new JMenuItem("刚打开过的(C)");
        OpenClosedItem.setMnemonic('C');
        OpenClosedItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK|InputEvent.ALT_MASK));  //ctrl+alt+n;
        OpenClosedItem.addActionListener(new ItemListener());
        OpenClosedItem.setEnabled(false);  //不可用
        openMenu.add(OpenClosedItem);
        
        fileMenu.add(openMenu);
        
        menuBar.add(fileMenu);   //把菜单加至bar中
        
        
        final JMenu editMenu = new JMenu("编辑(E)");
        fileMenu.setMnemonic('E');  //快捷键
        final JMenu fontMenu = new JMenu("字体(F)");
        fontMenu.setIcon(icon);
        fontMenu.setMnemonic('F'); //快捷键
        
        JCheckBoxMenuItem bCheckBoxItem = new JCheckBoxMenuItem("加粗(B)");
        bCheckBoxItem.setMnemonic('B');
        bCheckBoxItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_MASK|InputEvent.ALT_MASK));  //ctrl+alt+b;
        bCheckBoxItem.addActionListener(new ItemListener());
        fontMenu.add(bCheckBoxItem);   //添加至font菜单中
        editMenu.add(fontMenu);
        
        final JMenu attributeMenu = new JMenu("属性(A)");
        attributeMenu.setIcon(icon);
        attributeMenu.setMnemonic('A'); //快捷键
        
        JRadioButtonMenuItem rRadioButtonItem = new JRadioButtonMenuItem("只读(R)");
        rRadioButtonItem.setMnemonic('R');
        rRadioButtonItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK|InputEvent.ALT_MASK));  //ctrl+alt+b;
        rRadioButtonItem.addActionListener(new ItemListener());
        rRadioButtonItem.setSelected(true);
        JRadioButtonMenuItem rRadioButtonItem2 = new JRadioButtonMenuItem("编辑(E0)");
        rRadioButtonItem2.setMnemonic('E');
        rRadioButtonItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK|InputEvent.ALT_MASK));  //ctrl+alt+E;
        rRadioButtonItem2.addActionListener(new ItemListener());
        rRadioButtonItem2.setSelected(false);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rRadioButtonItem);
        buttonGroup.add(rRadioButtonItem2);
        attributeMenu.add(rRadioButtonItem);
        attributeMenu.add(rRadioButtonItem2);
        editMenu.add(attributeMenu);
        menuBar.add(editMenu);   //把菜单加至bar中
        
        
    }
     class ItemListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JMenuItem menuItem =(JMenuItem)e.getSource();   //获得触发事件的菜单项
                //弹出对话框
                JOptionPane.showMessageDialog(null,"您单击的菜单是-" + menuItem.getText());
                //System.out.println("您单击的菜单是-" + menuItem.getText());
            }
        }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MenuPersonalTest menuPersonalTest= new MenuPersonalTest();
        menuPersonalTest.setVisible(true);
    }
}