package blatella.Common;

public class WritableTuple_1<A> implements java.io.Serializable
{
	private static final long serialVersionUID = -4893328420706129516L;
	
	public A item1;
	
	public WritableTuple_1()
    {
    }

    public WritableTuple_1(A item1)
    {
        this.item1=item1;
    }

    public String toString()
    {
        return String.format("%1$s"
                                , item1 == null ? "null" : item1.toString()
                            );
    }
}