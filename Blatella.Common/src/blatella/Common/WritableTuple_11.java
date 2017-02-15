package blatella.Common;

public class WritableTuple_11<A,B,C,D,E,F,G,H,I,J,K> extends WritableTuple_10<A,B,C,D,E,F,G,H,I,J> implements java.io.Serializable
{
	private static final long serialVersionUID = 2885633133888992239L;

	public K item11;
	public K getItem11() {
		return item11;
	}
	public void setItem11(K item11) {
		this.item11 = item11;
	}
	public WritableTuple_11()
    {
    }

    public WritableTuple_11(A item1,B item2,C item3,D item4,E item5,F item6,G item7,H item8,I item9,J item10,K item11)
    {
    	super(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10);
    	setItem11(item11);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s, %10$s, %11$s"
        								, getItem1() == null ? "null" : getItem1().toString()
                                		, getItem2() == null ? "null" : getItem2().toString()
                                		, getItem3() == null ? "null" : getItem3().toString()
                                		, getItem4() == null ? "null" : getItem4().toString()
                                		, getItem5() == null ? "null" : getItem5().toString()
                                		, getItem6() == null ? "null" : getItem6().toString()
                                		, getItem7() == null ? "null" : getItem7().toString()
                                		, getItem8() == null ? "null" : getItem8().toString()
                                		, getItem9() == null ? "null" : getItem9().toString()
                                		, getItem10() == null ? "null" : getItem10().toString()
                                		, getItem11() == null ? "null" : getItem11().toString()
                            );
    }
}