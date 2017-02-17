package blatella.Common;

import org.w3c.dom.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

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
	
	public static String Join(String separator,Collection<String> value) 
	{
	     StringBuilder builder = new StringBuilder();
	     Iterator<String> iter = value.iterator();
	     while (iter.hasNext())
	     {
	         builder.append(iter.next());
	         
	         if (!iter.hasNext())
	           break;                  
	         
	         builder.append(separator);
	     }
	     return builder.toString();
	 }
	
	public static List<String> Split(String value,String regex) 
	{
	     return Split(value,regex,true);
	}
	
	public static List<String> Split(String value,String regex,boolean removeEmptyEntries) 
	{
		List<String>_answer=Arrays.asList(value.split(regex));
		if(removeEmptyEntries)
			_answer=_answer.stream().filter(s->!IsNullOrEmpty(s)).collect(Collectors.toList());
	     
	     return _answer;
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

	
	public static boolean LessThan(BigDecimal value1,int value2)
	{
		return LessThan(value1,new BigDecimal(value2));
	}
	public static boolean LessThan(int value1,BigDecimal value2)
	{
		return LessThan(new BigDecimal(value1),value2);
	}
	public static boolean LessThan(BigDecimal value1,BigDecimal value2)
	{
		if (value1 == null)
            throw new IllegalArgumentException("value1");
		else
			if (value2 == null)
	            throw new IllegalArgumentException("value2");
			else
				return value1.compareTo(value2)==-1;
	}
	public static boolean GreaterThan(BigDecimal value1,int value2)
	{
		return GreaterThan(value1,new BigDecimal(value2));
	}
	public static boolean GreaterThan(int value1,BigDecimal value2)
	{
		return GreaterThan(new BigDecimal(value1),value2);
	}
	public static boolean GreaterThan(BigDecimal value1,BigDecimal value2)
	{
		if (value1 == null)
            throw new IllegalArgumentException("value1");
		else
			if (value2 == null)
	            throw new IllegalArgumentException("value2");
			else
				return value1.compareTo(value2)==1;
	}
	public static boolean EqualThan(BigDecimal value1,int value2)
	{
		return EqualThan(value1,new BigDecimal(value2));
	}
	public static boolean EqualThan(int value1,BigDecimal value2)
	{
		return EqualThan(new BigDecimal(value1),value2);
	}
	public static boolean EqualThan(BigDecimal value1,BigDecimal value2)
	{
		if (value1 == null)
            throw new IllegalArgumentException("value1");
		else
			if (value2 == null)
	            throw new IllegalArgumentException("value2");
			else
				return value1.compareTo(value2)==0;
	}
	public static boolean LessThanOrEqual(BigDecimal value1,int value2)
	{
		return LessThanOrEqual(value1,new BigDecimal(value2));
	}
	public static boolean LessThanOrEqual(int value1,BigDecimal value2)
	{
		return LessThanOrEqual(new BigDecimal(value1),value2);
	}
	public static boolean LessThanOrEqual(BigDecimal value1,BigDecimal value2)
	{
		return 	LessThan( value1, value2)||EqualThan(value1,value2);
	}
	public static boolean GreaterThanOrEqual(BigDecimal value1,int value2)
	{
		return GreaterThanOrEqual(value1,new BigDecimal(value2));
	}
	public static boolean GreaterThanOrEqual(int value1,BigDecimal value2)
	{
		return GreaterThanOrEqual(new BigDecimal(value1),value2);
	}
	public static boolean GreaterThanOrEqual(BigDecimal value1,BigDecimal value2)
	{
		return 	GreaterThan( value1, value2)||EqualThan(value1,value2);
	}
	
}
