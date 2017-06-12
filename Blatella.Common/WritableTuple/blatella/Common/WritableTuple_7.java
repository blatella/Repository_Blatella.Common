package blatella.Common;

public class WritableTuple_7<A,B,C,D,E,F,G> extends WritableTuple_6<A,B,C,D,E,F> implements java.io.Serializable
{
	private static final long serialVersionUID = -7634389026813795557L;
	
	public G item7;
	
	public WritableTuple_7()
    {
    }

    public WritableTuple_7(A item1,B item2,C item3,D item4,E item5,F item6,G item7)
    {
    	super(item1,item2,item3,item4,item5,item6);
    	this.item7=item7;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s"
        								, item1== null ? "null" : item1.toString()
                                		, item2 == null ? "null" : item2.toString()
                                		, item3 == null ? "null" : item3.toString()
                                		, item4 == null ? "null" : item4.toString()
                                		, item5 == null ? "null" : item5.toString()
                                		, item6 == null ? "null" : item6.toString()
                                		, item7 == null ? "null" : item7.toString()
                            );
    }
}