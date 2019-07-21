package html.parse;

/**
 * Created by Administrator on 2017-3-5.
 */
public class HtmlDoc {

    private String doctype;
    private Tagex rootTag;

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public Tagex getRootTag() {
        return rootTag;
    }

    public void setRootTag(Tagex rootTag) {
        this.rootTag = rootTag;
    }

    public String renderHtml(){
        StringBuffer sb= new StringBuffer();
        if(doctype!=null&&doctype.equalsIgnoreCase("html5")){
            sb.append("<!DOCTYPE html>");
        }
        sb.append(rootTag.renderHtml());
        return sb.toString();
    }


}
