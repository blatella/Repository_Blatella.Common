import java.util.*;
import java.io.*;
import blatella.Common.*;

public class Test_001 
{
	public static void main(String[] args) 
	{
		Return<Object>_respuesta=new Return<Object>();
		
		_respuesta=TestDiccionario();
		
		if(_respuesta.isTheresError())
			System.out.println(_respuesta.getError().toString());
		else
			System.out.println("prueba finalizada");
	}
	
	private static Return<Object> TestTuplas()
	{
		Return<Object>_respuesta=new Return<Object>();
		try
		{
			//WritableTuple_2<String,String>_tupla1=new WritableTuple_2<String,String>("prueba 1","prueba 2");
			//System.out.println(_tupla1.toString());
			
		/*
			String _filePath="D:\\DESCARGA\\prueba.ser";
			FileOutputStream _fileOutputStream = new FileOutputStream(_filePath);
			ObjectOutputStream _objectOutputStream = new ObjectOutputStream(_fileOutputStream);
			_objectOutputStream.writeObject(_tupla1);
			_objectOutputStream.close();
			_fileOutputStream.close();
			System.out.println("serializamos");
			
			FileInputStream _fileInputStream = new FileInputStream(_filePath);
			ObjectInputStream _objectInputStream = new ObjectInputStream(_fileInputStream);
	        @SuppressWarnings({ "unchecked", "unused" })
	        WritableTuple_2<String,String>_tupla2= (WritableTuple_2<String,String>) _objectInputStream.readObject();
	        _objectInputStream.close();
	        _fileInputStream.close();
	        System.out.println(_tupla1.toString());
	        System.out.println("deserializamos");
	        */
			
			WritableTuple_2<String,Integer>_tupla2=new WritableTuple_2<String,Integer>("prueba 1",4);
		}
		catch(Exception _ex)
		{
			_respuesta.setTheresError(true);
			_respuesta.setError(Utility.GetError(_ex));
		}
		return _respuesta;
	}
	
	private static Return<Object> TestDiccionario()
	{
		Return<Object>_respuesta=new Return<Object>();
		try
		{
			HashMap<String,Integer>_test1=new HashMap<String,Integer>();
			_test1.put("abc", 1);
			_test1.put("cba", 2);
			_test1.put("abcd", 3);
			_test1.put("abcdr", 4);
		}
		catch(Exception _ex)
		{
			_respuesta.setTheresError(true);
			_respuesta.setError(Utility.GetError(_ex));
		}
		return _respuesta;
	}
	
}