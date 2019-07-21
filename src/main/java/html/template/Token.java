package html.template;

/**
 * Created by Administrator on 2017-3-12.
 */
public class Token {

    public static final int TYPE_ID=1;
    public static final int TYPE_NUM=2;
    public static final int TYPE_STR=3;
    public static final int TYPE_KEY=4;
    public static final int TYPE_OP=5;

    public static final int TYPE_PARRENT=6;
    public static final int TYPE_BLOCK=7;


    public static final String QUOTA="\"";
    public static final String EQUAL="=";



    String value;
    //1 keyword,2 id,3,number
    int type;

    public static  final Token EOF = new Token(-1){};

    public static final String EOL="\\n";

    private int lineNo;

    protected Token(int line){
        lineNo = line;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public boolean isNumber(){
        return false;
    }

    public boolean isId(){
        return false;
    }

    public boolean isString(){
        return false;
    }

    public Integer getNumber(){
        try {
            throw  new Exception("not number");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getText(){
        return "";
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
