package blatella.Common;

public class WritableTuple_9<A,B,C,D,E,F,G,H,I> extends WritableTuple_8<A,B,C,D,E,F,G,H> implements java.io.Serializable
{
	private static final long serialVersionUID = 7707300572080124748L;

	public I item9;
	public I getItem9() {
		return item9;
	}
	public void setItem9(I item9) {
		this.item9 = item9;
	}
	public WritableTuple_9()
    {
    }

    public WritableTuple_9(A item1,B item2,C item3,D item4,E item5,F item6,G item7,H item8,I item9)
    {
    	super(item1,item2,item3,item4,item5,item6,item7,item8);
    	setItem9(item9);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s"
        								, getItem1() == null ? "null" : getItem1().toString()
                                		, getItem2() == null ? "null" : getItem2().toString()
                                		, getItem3() == null ? "null" : getItem3().toString()
                                		, getItem4() == null ? "null" : getItem4().toString()
                                		, getItem5() == null ? "null" : getItem5().toString()
                                		, getItem6() == null ? "null" : getItem6().toString()
                                		, getItem7() == null ? "null" : getItem7().toString()
                                		, getItem8() == null ? "null" : getItem8().toString()
                                		, getItem9() == null ? "null" : getItem9().toString()
                            );
    }
}