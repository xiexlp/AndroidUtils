package html.parse;

import html.tags.Tag;
import html.tags.Text;

import java.util.*;

public class GrammerParser {
	
	
	public  Set<String> tagSet = new HashSet<String>();
	public  Set<String> attrNameSet = new HashSet<String>();
	public  Set<String> attrSingleSet = new HashSet<String>();
	public Set<String> noCloseTagSet = new HashSet<>();


	public  Set<String> cssAttrSet = new HashSet<String>();
	
	
	public Tagex rootTagex;
	
	String[] tags = {"html","div","head","meta","title","script","link","input","table","body","footer","h1","h2","h3","h4","h5","h6","p"};
	String[] attrNames={"class","method","style","href","rel","lang","charset","src"};
	String[] attrSingle={"readonly","multiple"};


	String[] noCloseTags={"meta","hr"};
	
	int currentIndex=0;
	int state;
	int phase=0;

	Toke currentToke=null;

	public HtmlDoc htmlDoc = new HtmlDoc();
	
	LinkedList<Toke> tokeList=new LinkedList<Toke>();
	Stack<Tagex> stackTag = new Stack<Tagex>();
	public LinkedList<Tagex> tagsList = new LinkedList<Tagex>();
	Map<String,Tagex> tagexMap = new HashMap<>();

	LinkedList<State> stateLinkedList = new LinkedList<>();

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

	public static void main(String[] args) {
		String fileName = "test1.html";
		String source = HtmlLexer.readString4(fileName);

		System.out.println("---------------------------------------------------");

//		source = "<div class=\"panel panel-default\">\n" +
//				"        <div class=\"panel-body\">\n" +
//				"            管理软件 <br/>\n" +
//				"        </div>\n" +
//				"    </div>";

		source="  <div class=\"panel-body\">\n" +
				"            管理软件 <br/>\n" +
				"        </div>\n" +
				"    </div>";

		TokeParser tokeParser = new TokeParser();
		tokeParser.setSource(source);
		//解析
		tokeParser.parser();

		//解析出来的结果
		LinkedList<Toke> tokes = tokeParser.getTokeList();
		System.out.println("-----toke-----");
		int i=0;
		for(Toke t:tokes){
			System.out.println("toke index:"+i+"--"+t.getId());
			i++;
		}

		System.out.println("total toke size:"+tokes.size());

		System.out.println("---------------------------------------------------");

		GrammerParser grammerParser = new GrammerParser();
		grammerParser.setTokeList(tokes);

		grammerParser.parser();
		//grammerParser.parserGrace();

		System.out.println("最后的tagStack大小:"+grammerParser.stackTag.size());

		Stack<Tagex> stack = grammerParser.stackTag;

		List<Tagex> list = grammerParser.tagsList;

		System.out.println("list:"+list.get(0).getName());

		Map<String,Tagex> map = grammerParser.tagexMap;

		while (stack.size()>0){
			Tag tag = stack.pop();
			System.out.println("tag id:"+tag.getId());
			System.out.println("tag name:"+tag.getName());
		}

		Tagex rootex = list.get(0);
		String el = rootex.renderHtml();
		System.out.println("el:"+"\n"+el);

		grammerParser.htmlDoc.setRootTag(rootex);
		String htmlDocEl = grammerParser.htmlDoc.renderHtml();
		System.out.println("html doc:"+htmlDocEl);
	}


	public void parserGrace(){
		int len = tokeList.size();
		System.out.println("len:"+len);
		currentIndex=0;
		System.out.println("----------begin parser--------");
		outerFor:for(int i=0;i<len;i++){
			//Toke t = tokeList.get(i);
			Toke t=readtoke();
			currentToke = t;
			//相当于最后已经结束
			if(t==null) {
				//all to end,then print stat
				parseEndInfo();
				break ;
			}
			//currentIndex++;
			String id = t.getId();

			System.out.print(" toke id:"+id+"  ");
			System.out.println("目前i:"+i);

			//每次都是开始<的时候进入
			innerIf:if(id.equals("<")) {
				Toke nextToke = getNextToke();
				String nextId = nextToke.getId();
				if (nextId != null && tagSet.contains(nextId)) {
					state = State.STATE_OPEN_BEGIN;
					//changeState(state);

					t = readtoke();
					String id1 = null;
					if (t != null) {
						id1 = t.getId();
						System.out.println("<下一个:" + id1);
					}
					if (id1 == null) break;

					System.out.println("这是个开始，进入tag开始的分析状态,指定tag并且push,然后分析body");
					//开始解析,返回来的tag
					Tag parentTag = null;
					int stackSize = stackTag.size();
					//取得最后一个为parentTag
					if (stackSize > 0) parentTag = stackTag.get(stackSize - 1);
					//analyze tag header
					//current tag is id

					//state = State.STATE_OPEN_NAME_BEGIN;
					phase = Phase.OPEN_NAME_BEGIN;
					//changeState(state);

					//parseTagOpen();
					//这里应该是个循环而不是if语句
					innerWhile:
					while (state > 0) {
						if (state == State.STATE_CLOSE_END) {
							//goto out loop
							continue outerFor;
						} else if (state == State.STATE_BODY_BEGIN) {
							//开始body的解析
							parseTagBody();
						} else if (state == State.STATE_OPEN_BEGIN) {
							parseTagOpen();
						} else if (state == State.STATE_CLOSE_BEGIN) {
							parseTagClose();
						}else {
							//continue innerWhile;
						}
					}


					//继续分析
				} else if (nextId.equals("/")) {
					System.out.println("这是个结束符，进入tag结束的分析状态,pop顶上的tag");
					parseTagClose();
				} else if (nextId.equals("!")) {
					//这是最开始支持doctype html5的声明
					parseDoctype();
					continue outerFor;
//					Toke ttt = readtoke();
//					id = ttt.getId();
//					continue innerIf;
				}
			}
		}
	}
	
	
	public void parser(){
		int len = tokeList.size();
		System.out.println("len:"+len);
		currentIndex=0;
		System.out.println("----------begin parser--------");
		outerFor:for(int i=0;i<len;i++){
			//Toke t = tokeList.get(i);
			Toke t=readtoke();
			//相当于最后已经结束
			if(t==null) {
				//all to end,then print stat
				parseEndInfo();
				break ;
			}
			//currentIndex++;
			String id = t.getId();

			System.out.print(" toke id:"+id+"  ");
			System.out.println("目前i:"+i);

			//每次都是开始<的时候进入,每次循环则可以跳出一个完整的tag
			innerIf:if(id.equals("<")) {
				//state = State.STATE_OPEN_BEGIN;
				//changeState(state);
				t = readtoke();
				String id1=null;
				//id1是标签的标识符
				if(t!=null) {
					id1 = t.getId();
					System.out.println("<下一个:"+id1);
				}
				if(id1==null) break;
				if (tagSet.contains(id1)) {
					System.out.println("这是个开始，进入tag开始的分析状态,指定tag并且push,然后分析body");
					//开始解析,返回来的tag
					Tag parentTag = null;
					int stackSize = stackTag.size();
					//取得最后一个为parentTag
					if (stackSize > 0) parentTag = stackTag.get(stackSize - 1);
					//analyze tag header
					//current tag is id

					state = State.STATE_OPEN_BEGIN;
					//changeState(state);

					//parseTagOpen();
					//这里应该是个循环而不是if语句
					innerWhile:while (state>0) {
						//已经读完了一个Tag
						if (state == State.STATE_CLOSE_END) {
							//goto out loop,重新查看新的tag
							continue outerFor;
						} else if (state == State.STATE_BODY_BEGIN) {
							//开始body的解析
							parseTagBody();
						}else  if(state== State.STATE_OPEN_BEGIN){
							parseTagOpen();
						}else  if(state== State.STATE_CLOSE_BEGIN){
							parseTagClose();
						}
					}
					//tag.setId(t.getId());
				}else if(id1.equals("/")){
					System.out.println("这是个结束符，进入tag结束的分析状态,pop顶上的tag");
					parseTagClose();

				}//just deal with !html5
				else if(id1.equals("!")){
					//这是最开始支持doctype html5的声明
					parseDoctype();
					continue outerFor;
//					Toke ttt = readtoke();
//					id = ttt.getId();
//					continue innerIf;
				}
			}
		}
	}




	private void changeState(int currentStateInt){
		State state = new State(currentStateInt);
		Toke currentToke = getCurrentToke();
		state.setBeginIndex(currentToke.getBegin());
		state.setEndIndex(currentToke.getEnd());
		stateLinkedList.add(state);
	}


	private void parseDoctype(){
		Toke toke = readtoke();
		String id3 = toke.getId();
		if(id3.equalsIgnoreCase("DOCTYPE")){
			htmlDoc.setDoctype("html5");
			Toke toke1 = readtoke();
			String id4 = toke1.getId();
			if(id4.equalsIgnoreCase("html")){
				readtoke();
				state = State.STATE_CLOSE_END;
				changeState(state);
			}
		}
	}


	private void parseEndInfo(){
		System.out.println("stack size:"+stackTag.size());
		System.out.println("taglist size:"+tagsList.size());
		System.out.println("hashmap size:"+tagexMap.size());
		System.out.println("if stack size is zero, is ok");

		Tagex tagex = tagsList.get(0);
		System.out.println(tagex.getName());

		//Tagex tagex1=tagexMap.get("html-17");
		Set<String> keys = tagexMap.keySet();
		for(String key:keys){
			System.out.println("key:"+key);
		}
		//System.out.println("tagex1:"+tagex1.getName());
	}
	
	
	private Tag getParentTag(){
		int size = stackTag.size();
		if(size==0) return null;
		else return stackTag.get(size-1);
	}


	private Tag getStackTopTag(){
		int size = stackTag.size();
		if(size==0) return null;
		else return stackTag.get(size-1);
	}

	private Tagex getParentTagex(){
		int size = stackTag.size();
		if(size==0) return null;
		else return stackTag.get(size-1);
	}
	
	//parse open tag
	private void parseTagOpen(){

		System.out.println("inside tag open...");

		//get last toke
		Toke t = tokeList.get(currentIndex-1);
		System.out.println("<id begin tag open parse: "+t.getId());

		Tagex tagex= new Tagex();
		tagex.setName(t.getId());
		
		System.out.println("tagexid:"+tagex.getName()+" toke id:"+t.getId());
		
		tagex.setOpenBeginTokeIndex(t.getBegin()-1);
		tagex.buildKey();

		//设置父tag
		setParentEx(tagex);
		//入栈
		store(tagex);
		//开始的时候push入栈
		stackTag.push(tagex);
		//或者tagStacksize==0也是一样的效果
		
		if(getParentTag()==null) rootTagex = tagex;
		//put to stacktop
		//stackTag.push(tagex);

		//读下一个toke
		Toke t1= readtoke();
		String id = t1.getId();

		System.out.println("open next id:"+id+" current index:"+currentIndex);
		//paser open inner
		while(!id.equals("/")&&!id.equals(">")){
			//if attrname,then set attrname and value
			if(attrNameSet.contains(id)){

				phase= Phase.ATTR_BEGIN;
				//changeState(state);

				//Toke t2=readtoke();
				//String id2= t2.getId();

				Toke nextToke = getNextToke();
				String nextID = nextToke.getId();


				System.out.println("attrname id:"+id);
				//add attr key and value
				if(nextID.equals("=")){

					//state = State.STATE_ATTR_EQUAL_BEGIN;
					phase = Phase.ATTR_EQUAL_BEGIN;
					//changeState(state);

					Toke t2 = readtoke();//this is an equal

					Toke t3= readtoke();
					String id3= t3.getId();
					System.out.println("attr value id3:"+id3);
					System.out.println("toketype :"+t3.getType());
					if(t3.getType()== Toke.TYPE_QUOTECONTENT){

						//state = State.STATE_ATTRVALUE_BEGIN;
						//changeState(state);
						phase = Phase.ATTRVALUE_BEGIN;

						System.out.println("addattr");
						tagex.addAttr(id, id3);
					}else{
						System.out.println("error! after attrname is not value");
					}
				}else if(nextToke.getType()== Toke.TYPE_ID){
					//add single attr,just attr key
					tagex.addAttr(id, null);
				}
				System.out.println("tagex el:"+tagex.renderHtml()+" tag attr:"+tagex.getAttr("rel"));
			}
			else{
				System.out.println("not attr name");
				System.out.println("error in "+currentIndex);
				Toke cuurentToke = tokeList.get(currentIndex);
				System.out.println(cuurentToke.getBegin());
				//tag.addAttr(id, null);
			}
			//continue read next toke
			t1= readtoke();
			id= t1.getId();
		}
		//最后判断结束符
		if(id.equals("/")){
			//read next

			Toke nextToke = getNextToke();
			if(nextToke!=null&&nextToke.equals(">")){
				//state = State.STATE_CLOSE_BEGIN;
				phase = Phase.CLOSE_BEGIN;
				//changeState(state);
			}

			Toke tt=readtoke();
			if(tt.getId().equals(">")){
				//当前的open和整个tag解析结束
				//将tag放入stack
				//this is a half close tag,do not push to stack,directly put it to map;
				tagex.buildKey();
				tagex.setSlash(1);

				//遇到结束符，则出栈
				stackTag.pop();
				phase = Phase.CLOSE_END;
				state= State.STATE_CLOSE_END;

				//changeState(state);
			}else{
				System.out.println("/之后不是>，语法出错");
			}
		}else if(id.equals(">")){
			//parse open end
			tagex.buildKey();
			//put to map and stack
			//一个问题，是在开始的时候加，还是结束的时候加？开始的时候加吧
//			stackTag.push(tagex);
			//当前的open解析完成，进入body的解析

			//查看
			Tag lastTag = getStackTopTag();
			//if belongs to no close tags,instant
 			if(noCloseTagSet.contains(lastTag.getName())){
 				tagex.setSlash(2);
				stackTag.pop();
				state= State.STATE_CLOSE_END;
				//changeState(state);
			}else{
				state= State.STATE_BODY_BEGIN;
				//changeState(state);
			}
			//parseTagBody(t);
			//parseTagBody();
		}
		//return;
	}


	private void store(Tagex tagex){
		tagexMap.put(tagex.getKey(),tagex);
		tagsList.add(tagex);
	}


	private void setParentEx(Tagex tagex){
		//
		Tagex parentTag = getParentTagex();
		if(parentTag==null) rootTagex = tagex;
		else {
			tagex.setParentTag(parentTag);
			parentTag.addChild(tagex);
		}
	}

	private void putToMap(Tagex tagex){
		tagexMap.put(tagex.getKey(),tagex);
	}
	
	private void parseTagClose(){

		Toke nextToke = getNextToke();
		String nextID = nextToke.getId();

		if(nextID!=null&&tagSet.contains(nextID)){
			//state = State.STATE_FULL_CLOSE_BEGIN;
			phase = Phase.FULL_CLOSE_BEGIN;
			//changeState(state);
		}

		Toke t = readtoke();
		String id = t.getId();

		System.out.println("begin close parse,</id> or /> next id:"+id);
		if(tagSet.contains(id)){
			Toke tt=readtoke();
			String id1= tt.getId();
			if(id1.equals(">")) {
				System.out.println("stack size mememe::"+stackTag.size());

				//读取结束
				if(stackTag.size()>0){
					stackTag.pop();
					state = State.STATE_CLOSE_END;
				}else {
					state = State.STATE_CLOSE_END;
				}
				//changeState(state);
			}
		}else{
			state = State.STATE_ERROR;
			//changeState(state);
			System.out.println("/之后不是tagid,出错");
		}
	}
	
	private void parseTagBody(){

		Toke t= readtoke();
		String id= t.getId();
		//text content,direct set text
		System.out.println("begin body parse,after >,next id:"+id);

		//Toke t2 = readtoke();
		//String id2 = t2.getId();

		while (!id.equals("<")){
			//this is a text
			//state = State.STATE_BODY_TEXT_BEGIN;
			//ungettoke();
			phase = Phase.BODY_TEXT_BEGIN;
			//changeState(state);

			//getParentTag().addText(id);

			getParentTag().addChild(new Text((id)));
			Toke nextT=readtoke();
			id= nextT.getId();
		}

		//inner tag,
		if (id.equals("<")){
			Toke next = readtoke();
			String idnext= next.getId();
			//if </ then is an end
			if(idnext.equals("/")){
				//结束符
				//parseTagClose();
				state = State.STATE_CLOSE_BEGIN;
				//changeState(state);
				// is a new child tag
			}else{
				//a new child tag
				state = State.STATE_OPEN_BEGIN;
				//changeState(state);
				//tagStack.push(t);
				//parseTagOpen();
			}
		}
	}

	//read next toke,currentIndex pointer to the next toke
	private Toke readtoke(){
		if(currentIndex>=tokeList.size()) return null;
		Toke t=tokeList.get(currentIndex);
		System.out.println("readtoke id:"+t.getId());
		currentIndex++;
		return t;
	}

	private void ungettoke(){
		currentIndex--;
	}

	//get current parsing toke,currentIndex pointer to the next toke,currentIndex -1
	private Toke getCurrentToke(){
		if(currentIndex==0) return null;
		Toke t = tokeList.get(currentIndex-1);
		return  t;
	}

	//read next toke,but do not change the currentIndex,attention currentIndex is the next index
	private Toke getNextToke(){
		//if(currentIndex==0) return null;
		Toke t = tokeList.get(currentIndex);
		return  t;
	}

	//read next n toke ,but do not change the currentIndex
	private Toke getNextNToke(int n){
		int len = tokeList.size();
		Toke t=null;
		int nextN = currentIndex+n;
		if(nextN<len){
			t=tokeList.get(nextN);
		}
		return t;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public LinkedList<Toke> getTokeList() {
		return tokeList;
	}

	public void setTokeList(LinkedList<Toke> tokeList) {
		this.tokeList = tokeList;
	}
	
	
	
	
	
	
	
	
	

}
