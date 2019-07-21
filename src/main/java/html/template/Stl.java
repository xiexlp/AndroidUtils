package html.template;

import html.util.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-3-10.
 */
public class Stl {

    public  int currentIndex=0;
    public int state=0;
    public String source =null;

    public List<String> variableList= new ArrayList<>();
    public List<SVariable> svariableList = new ArrayList<>();

    public static  Map<String,Object> parameterMap = new HashMap<>();

    public static void main(String[] args) throws Exception{

        Stl stl = new Stl();

        Person person = new Person();person.setName("xieliping");person.setAge(30);

        stl.bind("person",person);

        int state = 0;

        String source = FileUtil.readString4("test.html");
        stl.setSource(source);
        stl.parse();

        List<String> variableList = stl.getVariableList();

        List<SVariable> sVariables = stl.getSvariableList();
        System.out.println("size:"+sVariables.size());

        for (SVariable v:sVariables){
            source = v.compile(source);
        }
        System.out.println(source);
    }

    public List<SVariable> getSvariableList() {
        return svariableList;
    }

    public void setSvariableList(List<SVariable> svariableList) {
        this.svariableList = svariableList;
    }

    public void parse() throws Exception{
        int len = source.length();
        for(int i=0;i<len;i++){

            if(currentIndex>=len) break;

            String c=readchar();
            if(c.equals("$")){

                int beginIndex=0;
                int endIndex =0;

                state =1;
                c = readchar();
                if(c.equals("{")){
                    state = 2;
                    beginIndex = currentIndex;
                    c = readchar();
                    while (!c.equals("}")){
                        c= readchar();
                    }
                    endIndex = currentIndex;
                }
                String value = source.substring(beginIndex,endIndex-1);

                SVariable svalue = new SVariable();
                svalue.setBeginIndex(beginIndex);
                svalue.setEndIndex(endIndex);
                svalue.setRaw(value);
                svalue.format();
                variableList.add(value);
                svariableList.add(svalue);
            }
        }
    }

    public static void bind(String key,Object value){
        parameterMap.put(key,value);
    }

    public static Object getObject(String key){
        return parameterMap.get(key);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<String> getVariableList() {
        return variableList;
    }

    public void setVariableList(List<String> variableList) {
        this.variableList = variableList;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private  String readchar(){




        char c = source.charAt(currentIndex);
        currentIndex++;
        return String.valueOf(c);
    }


}
