package blatella.Common;

import org.w3c.dom.*;


public class Utility 
{
	public static final String EMPTY_STRING = "";
	
	public static Error GetError(Exception exception)
    {
        Error _answer = new Error();
        GetStackTraceData(_answer, exception.getStackTrace());
        _answer.setException(exception);
        return _answer;
    }
	
	private static void GetStackTraceData(Error error,StackTraceElement[] trace)
    {
		if(error!=null && trace!=null && trace.length>0)
		{
			StackTraceElement _frame = trace[0];
            error.setClassName(_frame.getClassName());
            error.setFileName(_frame.getFileName());
            error.setMethodName(_frame.getMethodName());
            error.setLine(_frame.getLineNumber());
		}
    }
	
	public static boolean IsNullOrEmpty(String param)
	{ 
	    return param == null || param.trim().length() == 0;
	}
	
	public static boolean IsNullOrWhiteSpace(String param)
	{ 
	    boolean _respuesta=IsNullOrEmpty(param);
	    if(!_respuesta)
	    {
	    	String _cadenaSinBlancos=param.replace(" ",EMPTY_STRING);
	    	_respuesta=IsNullOrEmpty(_cadenaSinBlancos);
	    }
	    return _respuesta;
	}
	
	public static boolean TryParseInt(String value) 
	{  
		boolean _answer=true;
		try
		{  
	         Integer.parseInt(value);
	    }
		catch (Exception e)
		{  
			_answer= false;  
	    }
		return _answer;
	}
	
	public static String GetAttributeValue(Node node,String attributeName)
    {
		String _answer=EMPTY_STRING;
		try
		{
			if(node != null && node.hasAttributes() && !Utility.IsNullOrEmpty(attributeName)  )
			{
				Element e = (Element)node;
				_answer = e.getAttribute(attributeName);
			}
		}
		catch(Exception e)
		{
			_answer=EMPTY_STRING;
		}
		return _answer;
    }
}
