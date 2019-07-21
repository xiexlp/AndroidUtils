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

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Administrator
 */
public class BootstrapTemplate {
    
    private static String lineSeparator = System.getProperty("line.separator", "\n");
    private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
//     private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
//      private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>(); 
//      private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();
//      private static Map<String, HtmlSource> htmlSourceMap = new ConcurrentHashMap<String, HtmlSource>();

    private String dataResource="src/main/resources/";
    
    
    //搞四个list即可,这些list就是key的集合
    
    public   LinkedList<String> controlLayoutList = new  LinkedList<String>();
    public   LinkedList<String> activityFragmentList = new  LinkedList<String>();
    public   LinkedList<String> controlAdapterList = new  LinkedList<String>();
    public   LinkedList<String> customizationList = new  LinkedList<String>();
    public   LinkedList<String> commonToolsList = new  LinkedList<String>();
    
    
    
    
    public BootstrapTemplate(){
    	init();
    	System.out.println("----bootstrap list size:"+controlLayoutList.size());
    }
        
    //读取当前的文件md
    public void init(){
        try {
            File android_control_layout_File =new File(dataResource+"android-control-layout.md");
            InputStream android_control_layout = new FileInputStream(android_control_layout_File);

            File android_activity_fragment_File = new File(dataResource+"android-activity-fragment.md");
            //InputStream android_activity_fragment = BootstrapTemplate.class.getResourceAsStream("android-activity-fragment.md");
            InputStream android_activity_fragment = new FileInputStream(android_activity_fragment_File);
            //InputStream android_control_adapter = BootstrapTemplate.class.getResourceAsStream("android-control-adapter.md");
            File android_control_adapter_File = new File(dataResource+"android-control-adapter.md");
            InputStream android_control_adapter = new FileInputStream(android_control_adapter_File);
                    //InputStream android_customization = BootstrapTemplate.class.getResourceAsStream("android-customization.md");
            File android_customization_File = new File(dataResource+"android-customization.md");
            InputStream android_customization = new FileInputStream(android_customization_File);
            //InputStream android_common_tools = BootstrapTemplate.class.getResourceAsStream("android-common-tools.md");
            File android_common_tools_File = new File(dataResource+"android-common-tools.md");
            InputStream android_common_tools =new FileInputStream(android_common_tools_File);

            Map basicMap = new ConcurrentHashMap<String, HtmlSource>();
            LinkedList<String> list = new LinkedList<>();

            readTemplateFile(android_control_layout, htmlSourceMap, controlLayoutList);
            readTemplateFile(android_activity_fragment, htmlSourceMap, activityFragmentList);
            readTemplateFile(android_control_adapter, htmlSourceMap, controlAdapterList);
            readTemplateFile(android_customization, htmlSourceMap, customizationList);
            readTemplateFile(android_common_tools, htmlSourceMap, commonToolsList);

        }catch (Exception e){
            e.printStackTrace();
        }

          

    }


    public LinkedList<String> getControlLayoutList() {
        return controlLayoutList;
    }

    public void setControlLayoutList(LinkedList<String> controlLayoutList) {
        this.controlLayoutList = controlLayoutList;
    }

    public LinkedList<String> getActivityFragmentList() {
        return activityFragmentList;
    }

    public void setActivityFragmentList(LinkedList<String> activityFragmentList) {
        this.activityFragmentList = activityFragmentList;
    }

    public LinkedList<String> getControlAdapterList() {
        return controlAdapterList;
    }

    public void setControlAdapterList(LinkedList<String> controlAdapterList) {
        this.controlAdapterList = controlAdapterList;
    }

    public LinkedList<String> getCustomizationList() {
        return customizationList;
    }

    public void setCustomizationList(LinkedList<String> customizationList) {
        this.customizationList = customizationList;
    }

    public LinkedList<String> getCommonToolsList() {
        return commonToolsList;
    }

    public void setCommonToolsList(LinkedList<String> commonToolsList) {
        this.commonToolsList = commonToolsList;
    }

    public static void main(String[] args) {
        //readFiles();
    	BootstrapTemplate btt = new BootstrapTemplate();
    	//btt.readFileFill();
        //readFileFill();
    }
    
    
    public String getBootstrapTemplate(String key){
        HtmlSource bs_template = htmlSourceMap.get(key);
        return bs_template.getTemplate();
    }
      
    
    public static void main2(String[] args) {
         InputStream in = BootstrapTemplate.class.getResourceAsStream("bootstrap-template.md");
          InputStream in1 = BootstrapTemplate.class.getResourceAsStream("bootstrap-component.md");
           InputStream in2 = BootstrapTemplate.class.getResourceAsStream("bootstrap-javascript.md");
         
           
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
    
    public  void readFileFill(){
//        InputStream bootstrap = BootstrapTemplate.class.getResourceAsStream("bootstrap.md");
//          InputStream bootstrap_form = BootstrapTemplate.class.getResourceAsStream("bootstrap-form.md");
//          InputStream bootstrap_menu = BootstrapTemplate.class.getResourceAsStream("bootstrap-menu.md");
//          InputStream bootstrap_component = BootstrapTemplate.class.getResourceAsStream("bootstrap-component.md");
//          InputStream bootstrap_javascript = BootstrapTemplate.class.getResourceAsStream("bootstrap-javascript.md");
        try {
            File android_control_layout_File =new File(dataResource+"android-control-layout.md");
            InputStream android_control_layout = new FileInputStream(android_control_layout_File);

            File android_activity_fragment_File = new File(dataResource+"android-activity-fragment.md");
           InputStream android_activity_fragment =new FileInputStream(android_activity_fragment_File);

            //InputStream android_control_adapter = BootstrapTemplate.class.getResourceAsStream("android-control-adapter.md");
            File android_control_adapter_File = new File(dataResource+"android-control-adapter.md");
            InputStream android_control_adapter = new FileInputStream(android_control_adapter_File);
            //InputStream android_customization = BootstrapTemplate.class.getResourceAsStream("android-customization.md");
            File android_customization_File = new File(dataResource+"android-customization.md");
            InputStream android_customization = new FileInputStream(android_customization_File);
            //InputStream android_common_tools = BootstrapTemplate.class.getResourceAsStream("android-common-tools.md");
            File android_common_tools_File = new File(dataResource+"android-common-tools.md");
            InputStream android_common_tools =new FileInputStream(android_common_tools_File);

            Map basicMap = new ConcurrentHashMap<String, HtmlSource>();
            LinkedList<String> list = new LinkedList<>();

            readTemplateFile(android_control_layout, htmlSourceMap, controlLayoutList);

            readTemplateFile(android_activity_fragment, htmlSourceMap, activityFragmentList);

            System.out.println("base map size:"+htmlSourceMap.size());
            System.out.println("base map key:"+htmlSourceMap.keySet().toString());
            System.out.println("base list size:"+list.size());
            for(String key:list){
                System.out.println("base key:"+key);
            }
            htmlSourceMap.clear();
            list.clear();

            readTemplateFile(android_control_adapter, htmlSourceMap, controlAdapterList);

            System.out.println("base map size:"+htmlSourceMap.size());
            System.out.println("base map key:"+htmlSourceMap.keySet().toString());
            System.out.println("base list size:"+list.size());
            for(String key:list){
                System.out.println("base key:"+key);
            }
            htmlSourceMap.clear();
            list.clear();

            readTemplateFile(android_customization, htmlSourceMap, customizationList);
            System.out.println("base map size:"+htmlSourceMap.size());
            System.out.println("base map key:"+htmlSourceMap.keySet().toString());
            System.out.println("base list size:"+list.size());
            for(String key:list){
                System.out.println("base key:"+key);
            }
            htmlSourceMap.clear();
            list.clear();

            readTemplateFile(android_common_tools, htmlSourceMap, commonToolsList);

            System.out.println("base map size:"+htmlSourceMap.size());
            System.out.println("base map key:"+htmlSourceMap.keySet().toString());
            System.out.println("base list size:"+list.size());
            for(String key:list){
                System.out.println("base key:"+key);
            }
            htmlSourceMap.clear();
            list.clear();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    
    
    
    
    public static void readFiles(){
          InputStream bootstrap = BootstrapTemplate.class.getResourceAsStream("bootstrap.md");
          InputStream bootstrap_form = BootstrapTemplate.class.getResourceAsStream("bootstrap-form.md");
          InputStream bootstrap_menu = BootstrapTemplate.class.getResourceAsStream("bootstrap-menu.md");
          InputStream bootstrap_component = BootstrapTemplate.class.getResourceAsStream("bootstrap-component.md");
          InputStream bootstrap_javascript = BootstrapTemplate.class.getResourceAsStream("bootstrap-javascript.md");
         
          
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
        if(ins == null) {
            System.out.println("内容为空111");
            return ;
        }
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
    
    
    private void readTemplateFile(InputStream ins,Map myHtmlSourceMap,LinkedList<String> mylist){
        String charset="utf-8";
        String modelName =""; 
                //id.substring(0, id.lastIndexOf(".") + 1);
         System.out.println("modelname:"+modelName);
        if(ins == null){
            System.out.println("文件不存在，直接返回");
            return ;
        }
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
        InputStream in = BootstrapTemplate.class.getResourceAsStream("template.properties" );    
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
