package blatella.Common;

public class WritableTuple_12<A,B,C,D,E,F,G,H,I,J,K,L> extends WritableTuple_11<A,B,C,D,E,F,G,H,I,J,K> implements java.io.Serializable
{
	private static final long serialVersionUID = -3580782704837856596L;
	
	public L item12;
	public L getItem12() {
		return item12;
	}
	public void setItem12(L item12) {
		this.item12 = item12;
	}
	
	public WritableTuple_12()
    {
    }

    public WritableTuple_12(A item1,B item2,C item3,D item4,E item5,F item6,G item7,H item8,I item9,J item10,K item11,L item12)
    {
    	super(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11);
    	setItem12(item12);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s, %10$s, %11$s, %12$s"
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
                                		, getItem12() == null ? "null" : getItem12().toString()
                            );
    }
}