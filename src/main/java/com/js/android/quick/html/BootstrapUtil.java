/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.android.quick.html;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Administrator
 */
public class BootstrapUtil {
    
    private static String lineSeparator = System.getProperty("line.separator", "\n");
    private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
//     private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
//      private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>(); 
//      private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
//      private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
    
    
    
    //搞四个list即可,这些list就是key的集合
    
    public  static LinkedList<String> bootstrapList = new  LinkedList<String>();
    public  static LinkedList<String> formList = new  LinkedList<String>();
    public  static LinkedList<String> menuList = new  LinkedList<String>();
    public  static LinkedList<String> componentList = new  LinkedList<String>();
    public  static LinkedList<String> javascriptList = new  LinkedList<String>();
    
    
    
    
    static{
        
        init();
        
        
        
        System.out.println("----bootstrap list size:"+bootstrapList.size());

    }
    
    public static void init(){
            
        
        InputStream bootstrap = BootstrapUtil.class.getResourceAsStream("bootstrap.md");
          InputStream bootstrap_form = BootstrapUtil.class.getResourceAsStream("bootstrap-form.md");
          InputStream bootstrap_menu = BootstrapUtil.class.getResourceAsStream("bootstrap-menu.md");
          InputStream bootstrap_component = BootstrapUtil.class.getResourceAsStream("bootstrap-component.md");
          InputStream bootstrap_javascript = BootstrapUtil.class.getResourceAsStream("bootstrap-javascript.md");
          
           Map basicMap = new ConcurrentHashMap<String, HtmlSource>();
          LinkedList<String> list = new LinkedList<>();
          
          readTemplateFile(bootstrap, htmlSourceMap, bootstrapList);
          readTemplateFile(bootstrap_form, htmlSourceMap, formList);
          readTemplateFile(bootstrap_menu, htmlSourceMap, menuList);
          readTemplateFile(bootstrap_component, htmlSourceMap, componentList);
          readTemplateFile(bootstrap_javascript, htmlSourceMap, javascriptList);
          
    }
    
      
    public static void main(String[] args) {
        //readFiles();
        readFileFill();
    }
    
    
    public static String getBootstrapTemplate(String key){
        HtmlSource bs_template = htmlSourceMap.get(key);
        return bs_template.getTemplate();
    }
      
    
    public static void main2(String[] args) {
         InputStream in = BootstrapUtil.class.getResourceAsStream("bootstrap-template.md");
          InputStream in1 = BootstrapUtil.class.getResourceAsStream("bootstrap-component.md");
           InputStream in2 = BootstrapUtil.class.getResourceAsStream("bootstrap-javascript.md");
         
           
           readTemplateFile(in);
           readTemplateFile(in1);
           readTemplateFile(in2);
           
           String charset="utf-8";
         
         String id="form-inline";
         
         //readSqlFile(id, in);
         
         HtmlSource tableTemplate = htmlSourceMap.get(id);
         
         System.out.println("template:\n"+tableTemplate.getTemplate());
         System.out.println("\nsize:"+htmlSourceMap.size()+" keys:"+htmlSourceMap.keySet().toString()+" value:"+htmlSourceMap.values().toString());
    }
    
    public static void readFileFill(){
        InputStream bootstrap = BootstrapUtil.class.getResourceAsStream("bootstrap.md");
          InputStream bootstrap_form = BootstrapUtil.class.getResourceAsStream("bootstrap-form.md");
          InputStream bootstrap_menu = BootstrapUtil.class.getResourceAsStream("bootstrap-menu.md");
          InputStream bootstrap_component = BootstrapUtil.class.getResourceAsStream("bootstrap-component.md");
          InputStream bootstrap_javascript = BootstrapUtil.class.getResourceAsStream("bootstrap-javascript.md");
          
          Map basicMap = new ConcurrentHashMap<String, HtmlSource>();
          LinkedList<String> list = new LinkedList<>();
          
          readTemplateFile(bootstrap, basicMap, list);
          
          System.out.println("base map size:"+basicMap.size());
          System.out.println("base map key:"+basicMap.keySet().toString());
          System.out.println("base list size:"+list.size());
          for(String key:list){
              System.out.println("base key:"+key);
          }
          
          basicMap.clear();
          list.clear();
          
          readTemplateFile(bootstrap_form, basicMap, list);
          
           System.out.println("form map size:"+basicMap.size());
          System.out.println("form map key:"+basicMap.keySet().toString());
          System.out.println("form list size:"+list.size());
          for(String key:list){
              System.out.println("form key:"+key);
          }
          basicMap.clear();
           list.clear();
          
          readTemplateFile(bootstrap_menu, basicMap, list);
          
           System.out.println("menu map size:"+basicMap.size());
          System.out.println("menu map key:"+basicMap.keySet().toString());
          System.out.println("menu list size:"+list.size());
          for(String key:list){
              System.out.println("menu key:"+key);
          }
          basicMap.clear();
           list.clear();
          readTemplateFile(bootstrap_component, basicMap, list);
          
           System.out.println("component map size:"+basicMap.size());
          System.out.println("component map key:"+basicMap.keySet().toString());
          System.out.println("component list size:"+list.size());
          for(String key:list){
              System.out.println("component key:"+key);
          }
          basicMap.clear();
           list.clear();
          readTemplateFile(bootstrap_javascript, basicMap, list);
          
           System.out.println("javascript map size:"+basicMap.size());
          System.out.println("javascript map key:"+basicMap.keySet().toString());
          System.out.println("javascript list size:"+list.size());
          for(String key:list){
              System.out.println("javascript key:"+key);
          }
          
    }
    
    
    
    
    public static void readFiles(){
          InputStream bootstrap = BootstrapUtil.class.getResourceAsStream("bootstrap.md");
          InputStream bootstrap_form = BootstrapUtil.class.getResourceAsStream("bootstrap-form.md");
          InputStream bootstrap_menu = BootstrapUtil.class.getResourceAsStream("bootstrap-menu.md");
          InputStream bootstrap_component = BootstrapUtil.class.getResourceAsStream("bootstrap-component.md");
          InputStream bootstrap_javascript = BootstrapUtil.class.getResourceAsStream("bootstrap-javascript.md");
         
          
          Map basicMap= readTemplateMap(bootstrap);
          //List list = readTemplateKeyList(bootstrap);
          
          System.out.println("size:"+basicMap.size());
          Set keySet = basicMap.keySet();
          System.out.println("keys:"+keySet.toString());
          
          //System.out.println("key list:"+list.toString());
          
          Map formMap= readTemplateMap(bootstrap_form);
          
          System.out.println("size:"+formMap.size());
          keySet = formMap.keySet();
          System.out.println("keys:"+keySet.toString());
          
          
          Map menuMap= readTemplateMap(bootstrap_menu);
          
          System.out.println("size:"+menuMap.size());
          keySet = menuMap.keySet();
          System.out.println("keys:"+keySet.toString());
          
          Map componentMap= readTemplateMap(bootstrap_component);
          
          System.out.println("size:"+componentMap.size());
          
          keySet = componentMap.keySet();
          System.out.println("keys:"+keySet.toString());
          
          Map jsMap= readTemplateMap(bootstrap_javascript);
          
          System.out.println("size:"+jsMap.size());
          keySet = jsMap.keySet();
          System.out.println("keys:"+keySet.toString());
    }
    
    
    
    
    
    private static List readTemplateKeyList(InputStream ins){
        Map<String, HtmlSource> myHtmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
        
        String charset="utf-8";
        String modelName =""; 
                //id.substring(0, id.lastIndexOf(".") + 1);
         System.out.println("modelname:"+modelName);
        if(ins == null) return null;
//			InputStream ins  = null;
//		try{
//			ins = new FileInputStream(file);
//		}catch(IOException ioe){
//			throw new BeetlSQLException(BeetlSQLException.CANNOT_GET_SQL, "未找到[id="+id+"]相关SQL"+id,ioe);
//		}
        Integer lastModified = ins.hashCode();
//		long lastModified = file.lastModified();
        //sqlSourceVersion.put(id, lastModified);
//		InputStream ins = this.getClass().getResourceAsStream(
//				sqlRoot + File.separator + modelName + "md");
        LinkedList<String> list = new LinkedList<String>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(ins,charset));
            String temp = null;
            StringBuilder sql = null;
            String key = null;
            int lineNum = 0;
            int findLineNum = 0;
            while ((temp = bf.readLine()) != null) {
                temp = temp.trim();
                lineNum++;
                if (temp.startsWith("===")) {// 读取到===号，说明上一行是key，下面是注释或者SQL语句
                    if (!list.isEmpty() && list.size() > 1) {// 如果链表里面有多个，说明是上一句的sql+下一句的key
                        String tempKey = list.pollLast();// 取出下一句sql的key先存着
                        sql = new StringBuilder();
                        key = list.pollFirst();
                        while (!list.isEmpty()) {// 拼装成一句sql
                            sql.append(list.pollFirst() + lineSeparator);
                        }
                        HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
                        source.setLine(findLineNum);
                        myHtmlSourceMap.put(modelName + key, source);// 放入map
                        list.addLast(tempKey);// 把下一句的key又放进来
                        findLineNum = lineNum;
                    }
                    boolean sqlStart = false ;
                    String tempNext = null;
                    while((tempNext = bf.readLine()) != null){//处理注释的情况
                        tempNext = tempNext.trim();
                        lineNum++;
                        if (tempNext.startsWith("*")) {//读到注释行，不做任何处理
                            continue;
                        }else if(!sqlStart&&tempNext.trim().length()==0){
                        	//注释的空格
                           continue;
                        }else{
                        	 sqlStart = true;
                        	 list.addLast(tempNext);//===下面不是*号的情况，是一条sql
                             break;//读到一句sql就跳出循环
                        }
                    }
                } else {
                    list.addLast(temp);
                }
            }
            // 最后一句sql
            sql = new StringBuilder();
            key = list.pollFirst();
            while (!list.isEmpty()) {
                sql.append(list.pollFirst()+lineSeparator);
            }
            HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
            source.setLine(findLineNum);
            myHtmlSourceMap.put(modelName + key,source);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    
    private static Map readTemplateMap(InputStream ins){
        
        Map<String, HtmlSource> myHtmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
        
        String charset="utf-8";
        String modelName =""; 
                //id.substring(0, id.lastIndexOf(".") + 1);
         System.out.println("modelname:"+modelName);
        if(ins == null) return null;
//			InputStream ins  = null;
//		try{
//			ins = new FileInputStream(file);
//		}catch(IOException ioe){
//			throw new BeetlSQLException(BeetlSQLException.CANNOT_GET_SQL, "未找到[id="+id+"]相关SQL"+id,ioe);
//		}
        Integer lastModified = ins.hashCode();
//		long lastModified = file.lastModified();
        //sqlSourceVersion.put(id, lastModified);
//		InputStream ins = this.getClass().getResourceAsStream(
//				sqlRoot + File.separator + modelName + "md");
        LinkedList<String> list = new LinkedList<String>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(ins,charset));
            String temp = null;
            StringBuilder sql = null;
            String key = null;
            int lineNum = 0;
            int findLineNum = 0;
            while ((temp = bf.readLine()) != null) {
                temp = temp.trim();
                lineNum++;
                if (temp.startsWith("===")) {// 读取到===号，说明上一行是key，下面是注释或者SQL语句
                    if (!list.isEmpty() && list.size() > 1) {// 如果链表里面有多个，说明是上一句的sql+下一句的key
                        String tempKey = list.pollLast();// 取出下一句sql的key先存着
                        sql = new StringBuilder();
                        key = list.pollFirst();
                        while (!list.isEmpty()) {// 拼装成一句sql
                            sql.append(list.pollFirst() + lineSeparator);
                        }
                        HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
                        source.setLine(findLineNum);
                        myHtmlSourceMap.put(modelName + key, source);// 放入map
                        list.addLast(tempKey);// 把下一句的key又放进来
                        findLineNum = lineNum;
                    }
                    boolean sqlStart = false ;
                    String tempNext = null;
                    while((tempNext = bf.readLine()) != null){//处理注释的情况
                        tempNext = tempNext.trim();
                        lineNum++;
                        if (tempNext.startsWith("*")) {//读到注释行，不做任何处理
                            continue;
                        }else if(!sqlStart&&tempNext.trim().length()==0){
                        	//注释的空格
                           continue;
                        }else{
                        	 sqlStart = true;
                        	 list.addLast(tempNext);//===下面不是*号的情况，是一条sql
                             break;//读到一句sql就跳出循环
                        }
                    }
                } else {
                    list.addLast(temp);
                }
            }
            // 最后一句sql
            sql = new StringBuilder();
            key = list.pollFirst();
            while (!list.isEmpty()) {
                sql.append(list.pollFirst()+lineSeparator);
            }
            HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
            source.setLine(findLineNum);
            myHtmlSourceMap.put(modelName + key,source);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return myHtmlSourceMap;
    }
    
    
    private static void readTemplateFile(InputStream ins){
        String charset="utf-8";
        String modelName =""; 
                //id.substring(0, id.lastIndexOf(".") + 1);
         System.out.println("modelname:"+modelName);
        if(ins == null) return ;
//			InputStream ins  = null;
//		try{
//			ins = new FileInputStream(file);
//		}catch(IOException ioe){
//			throw new BeetlSQLException(BeetlSQLException.CANNOT_GET_SQL, "未找到[id="+id+"]相关SQL"+id,ioe);
//		}
        Integer lastModified = ins.hashCode();
//		long lastModified = file.lastModified();
        //sqlSourceVersion.put(id, lastModified);
//		InputStream ins = this.getClass().getResourceAsStream(
//				sqlRoot + File.separator + modelName + "md");
        LinkedList<String> list = new LinkedList<String>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(ins,charset));
            String temp = null;
            StringBuilder sql = null;
            String key = null;
            int lineNum = 0;
            int findLineNum = 0;
            while ((temp = bf.readLine()) != null) {
                temp = temp.trim();
                lineNum++;
                if (temp.startsWith("===")) {// 读取到===号，说明上一行是key，下面是注释或者SQL语句
                    if (!list.isEmpty() && list.size() > 1) {// 如果链表里面有多个，说明是上一句的sql+下一句的key
                        String tempKey = list.pollLast();// 取出下一句sql的key先存着
                        sql = new StringBuilder();
                        key = list.pollFirst();
                        while (!list.isEmpty()) {// 拼装成一句sql
                            sql.append(list.pollFirst() + lineSeparator);
                        }
                        HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
                        source.setLine(findLineNum);
                        htmlSourceMap.put(modelName + key, source);// 放入map
                        list.addLast(tempKey);// 把下一句的key又放进来
                        findLineNum = lineNum;
                    }
                    boolean sqlStart = false ;
                    String tempNext = null;
                    while((tempNext = bf.readLine()) != null){//处理注释的情况
                        tempNext = tempNext.trim();
                        lineNum++;
                        if (tempNext.startsWith("*")) {//读到注释行，不做任何处理
                            continue;
                        }else if(!sqlStart&&tempNext.trim().length()==0){
                        	//注释的空格
                           continue;
                        }else{
                        	 sqlStart = true;
                        	 list.addLast(tempNext);//===下面不是*号的情况，是一条sql
                             break;//读到一句sql就跳出循环
                        }
                    }
                } else {
                    list.addLast(temp);
                }
            }
            // 最后一句sql
            sql = new StringBuilder();
            key = list.pollFirst();
            while (!list.isEmpty()) {
                sql.append(list.pollFirst()+lineSeparator);
            }
            HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
            source.setLine(findLineNum);
            htmlSourceMap.put(modelName + key,source);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return;
    }
    
    
    private static void readTemplateFile(InputStream ins,Map myHtmlSourceMap,LinkedList<String> mylist){
        String charset="utf-8";
        String modelName =""; 
                //id.substring(0, id.lastIndexOf(".") + 1);
         System.out.println("modelname:"+modelName);
        if(ins == null) return ;
//			InputStream ins  = null;
//		try{
//			ins = new FileInputStream(file);
//		}catch(IOException ioe){
//			throw new BeetlSQLException(BeetlSQLException.CANNOT_GET_SQL, "未找到[id="+id+"]相关SQL"+id,ioe);
//		}
        Integer lastModified = ins.hashCode();
//		long lastModified = file.lastModified();
        //sqlSourceVersion.put(id, lastModified);
//		InputStream ins = this.getClass().getResourceAsStream(
//				sqlRoot + File.separator + modelName + "md");
        LinkedList<String> list = new LinkedList<String>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(ins,charset));
            String temp = null;
            StringBuilder sql = null;
            String key = null;
            int lineNum = 0;
            int findLineNum = 0;
            while ((temp = bf.readLine()) != null) {
                //temp = temp.trim();
                lineNum++;
                if (temp.startsWith("===")) {// 读取到===号，说明上一行是key，下面是注释或者SQL语句
                    if (!list.isEmpty() && list.size() > 1) {// 如果链表里面有多个，说明是上一句的sql+下一句的key
                        String tempKey = list.pollLast();// 取出下一句sql的key先存着
                        sql = new StringBuilder();
                        key = list.pollFirst();
                        while (!list.isEmpty()) {// 拼装成一句sql
                            sql.append(list.pollFirst() + lineSeparator);
                        }
                        HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
                        source.setLine(findLineNum);
                        myHtmlSourceMap.put(modelName + key, source);// 放入map
                        mylist.add(modelName+key);
                        list.addLast(tempKey);// 把下一句的key又放进来
                        findLineNum = lineNum;
                    }
                    boolean sqlStart = false ;
                    String tempNext = null;
                    while((tempNext = bf.readLine()) != null){//处理注释的情况
                        tempNext = tempNext.trim();
                        lineNum++;
                        if (tempNext.startsWith("*")) {//读到注释行，不做任何处理
                            continue;
                        }else if(!sqlStart&&tempNext.trim().length()==0){
                        	//注释的空格
                           continue;
                        }else{
                        	 sqlStart = true;
                        	 list.addLast(tempNext);//===下面不是*号的情况，是一条sql
                             break;//读到一句sql就跳出循环
                        }
                    }
                } else {
                    list.addLast(temp);
                }
            }
            // 最后一句sql
            sql = new StringBuilder();
            key = list.pollFirst();
            while (!list.isEmpty()) {
                sql.append(list.pollFirst()+lineSeparator);
            }
            HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
            source.setLine(findLineNum);
            myHtmlSourceMap.put(modelName + key,source);
            mylist.add(modelName+key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        
        System.out.println("mylist size:"+mylist.size());
        
        return;
    }
    
     private static boolean readSqlFile(String id,InputStream ins) {
        String charset="utf-8";
        String modelName = id.substring(0, id.lastIndexOf(".") + 1);
        
         System.out.println("model name:"+modelName);
        if(ins == null) return false ;
//			InputStream ins  = null;
//		try{
//			ins = new FileInputStream(file);
//		}catch(IOException ioe){
//			throw new BeetlSQLException(BeetlSQLException.CANNOT_GET_SQL, "未找到[id="+id+"]相关SQL"+id,ioe);
//		}
        Integer lastModified = ins.hashCode();
//		long lastModified = file.lastModified();
        //sqlSourceVersion.put(id, lastModified);
//		InputStream ins = this.getClass().getResourceAsStream(
//				sqlRoot + File.separator + modelName + "md");
        LinkedList<String> list = new LinkedList<String>();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(ins,charset));
            String temp = null;
            StringBuilder sql = null;
            String key = null;
            int lineNum = 0;
            int findLineNum = 0;
            while ((temp = bf.readLine()) != null) {
                temp = temp.trim();
                lineNum++;
                if (temp.startsWith("===")) {// 读取到===号，说明上一行是key，下面是注释或者SQL语句
                    if (!list.isEmpty() && list.size() > 1) {// 如果链表里面有多个，说明是上一句的sql+下一句的key
                        String tempKey = list.pollLast();// 取出下一句sql的key先存着
                        sql = new StringBuilder();
                        key = list.pollFirst();
                        while (!list.isEmpty()) {// 拼装成一句sql
                            sql.append(list.pollFirst() + lineSeparator);
                        }
                        HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
                        source.setLine(findLineNum);
                        htmlSourceMap.put(modelName + key, source);// 放入map
                        list.addLast(tempKey);// 把下一句的key又放进来
                        findLineNum = lineNum;
                    }
                    boolean sqlStart = false ;
                    String tempNext = null;
                    while((tempNext = bf.readLine()) != null){//处理注释的情况
                        tempNext = tempNext.trim();
                        lineNum++;
                        if (tempNext.startsWith("*")) {//读到注释行，不做任何处理
                            continue;
                        }else if(!sqlStart&&tempNext.trim().length()==0){
                        	//注释的空格
                           continue;
                        }else{
                        	 sqlStart = true;
                        	 list.addLast(tempNext);//===下面不是*号的情况，是一条sql
                             break;//读到一句sql就跳出循环
                        }
                    }
                } else {
                    list.addLast(temp);
                }
            }
            // 最后一句sql
            sql = new StringBuilder();
            key = list.pollFirst();
            while (!list.isEmpty()) {
                sql.append(list.pollFirst()+lineSeparator);
            }
            HtmlSource source = new HtmlSource(modelName + key,sql.toString().trim());
            source.setLine(findLineNum);
            htmlSourceMap.put(modelName + key,source);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    
    
    public static void main1(String[] args) throws  Exception{
        
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("hello,${name}");
        t.binding("name", "beetl");
        String str = t.render();
        System.out.println(str);
        
        Properties prop =  new  Properties();    
        InputStream in = BootstrapUtil.class.getResourceAsStream("template.properties" );    
         try  {    
            prop.load(in);    
            String param1 = prop.getProperty( "name" ).trim();    
            String param2 = prop.getProperty( "pass" ).trim(); 
            
             System.out.println("param1:"+param1);
             System.out.println("param2:"+param2);
            
        }  catch  (IOException e) {    
            e.printStackTrace();    
        }
    }
    
    String bootstrap_table_template="";
    
    
   
    
}
