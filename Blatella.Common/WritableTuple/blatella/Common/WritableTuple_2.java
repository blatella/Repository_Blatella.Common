package blatella.Common;

public class WritableTuple_2<A,B> extends WritableTuple_1<A> implements java.io.Serializable
{
	private static final long serialVersionUID = -6536470621761877125L;
	
	public B item2;
	
	public WritableTuple_2()
    {
    }

    public WritableTuple_2(A item1,B item2)
    {
    	super(item1);
        this.item2=item2;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s"
                                ,item1 == null ? "null" : item1.toString()
                                , item2 == null ? "null" : item2.toString()
                            );
    }	
}