package html.template;

/**
 * Created by Administrator on 2017-3-12.
 */
public class StringLiteral extends AstLeaf {

    public StringLiteral(Token t){
        super(t);
    }

    public String value(){
        return token().getText();
    }

}
