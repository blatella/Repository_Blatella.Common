package blatella.Common;

public class WritableTuple_3<A,B,C> extends WritableTuple_2<A,B> implements java.io.Serializable
{
	private static final long serialVersionUID = -384100828228098462L;
	
	public C item3;
	
	public WritableTuple_3()
    {
    }

    public WritableTuple_3(A item1,B item2,C item3)
    {
    	super(item1,item2);
    	this.item3=item3;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s"
        								, item1 == null ? "null" : item1.toString()
                                		, item2 == null ? "null" : item2.toString()
                                		, item3 == null ? "null" : item3.toString()
                            );
    }

}