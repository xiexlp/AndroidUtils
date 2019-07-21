package html.template;

/**
 * Created by Administrator on 2017-3-12.
 */
public class Name extends AstLeaf {

    public Name(Token t){
        super(t);
    }

    public String name(){
        return token.getText();
    }

}
