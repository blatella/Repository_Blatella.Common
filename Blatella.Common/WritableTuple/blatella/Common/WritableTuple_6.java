package blatella.Common;

public class WritableTuple_6<A,B,C,D,E,F> extends WritableTuple_5<A,B,C,D,E> implements java.io.Serializable
{
	private static final long serialVersionUID = 4392544666781129755L;
	
	public F item6;
	
	public WritableTuple_6()
    {
    }

    public WritableTuple_6(A item1,B item2,C item3,D item4,E item5,F item6)
    {
    	super(item1,item2,item3,item4,item5);
    	this.item6= item6;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s"
        								, item1 == null ? "null" : item1.toString()
                                		, item2 == null ? "null" : item2.toString()
                                		, item3 == null ? "null" : item3.toString()
                                		, item4 == null ? "null" : item4.toString()
                                		, item5 == null ? "null" : item5.toString()
                                		, item6 == null ? "null" : item6.toString()
                            );
    }
}