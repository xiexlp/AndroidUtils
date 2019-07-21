package html.template;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017-3-12.
 */
public class AstLeaf extends Ast {

    private static List<Ast> emptyList =new ArrayList<>();

    protected Token token;

    public AstLeaf(Token t){
        token = t;
    }

    public Ast child(int i){throw  new IndexOutOfBoundsException();}

    public int numChildren(){
        return 0;
    }

    public Iterator<Ast> children(){
        return emptyList.iterator();
    }

    public String toString(){
        return token.getText();
    }

    public String location(){
        return "at line "+ token.getLineNo();
    }

    public Token token(){
        return token;
    }





}
