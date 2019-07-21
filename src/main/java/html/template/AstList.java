package html.template;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017-3-12.
 */
public class AstList extends Ast {

    protected List<Ast> children;

    public AstList(List<Ast> list){
        children = list;
    }

    @Override
    public Ast child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public Iterator<Ast> children() {
        return children.iterator();
    }

    @Override
    public String location() {

        for(Ast t:children){
            String s = t.location();
            if(s!=null)
                return s;
        }
        return null;
    }
}
