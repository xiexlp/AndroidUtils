package html.template;

import java.util.List;

/**
 * Created by Administrator on 2017-3-12.
 */
public class NegativeExpr extends AstList{
    public NegativeExpr(List<Ast> c){super(c);}

    public Ast operand(){
        return child(0);
    }

    public String toString(){
        return "-"+operand();
    }

}
