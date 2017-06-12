package blatella.Common;

public class WritableTuple_11<A,B,C,D,E,F,G,H,I,J,K> extends WritableTuple_10<A,B,C,D,E,F,G,H,I,J> implements java.io.Serializable
{
	private static final long serialVersionUID = 2885633133888992239L;

	public K item11;
	
	public WritableTuple_11()
    {
    }

    public WritableTuple_11(A item1,B item2,C item3,D item4,E item5,F item6,G item7,H item8,I item9,J item10,K item11)
    {
    	super(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10);
    	this.item11=item11;
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s, %10$s, %11$s"
        								, item1 == null ? "null" : item1.toString()
                                		, item2 == null ? "null" : item2.toString()
                                		, item3 == null ? "null" : item3.toString()
                                		, item4 == null ? "null" : item4.toString()
                                		, item5 == null ? "null" : item5.toString()
                                		, item6 == null ? "null" : item6.toString()
                                		, item7 == null ? "null" : item7.toString()
                                		, item8 == null ? "null" : item8.toString()
                                		, item9 == null ? "null" : item9.toString()
                                		, item10 == null ? "null" : item10.toString()
                                		, item11 == null ? "null" : item11.toString()
                            );
    }
}