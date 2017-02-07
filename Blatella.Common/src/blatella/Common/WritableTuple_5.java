package blatella.Common;

public class WritableTuple_5<A,B,C,D,E> extends WritableTuple_4<A,B,C,D> implements java.io.Serializable
{
	private static final long serialVersionUID = -1844723144189797032L;
	
	public E item5;
	public E getItem5() {
		return item5;
	}
	public void setItem5(E item5) {
		this.item5 = item5;
	}
	public WritableTuple_5()
    {
    }

    public WritableTuple_5(A item1,B item2,C item3,D item4,E item5)
    {
    	super(item1,item2,item3,item4);
    	setItem5(item5);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s"
        								, getItem1() == null ? "null" : getItem1().toString()
                                		, getItem2() == null ? "null" : getItem2().toString()
                                		, getItem3() == null ? "null" : getItem3().toString()
                                		, getItem4() == null ? "null" : getItem4().toString()
                                		, getItem5() == null ? "null" : getItem5().toString()
                            );
    }
}
