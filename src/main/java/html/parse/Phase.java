package html.parse;

/**
 * Created by Administrator on 2017-3-9.
 */
public class Phase {

    public final static int OPEN_BEGIN=1;
    public final static int OPEN_END=2;

    public final static int BODY_BEGIN=3;
    public final static int BODY_END=4;

    public final static int BODY_TEXT_BEGIN=4;
    public final static int BODY_TEXT_END=5;

    public final static int CLOSE_BEGIN=6;
    public final static int CLOSE_END=7;

    public final static int OPEN_NAME_BEGIN=8;
    public final static int OPEN_NAME_END=9;

    public final static int ATTR_BEGIN=10;
    public final static int ATTR_END=11;
    public final static int ATTR_EQUAL_BEGIN =12;
    public final static int ATTR_EQUAL_END =13;

    public final static int ATTRVALUE_BEGIN=14;
    public final static int ATTRVALUE_END=15;

    public final static int CLASSNAME_BEGIN=16;
    public final static int CLASSNAME_END=17;

    public final static int CLASSVALUE_BEGIN=18;
    public final static int CLASSVALUE_END=19;

    public final static int STYLENAME_BEGIN=20;
    public final static int STYLENAME_END=21;

    public final static int STYLEVALUE_BEGIN=22;
    public final static int STYLEVALUE_END=23;

    public final static int HALF_CLOSE_BEGIN=24;
    public final static int HALF_CLOSE_END=25;

    public final static int FULL_CLOSE_BEGIN=26;
    public final static int FULL_CLOSE_END=27;

    public final static int FULL_CLOSE_NAME_BEGIN=28;
    public final static int FULL_CLOSE_NAME_END=29;

    public final static int SINGLE_ATTR_BEGIN=30;
    public final static int SINGLE_ATTR_END=31;


    public final static int ERROR=-1;


    int currentPhase;

    int beginIndex;
    int endIndex;


    public static int getOpenBegin() {
        return OPEN_BEGIN;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
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
}
