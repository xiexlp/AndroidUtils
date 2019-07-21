package html.util;

import java.io.*;

/**
 * Created by Administrator on 2017-3-10.
 */
public class FileUtil {




    public static String readString4(String filepath)
    {
        int len=0;
        StringBuffer str=new StringBuffer("");
        File file=new File(filepath);
        try {
            FileInputStream is=new FileInputStream(file);
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader in= new BufferedReader(isr);
            String line=null;
            while( (line=in.readLine())!=null )
            {
                if(len != 0)  // 处理换行符的问题
                {
                    str.append("\r\n"+line);
                }
                else
                {
                    str.append(line);
                }
                len++;
            }
            in.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str.toString();
    }
}
