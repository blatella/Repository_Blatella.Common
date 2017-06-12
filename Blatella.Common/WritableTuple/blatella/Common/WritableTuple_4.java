package blatella.Common;

public class WritableTuple_4<A,B,C,D> extends WritableTuple_3<A,B,C> implements java.io.Serializable
{
	private static final long serialVersionUID = -1831801114142441454L;
	
	public D item4;
	
	public WritableTuple_4()
    {
    }

    public WritableTuple_4(A item1,B item2,C item3,D item4)
    {
    	super(item1,item2,item3);
    	this.item4=item4;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s"
        								, item1 == null ? "null" : item1.toString()
                                		, item2 == null ? "null" : item2.toString()
                                		, item3 == null ? "null" : item3.toString()
                                		, item4 == null ? "null" : item4.toString()
                            );
    }
}