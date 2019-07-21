package html.template;



/**
 * Created by Administrator on 2017-3-12.
 */
public class NumberLiteral extends AstLeaf {

    public NumberLiteral(Token t){
        super(t);
    }

    public int value(){
        return   token().getNumber();
    }
}
