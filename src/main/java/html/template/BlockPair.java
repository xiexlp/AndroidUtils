package html.template;

/**
 * Created by Administrator on 2017-3-20.
 */
public class BlockPair {

    public static final int TYPE_HTML=1;
    public static final int TYPE_CODE=2;

    int begin;
    int end;

    int index;

    String content;
    int blocktype;


    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getBlocktype() {
        return blocktype;
    }

    public void setBlocktype(int blocktype) {
        this.blocktype = blocktype;
    }
}
