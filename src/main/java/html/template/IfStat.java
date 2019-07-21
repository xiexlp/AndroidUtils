package html.template;

import java.util.List;

/**
 * Created by Administrator on 2017-3-12.
 */
public class IfStat extends AstList{

    public IfStat(List<Ast> c){super(c);}

    public Ast condition(){
        return child(0);
    }

    public Ast then(){
        return child(1);
    }

    public Ast elseBlock(){
        return numChildren()>2?child(2):null;
    }

    public String toString(){

        StringBuffer sb=new StringBuffer();
        sb.append("(if ").append(condition()).append(" ").append(then())
                .append(" else ").append(elseBlock()).append(")");
        return sb.toString();

    }




}
