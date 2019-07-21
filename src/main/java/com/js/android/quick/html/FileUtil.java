package com.js.android.quick.html;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	static String encoding="utf-8";


	public static List<String> readFileByLines(InputStream inputStream) {
		BufferedReader reader = null;
		List<String> list = new ArrayList();
		try {
			//System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new InputStreamReader(
					inputStream,encoding));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				list.add(tempString);
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				//sb.append(tempString).append("\r\n");
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return list;
	}

	
	 public static String readFileByLines(String fileName) {
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        StringBuffer sb = new StringBuffer(fileName+"\r\n");
	        try {
	            //System.out.println("以行为单位读取文件内容，一次读一整行：");
	            reader = new BufferedReader(new InputStreamReader(  
	                    new FileInputStream(file),encoding));
	            String tempString = null;
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	               // System.out.println("line " + line + ": " + tempString);
	                sb.append(tempString).append("\r\n");
	                line++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        
	        return sb.toString();
	    }
	 
	 public static String readFileByLinesPure(String fileName) {
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        StringBuffer sb = new StringBuffer("");
	        try {
	            //System.out.println("以行为单位读取文件内容，一次读一整行：");
	            reader = new BufferedReader(new InputStreamReader(  
	                    new FileInputStream(file),encoding));
	            String tempString = null;
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	               // System.out.println("line " + line + ": " + tempString);
	                sb.append(tempString).append("\r\n");
	                line++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        
	        return sb.toString();
	    }
	 
	 
	 //写入文件，如果文件不存在，创建文件再写入，如果文件存在，将文件内容情况再写入
	 public static void writeToFileClear(String path,String content){
		 try {
			 File file = new File(path);
			 if(!file.exists()){
				 file.createNewFile();
			 }
			 clearFile(file);
			 FileWriter fw = new FileWriter(file, true);
	         BufferedWriter bw = new BufferedWriter(fw);
	            //bw.append("在已有的基础上添加字符串");
	            //bw.write("abc\r\n ");// 往已有的文件上添加字符串
	            //bw.write("def\r\n ");
	            bw.write(content);
	            bw.close();
	            fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
		 
		 
	 }
	 
	 



	//写入文件，如果文件不存在，创建文件再写入，如果文件存在，将文件内容情况再写入
	public static void writeToFileClear(File file,String content){
		try {
			//File file = new File(path);
			if(!file.exists()){
				file.createNewFile();
			}
			clearFile(file);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			//bw.append("在已有的基础上添加字符串");
			//bw.write("abc\r\n ");// 往已有的文件上添加字符串
			//bw.write("def\r\n ");
			bw.write(content);
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	 
	 //文件已经存在，写入内容,这是增加文件内容，没有清空选项
	 public static void writeStringToFileAppend(String filePath,String content) {
	        try {
	            FileWriter fw = new FileWriter(filePath, true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            
	            //bw.append("在已有的基础上添加字符串");
	            //bw.write("abc\r\n ");// 往已有的文件上添加字符串
	            //bw.write("def\r\n ");
	            bw.write(content);
	            bw.close();
	            fw.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 
	 
	 
	 /***
	  * single file info,such as content,line,original line etc..
	  * @param fileName
	  * @return
	  */
	 public static FileScan readFileScan(String fileName){
		 FileScan fs = new FileScan();
		 File file = new File(fileName);
	     BufferedReader reader = null;
	     StringBuffer sb = new StringBuffer(fileName+"\r\n");
	     
	     int line = 1;
	        try {
	            //System.out.println("以行为单位读取文件内容，一次读一整行：");
	            reader = new BufferedReader(new InputStreamReader(  
	                    new FileInputStream(file),encoding));
	            String tempString = null;
	           
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	               // System.out.println("line " + line + ": " + tempString);
	                sb.append(tempString).append("\r\n");
	                line++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        
	        fs.setContent(sb.toString());
	        fs.setLine(line);
	        fs.setLineOriginal(line-1);
	        return fs;	 
	 }
	 	
		public static void appendMethodA(String fileName, String content) {
	        try {
	            // 打开一个随机访问文件流，按读写方式
	            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
	            // 文件长度，字节数
	            long fileLength = randomFile.length();
	            //将写文件指针移到文件尾。
	            randomFile.seek(fileLength);
	            randomFile.writeBytes("\r\n");
	            randomFile.write(content.getBytes(encoding));
	            randomFile.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	 
	 
	 public  static void clearFile(File f){
			FileWriter fw;
			try {
				fw = new FileWriter(f);
				fw.write("");
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 
	 
	 
	 public static String getLastDirName(String dirname){
		 int index = dirname.lastIndexOf("\\");
		 String lastDirName = dirname.substring(index+1);
		 return lastDirName;
	 }
	 
	 public static void main1(String[] args) {
		 String dirname= "E:\\git\\coin\\inchain\\inchain-core";
		 String lastDirName = getLastDirName(dirname);
		 System.out.println(lastDirName);
	}

	 
	 public static void main(String[] args) {
		 String path="bb.txt";
		 
		 File f = new File(path);
		 System.out.println(f.getName());
		 
		 //writeToFile(path, "后台开发核心技术");
	}
	

}
