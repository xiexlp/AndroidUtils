package html.template;

import java.util.Iterator;

/**
 * Created by Administrator on 2017-3-12.
 */
public abstract class Ast {

    public abstract Ast child(int i);

    public abstract int numChildren();

    public abstract Iterator<Ast> children();

    public abstract String location();

    public Iterator<Ast> iterator() {
        return children();
    }

}
