package html.template;

import java.util.List;

/**
 * Created by Administrator on 2017-3-12.
 */
public class Typetag extends AstList {

    public static final String UNDEF="<Undef>";


    public Typetag(List<Ast> c){
        super(c);
    }

    public String type(){
        if(numChildren()>0){
            return ((AstLeaf)child(0)).token().getText();
        }else
            return UNDEF;
    }

    public String toString(){
        return ":"+type();
    }

}
