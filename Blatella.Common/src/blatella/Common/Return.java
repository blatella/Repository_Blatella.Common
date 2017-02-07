package blatella.Common;

public class Return<T>
{
    protected boolean theresError;
    public boolean isTheresError() {
		return theresError;
	}
	public void setTheresError(boolean theresError) {
		this.theresError = theresError;
	}

	protected String message ;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	protected Error error ;
    public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	
	protected T data ;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	//--------------------------------------------------------------------------------------------------------
	public Return()
    {
        InitializeValues();
    }
	//--------------------------------------------------------------------------------------------------------
	private void InitializeValues()
    {
        theresError = false;
        message = Utility.EMPTY_STRING;
        error = new Error();
    }
}
