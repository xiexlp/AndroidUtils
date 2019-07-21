package com.js.android.quick.utils;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTool {

    public static void main(String[] args) {

        String name="group_desc";
        String hump = underLineToHump(name);
        System.out.println(hump);
        System.out.println(upperWord(name));
        System.out.println(lowerFirstStr("GroupAction"));
        //System.out.println(testUpperChar(name));

    }

    public static void test1(String[] args) {
        String name="groupDesc";
        String underLineStr=humpToUnderLine(name);
        System.out.println("underline str:"+underLineStr);
    }


    /**
     * create_time --> createTime
     * @param name
     * @return
     */
    public static String underLineToHump(String name){
        StringTokenizer st =new StringTokenizer(name, "_");
        StringBuffer sb = new StringBuffer();
        sb.append(st.nextToken());
        while (st.hasMoreTokens()){
            sb.append(StringUtils.capitalize(st.nextToken()));
        }
        return sb.toString();
    }


    /**
     * 变成hump to underline
     * 如 createTime ->create_time
     * @return
     */
    public static String  humpToUnderLine(String name) {
        //printUpperChar(name);
        List<String> strList =splitString(name);
        StringBuffer sb = new StringBuffer(strList.get(0));
        int size = strList.size();
        for(int i=1;i< size;i++){
            sb.append("_");
            sb.append(strList.get(i).toLowerCase());
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    /***
     * 根据大写字母分隔字符串
     * @param name
     * @return
     */
    public static List<String> splitString(String name){
        List<Integer> indexList=testUpperChar(name);
        List<String> indexStrList = new ArrayList();
        int l=indexList.size();
        for(int i=0;i<l-1;i++){
            int lastIndex = indexList.get(i);
            int currentIndex = indexList.get(i+1);
            String word = name.substring(lastIndex,currentIndex);
            System.out.println("word:"+word);
            indexStrList.add(word);
        }
        return indexStrList;
    }

    public static String capitalStr(String name){
        return  StringUtils.capitalize(name);
    }

    public static String lowerFirstStr(String name){
        //StringBuffer sb =new StringBuffer();
        return  Character.toLowerCase(name.charAt(0))+name.substring(1,name.length());

    }

    public static void printUpperChar(String name){
        List<Integer> indexList=testUpperChar(name);
        int l=indexList.size();
        for(int i=0;i<l;i++){
            int index = indexList.get(i);
            System.out.println(index+":"+name.charAt(index));
        }
    }

    public static List testUpperChar(String name) {
        char[] nameCharArray = name.toCharArray();
        int len = nameCharArray.length;
        List<Integer> indexList=new ArrayList();
        indexList.add(0);
        int j=0;
        for(int i=0;i<len;i++){
            char c = nameCharArray[i];
            if(Character.isUpperCase(c)){
                System.out.println("upper case i:"+i);
                indexList.add(i);
            }
        }
        indexList.add(len);
        return indexList;
    }

    public static String upperWord(String name){
        StringBuffer sb=new StringBuffer();
        int len = name.length();
        for(int i=0;i<len;i++){
            Character c=name.charAt(i);
            Character upper = Character.toUpperCase(c);
            sb.append(upper);
        }
        return sb.toString();
    }

}
