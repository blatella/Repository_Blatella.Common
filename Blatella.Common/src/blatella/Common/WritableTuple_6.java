package blatella.Common;

public class WritableTuple_6<A,B,C,D,E,F> extends WritableTuple_5<A,B,C,D,E> implements java.io.Serializable
{
	private static final long serialVersionUID = 4392544666781129755L;
	
	public F item6;
	public F getItem6() {
		return item6;
	}
	public void setItem6(F item6) {
		this.item6 = item6;
	}
	public WritableTuple_6()
    {
    }

    public WritableTuple_6(A item1,B item2,C item3,D item4,E item5,F item6)
    {
    	super(item1,item2,item3,item4,item5);
    	setItem6(item6);
    }

    public String toString()
    {
        return String.format("%1$s, %2$s, %3$s, %4$s, %5$s, %6$s"
        								, getItem1() == null ? "null" : getItem1().toString()
                                		, getItem2() == null ? "null" : getItem2().toString()
                                		, getItem3() == null ? "null" : getItem3().toString()
                                		, getItem4() == null ? "null" : getItem4().toString()
                                		, getItem5() == null ? "null" : getItem5().toString()
                                		, getItem6() == null ? "null" : getItem6().toString()
                            );
    }
}