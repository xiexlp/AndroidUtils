package com.js.android.quick.html;

public class FilterUtils {
	
	static String[] fileType= {".html",".js",".css",".jsp",".vm",".txt",".md",".xml"};
	
	public static boolean checkFileType(String fileName){
        return  fileName.endsWith(fileType[0])||
                fileName.endsWith(fileType[1])||
                fileName.endsWith(fileType[2])||
                fileName.endsWith(fileType[3])||
                fileName.endsWith(fileType[4])||
                fileName.endsWith(fileType[5])||
                fileName.endsWith(fileType[6])||
                fileName.endsWith(fileType[7]);
    }
	

}
