package com.js.android.quick.html;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

public class BeetlBasic {
	
	
	public static void main(String[] args) throws Exception {
		
				StringTemplateResourceLoader resourceLoader = new
				StringTemplateResourceLoader();
				Configuration cfg = Configuration.defaultConfiguration();
				GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
				Template t = gt.getTemplate("hello,${name}");
				t.binding("name", "beetl");
				String str = t.render();
				System.out.println(str);
		
	}
	
	public static String merge2(String template,String col1,String col2){
		String str="";
		try {
			StringTemplateResourceLoader resourceLoader = new
					StringTemplateResourceLoader();
					Configuration cfg = Configuration.defaultConfiguration();
					GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
					Template t = gt.getTemplate(template);
					t.binding("col1", col1);
					t.binding("col2", col2);
					str = t.render();
					System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return str;
		
	}
	
	
	public static String merge3(String template,String col1,String col2,String col3){
		String str="";
		try {
			StringTemplateResourceLoader resourceLoader = new
					StringTemplateResourceLoader();
					Configuration cfg = Configuration.defaultConfiguration();
					GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
					Template t = gt.getTemplate(template);
					t.binding("col1", col1);
					t.binding("col2", col2);
					t.binding("col3", col3);
					str = t.render();
					System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return str;
	}

}
