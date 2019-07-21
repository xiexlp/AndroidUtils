package html.parse;

public class State {
	
	public final static int STATE_OPEN_BEGIN=1;
	public final static int STATE_OPEN_END=2;

	public final static int STATE_BODY_BEGIN=3;
	public final static int STATE_BODY_END=4;

	public final static int STATE_BODY_TEXT_BEGIN=4;
	public final static int STATE_BODY_TEXT_END=5;

	public final static int STATE_CLOSE_BEGIN=6;
	public final static int STATE_CLOSE_END=7;

	public final static int STATE_OPEN_NAME_BEGIN=8;
	public final static int STATE_OPEN_NAME_END=9;

	public final static int STATE_ATTR_BEGIN=10;
	public final static int STATE_ATTR_END=11;
	public final static int STATE_ATTR_EQUAL_BEGIN =12;
	public final static int STATE_ATTR_EQUAL_END =13;

	public final static int STATE_ATTRVALUE_BEGIN=14;
	public final static int STATE_ATTRVALUE_END=15;

	public final static int STATE_CLASSNAME_BEGIN=16;
	public final static int STATE_CLASSNAME_END=17;

	public final static int STATE_CLASSVALUE_BEGIN=18;
	public final static int STATE_CLASSVALUE_END=19;

	public final static int STATE_STYLENAME_BEGIN=20;
	public final static int STATE_STYLENAME_END=21;

	public final static int STATE_STYLEVALUE_BEGIN=22;
	public final static int STATE_STYLEVALUE_END=23;

	public final static int STATE_HALF_CLOSE_BEGIN=24;
	public final static int STATE_HALF_CLOSE_END=25;

	public final static int STATE_FULL_CLOSE_BEGIN=26;
	public final static int STATE_FULL_CLOSE_END=27;

	public final static int STATE_FULL_CLOSE_NAME_BEGIN=28;
	public final static int STATE_FULL_CLOSE_NAME_END=29;

	public final static int STATE_SINGLE_ATTR_BEGIN=30;
	public final static int STATE_SINGLE_ATTR_END=31;


	public final static int STATE_ERROR=-1;


	int currentState;

	int beginIndex;
	int endIndex;



	public State(int currentState){
		this.currentState = currentState;
	}




	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
}
