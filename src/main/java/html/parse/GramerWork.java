package html.parse;

import html.util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017-10-30.
 */
public class GramerWork {

    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                GramerWorkshop jFrame=new GramerWorkshop();
                //windows styles
                String windows="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                try {
                    UIManager.setLookAndFeel(windows);
                } catch (ClassNotFoundException | InstantiationException
                        | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(jFrame);;


                Dimension dimension = GuiUtil.getScreenDimensionHalf();



                jFrame.setSize(dimension);
                jFrame.setLocation(LocationUtils.getLocationPointTopAjust(dimension, 0));
                jFrame.setVisible(true);

                jFrame.setTitle("html语法分析器");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
                //jFrame.innerJSplitPane.setDividerLocation(0.3);
                //jFrame.initSize();
                //jFrame.articlesListPanel2.getjSplitPane().setDividerLocation(0.5);
                //jFrame.addWindowStateListener();
                //���Ӽ���
                //jFrame.addWindowStateListener(jFrame);
                //jFrame.addComponentListener(jFrame);
            }
        });
    }
}
