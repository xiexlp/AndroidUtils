package html.util;

/**
 * Created by Administrator on 2017-3-13.
 */
public class ParseUtil {

    public static boolean isSpace(char c){
        return Character.isWhitespace(c);
    }


    public static boolean isNumber(char c){
        return Character.isDigit(c);
    }

    public static boolean isAlpha(char c){
        return Character.isLetter(c);
    }

    public static boolean isLineSeperator(char c){
        return String.valueOf(c).equals("\n")||String.valueOf(c).equals("\r\n");
    }


}
