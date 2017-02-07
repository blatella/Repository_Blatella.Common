package blatella.Common;

public class Error 
{
	protected String className;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	protected String fileName ;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	protected String methodName;
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	protected int line ;
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}

	protected Exception exception ;
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}

	protected Object extraInformation;
	public Object getExtraInformation() {
		return extraInformation;
	}
	public void setExtraInformation(Object extraInformation) {
		this.extraInformation = extraInformation;
	}
	
	public Error() 
	{
		setClassName(Utility.EMPTY_STRING);
		setFileName(Utility.EMPTY_STRING);
		setMethodName(Utility.EMPTY_STRING);
		setLine(0);
		setException(null);
		setExtraInformation(null);
	}
	     
	public  String toString()
	{
		String _separator=System.lineSeparator();
		String _className=getClassName();
		String _fileName=getFileName();
		String _methodName=getMethodName();
		String _line=Integer.toString(getLine());
		String _exceptionMessage=exception == null || Utility.IsNullOrEmpty(exception.getMessage()) ? exception.getClass().getName(): exception.getMessage();
		
		String _answer = String.format("Class: %2$s %1$s File: %3$s %1$s Method: %4$s %1$s Line: %5$s %1$s Error: %6$s"
                ,_separator, _className, _fileName, _methodName, _line, _exceptionMessage);
		
	     return _answer;
	}
}
