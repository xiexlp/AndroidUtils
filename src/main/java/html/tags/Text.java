package html.tags;

/**
 * Created by Administrator on 2017-8-22.
 */
public class Text extends Tag {

    public Text(String innerText) {
        super.name = "text";
        super.frontTag = "";
        super.rearTag = "";
        this.innerText = innerText;
    }

    public String renderHtml() {
        StringBuffer sb =new StringBuffer();
        sb.append(this.innerText);
        return sb.toString();
    }



}
