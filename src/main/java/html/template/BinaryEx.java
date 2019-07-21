package html.template;

import java.util.List;

/**
 * Created by Administrator on 2017-3-12.
 */
public class BinaryEx extends AstList{


    public BinaryEx(List<Ast> c){ super(c);}

    public Ast left(){
        return child(0);
    }

    public String operator(){
        return ((AstLeaf)child(1)).token().getText();
    }

    public Ast right(){
        return child(2);
    }





}
