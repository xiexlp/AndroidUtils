package com.js.android.quick.dialog;

import javax.swing.*;

//自定义弹出窗口类
class MyDialog extends JDialog {
    public MyDialog(JFrame frame) {
        super(frame);//给弹窗指定父窗口this
        setTitle("弹窗2"); 
        setModal(true);//!!! 设置为模态窗口,父窗口不能被点击
        setSize(170,92);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//点击关闭按钮时销毁弹窗
         
        //JDialog作为弹窗 有很大的自由度, 可以像JFrame一样添加各种组件
        JLabel jl = new JLabel("利用JDialog 来作为弹窗");
        add(jl);
    }
}