package blatella.Common;

public class WritableTuple_5<A,B,C,D,E> extends WritableTuple_4<A,B,C,D> implements java.io.Serializable
{
	private static final long serialVersionUID = -1844723144189797032L;
	
	public E item5;
	
	public WritableTuple_5()
    {
    }

    public WritableTuple_5(A item1,B item2,C item3,D item4,E item5)
    {
    	super(item1,item2,item3,item4);
    	this.item5=item5;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s"
        								, item1 == null ? "null" : item1.toString()
                                		, item2 == null ? "null" : item2.toString()
                                		, item3 == null ? "null" : item3.toString()
                                		, item4 == null ? "null" : item4.toString()
                                		, item5 == null ? "null" : item5.toString()
                            );
    }
}
