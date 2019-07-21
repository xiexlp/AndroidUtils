package html.util;

/**
 * Created by Administrator on 2017-3-11.
 */
public class StringUtil {

    public static  String capitalString(String aa){
        String a = aa.substring(0,1);
        a.toUpperCase();
        StringBuffer sb = new StringBuffer(a.toUpperCase()).append(aa.substring(1));
        return sb.toString();
    }
}
