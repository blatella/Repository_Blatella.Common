package blatella.Common;

public class WritableTuple_3<A,B,C> extends WritableTuple_2<A,B> implements java.io.Serializable
{
	private static final long serialVersionUID = -384100828228098462L;
	
	public C item3;
	public C getItem3() {
		return item3;
	}
	public void setItem3(C item3) {
		this.item3 = item3;
	}
	public WritableTuple_3()
    {
    }

    public WritableTuple_3(A item1,B item2,C item3)
    {
    	super(item1,item2);
    	setItem3(item3);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s"
        								, getItem1() == null ? "null" : getItem1().toString()
                                		, getItem2() == null ? "null" : getItem2().toString()
                                		, getItem3() == null ? "null" : getItem3().toString()
                            );
    }

}