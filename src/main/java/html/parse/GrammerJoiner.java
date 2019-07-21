package html.parse;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Administrator on 2017-3-9.
 */
public class GrammerJoiner {

    public Set<String> tagSet = new HashSet<String>();
    public  Set<String> attrNameSet = new HashSet<String>();
    public  Set<String> attrSingleSet = new HashSet<String>();
    public Set<String> noCloseTagSet = new HashSet<>();

    String[] tags = {"html","div","head","meta","title","script","link","input","table","body","footer","h1","h2","h3","h4","h5","h6","p"};
    String[] attrNames={"class","method","style","href","rel","lang","charset","src"};
    String[] attrSingle={"readonly","multiple"};

    String[] noCloseTags={"meta","hr"};

    private LinkedList<Toke> tokeLinkedList = new LinkedList<>();

    private LinkedList<String> leftCloseList= new LinkedList<>();
    private LinkedList<String> rightCloseList = new LinkedList<>();


    {
        init();
    }

    private void init(){
        for(int i=0;i<tags.length;i++){
            tagSet.add(tags[i]);
        }
        for(int i=0;i<attrNames.length;i++){
            attrNameSet.add(attrNames[i]);
        }
        for(int i=0;i<attrSingle.length;i++){
            attrSingleSet.add(attrSingle[i]);
        }

        for(int i=0;i<noCloseTags.length;i++){
            noCloseTagSet.add(noCloseTags[i]);
        }
    }


    public GrammerJoiner(){

    }

    public GrammerJoiner(LinkedList<Toke> tokes){
        setTokeLinkedList(tokes);
    }


    public void parse(){
        int len = tokeLinkedList.size();

        for(int i=0;i<len;i++){
            Toke toke = tokeLinkedList.get(i);
            String id = toke.getId();

            if(id.equals("<")){
                Toke nextToke = getNextToke(i);
                String nextID = nextToke.getId();
                if(tagSet.contains(nextID)){
                    System.out.println("get a tag header");
                    Tagex tagex = new Tagex();
                    tagex.setKey(Integer.toString(i));
                    tagex.setName(nextID);
                    tagex.setOpenBeginTokeIndex(toke.getBegin());
                    
                }else if("!".equals(nextID)){
                    System.out.println("html doc begin");
                }else if("/".equals(nextID)){
                    System.out.println("error");
                }
            }else{
                System.out.println("grammer parse error");
            }
        }
    }

    private Toke getNextToke(int i){
        Toke toke = tokeLinkedList.get(i+1);
        return toke;
    }


    public static void main(String[] args) {

        TokeParser tokeParser = new TokeParser();
        String htmlFile = "";
        tokeParser.setSource(htmlFile);
        tokeParser.parser();

        LinkedList<Toke> tokes = tokeParser.getTokeList();

        GrammerJoiner grammerJoiner = new GrammerJoiner();
        grammerJoiner.setTokeLinkedList(tokes);

    }



    public LinkedList<Toke> getTokeLinkedList() {
        return tokeLinkedList;
    }

    public void setTokeLinkedList(LinkedList<Toke> tokeLinkedList) {
        this.tokeLinkedList = tokeLinkedList;
    }
}
