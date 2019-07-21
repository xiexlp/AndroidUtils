package html.parse;

import java.awt.*;

public class LocationUtils {
	
	public static Point getLocationPoint(Dimension myDimension) {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Point locationPoint = new Point(screenDimension.width/2-myDimension.width/2,screenDimension.height/2-myDimension.height/2);
		return locationPoint;
	}
	
	/**
	 *
	 * @param myDimension
	 * @param topAjust
	 * @return
	 */
	public static Point getLocationPointTopAjust(Dimension myDimension,int topAjust) {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Point locationPoint = new Point(screenDimension.width/2-myDimension.width/2,screenDimension.height/2-myDimension.height/2-topAjust);
		return locationPoint;
	}

}
