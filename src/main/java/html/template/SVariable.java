package html.template;

import html.util.StringUtil;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017-3-11.
 */
public class SVariable {

    String raw;
    String name;
    String method;
    //1 :raw variable;2,variable method
    int type;

    int beginIndex;
    int endIndex;

    String value;


    public void format() throws Exception{
        System.out.println(raw);

        String[] aa = raw.split("\\.");
        int l = aa.length;

        //direct variable
        if(l==1){
            setType(1);
            String key = aa[0];
            setName(key);
            setValue(Stl.getObject(key).toString());
        }

        String key;
        Object value;
        String attr;
        String method;
        for(int i=0;i<l;i++){
            System.out.println(aa[i]);
            key = aa[0];
            method = StringUtil.capitalString(aa[1]);
            //get value by reflect
            Object o = Stl.getObject(key);

            Method m = o.getClass().getMethod("get"+method);
            Object result = m.invoke(o);

            setValue(result.toString());

            System.out.println(result.toString());
            //replace value by reflect

            setName(key);
            setMethod(method);
            setValue(result.toString());
        }
    }


    public String compile(String source){
        //return source.re(this.beginIndex-1,getValue(),0,value.length()+1);
        //return source.replaceAll("\${"+getRaw()+"}",getValue());
        //String f=source.substring(0,getBeginIndex()-2);
        //String e = source.substring(getEndIndex());
        //with reg very quick
        return source.replaceAll("\\$\\{"+getRaw()+"\\}",getValue());

        //return  new StringBuffer().append(f).append(value).append(e).toString();
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
