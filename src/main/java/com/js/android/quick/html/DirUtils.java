package com.js.android.quick.html;

import java.io.File;

public class DirUtils {
	
	
	static FileNode temp;  
	
	
	public static FileNode traverseFolder(String path) {  
		File rootFile = new File(path);String absolutePath = rootFile.getAbsolutePath();
        FileNode rootTreeNode = new FileNode(rootFile.getName(),absolutePath);  
        //rootTreeNode.setAbstractPath(abstractPath);
        File file = new File(path);  
         
        if (file.exists()) {  
            File[] files = file.listFiles();  
            if (files.length == 0) {  
                if(file.isDirectory()) {//如果是空文件夹  
                	FileNode dn=new FileNode(file.getName(), true);  
                	//dn.setFileSimpleName(file.get);
                    return dn;  
                }  
            }else{  
                for (File file2 : files) {  
                    if (file2.isDirectory()) {  
                        //是目录的话，生成节点，并添加里面的节点  
                    	//在这做递归会影响性能
                    	rootTreeNode.add(traverseFolder(file2.getAbsolutePath()));  
                    }else{  
                        //是文件的话直接生成节点，并把该节点加到对应父节点上  
                        temp=new FileNode(file2.getName(),file2.getAbsolutePath(),true);  
                        rootTreeNode.add(temp);  
                    }  
                }  
            }  
        } else {//文件不存在  
            return null;  
        }  
        return rootTreeNode;  
    }  

}
