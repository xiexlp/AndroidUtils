package html.template;

import java.util.List;

/**
 * Created by Administrator on 2017-3-12.
 */
public class Varstmt extends AstList {

    public Varstmt(List<Ast> c){
        super(c);
    }

    public String name(){
        return ((AstLeaf)child(0)).token().getText();
    }

    public Typetag type(){
        return (Typetag) child(1);
    }

    public Ast initializer(){
        return child(2);
    }

    public String toString(){
        return "(var "+name()+" "+type()+" "+initializer()+")";
    }



}
