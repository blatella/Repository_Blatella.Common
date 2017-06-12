package blatella.Common;

public class WritableTuple_8<A,B,C,D,E,F,G,H> extends WritableTuple_7<A,B,C,D,E,F,G> implements java.io.Serializable
{
	private static final long serialVersionUID = 4903867334027805681L;
	
	public H item8;
	
	public WritableTuple_8()
    {
    }

    public WritableTuple_8(A item1,B item2,C item3,D item4,E item5,F item6,G item7,H item8)
    {
    	super(item1,item2,item3,item4,item5,item6,item7);
    	this.item8=item8;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s"
        								, item1 == null ? "null" : item1.toString()
                                		, item2 == null ? "null" : item2.toString()
                                		, item3 == null ? "null" : item3.toString()
                                		, item4 == null ? "null" : item4.toString()
                                		, item5 == null ? "null" : item5.toString()
                                		, item6 == null ? "null" : item6.toString()
                                		, item7 == null ? "null" : item7.toString()
                                		, item8 == null ? "null" : item8.toString()
                            );
    }
}
