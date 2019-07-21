package html.util;

import java.awt.*;

/**
 * Created by Administrator on 2017-3-8.
 */
public class GuiUtil {

    public static Dimension getScreenDimension(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        return  dimension;
    }


    public static Dimension getScreenDimensionHalf(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dimension.height/3*2;
        int width = dimension.width/3*2;
        Dimension newDi = new Dimension(width,height);
        return newDi;
    }
}
