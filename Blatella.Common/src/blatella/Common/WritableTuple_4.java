package blatella.Common;

public class WritableTuple_4<A,B,C,D> extends WritableTuple_3<A,B,C> implements java.io.Serializable
{
	private static final long serialVersionUID = -1831801114142441454L;
	
	public D item4;
	public D getItem4() {
		return item4;
	}
	public void setItem4(D item4) {
		this.item4 = item4;
	}
	public WritableTuple_4()
    {
    }

    public WritableTuple_4(A item1,B item2,C item3,D item4)
    {
    	super(item1,item2,item3);
    	setItem4(item4);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s"
        								, getItem1() == null ? "null" : getItem1().toString()
                                		, getItem2() == null ? "null" : getItem2().toString()
                                		, getItem3() == null ? "null" : getItem3().toString()
                                		, getItem4() == null ? "null" : getItem4().toString()
                            );
    }
}