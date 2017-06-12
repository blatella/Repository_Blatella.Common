package blatella.Common;

public class Return<T>
{
	public boolean theresError;
    
	public String message ;
	
	public Error error ;
    
	public T data ;
	
	//--------------------------------------------------------------------------------------------------------
	public Return()
    {
        InitializeValues();
    }
	public Return(T data)
    {
        this();
        this.data=data;
    }
	//--------------------------------------------------------------------------------------------------------
	private void InitializeValues()
    {
        theresError = false;
        message = Utility.EMPTY_STRING;
        error = new Error();
    }
}
