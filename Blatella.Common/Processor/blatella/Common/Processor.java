package blatella.Common;

import java.util.*;

public class Processor<T> implements AutoCloseable 
{
	protected List<Object> objects;
	
	@Override
	public void close() 
	{
		if (this.objects != null)
          for (Object _object : this.objects)
			{
			    if (_object != null && _object instanceof AutoCloseable)
			    {
			    	try { ((AutoCloseable)_object).close();}
                    catch (Exception _ex)
			    	{ }
			    }
			}
		
	}

}
