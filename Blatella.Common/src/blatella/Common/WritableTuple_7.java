package blatella.Common;

public class WritableTuple_7<A,B,C,D,E,F,G> extends WritableTuple_6<A,B,C,D,E,F> implements java.io.Serializable
{
	private static final long serialVersionUID = -7634389026813795557L;
	
	public G item7;
	public G getItem7() {
		return item7;
	}
	public void setItem7(G item7) {
		this.item7 = item7;
	}
	public WritableTuple_7()
    {
    }

    public WritableTuple_7(A item1,B item2,C item3,D item4,E item5,F item6,G item7)
    {
    	super(item1,item2,item3,item4,item5,item6);
    	setItem7(item7);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s"
        								, getItem1() == null ? "null" : getItem1().toString()
                                		, getItem2() == null ? "null" : getItem2().toString()
                                		, getItem3() == null ? "null" : getItem3().toString()
                                		, getItem4() == null ? "null" : getItem4().toString()
                                		, getItem5() == null ? "null" : getItem5().toString()
                                		, getItem6() == null ? "null" : getItem6().toString()
                                		, getItem7() == null ? "null" : getItem7().toString()
                            );
    }
}