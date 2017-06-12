import java.util.*;
import java.io.*;
import java.util.stream.*;
import blatella.Common.*;

public class Test_001 
{
	public static void main(String[] args) 
	{
		Return<Object>_answer=new Return<Object>();
		
		//_answer=TestDictionary();
		//_answer=TestTuples();
		//_answer=TestJoin();
		//_answer= TestLINQ();
		_answer= TestSplit();
		
		if(_answer.isTheresError())
			System.out.println(_answer.getError().toString());
		else
			System.out.println("finished test");
	}
	
	private static Return<Object> TestTuples()
	{
		Return<Object>_answer=new Return<Object>();
		try
		{
			//WritableTuple_2<String,String>_tuple1=new WritableTuple_2<String,String>("prueba 1","prueba 2");
			//System.out.println(_tuple1.toString());
			
		/*
			String _filePath="D:\\DESCARGA\\prueba.ser";
			FileOutputStream _fileOutputStream = new FileOutputStream(_filePath);
			ObjectOutputStream _objectOutputStream = new ObjectOutputStream(_fileOutputStream);
			_objectOutputStream.writeObject(_tuple1);
			_objectOutputStream.close();
			_fileOutputStream.close();
			System.out.println("serializing");
			
			FileInputStream _fileInputStream = new FileInputStream(_filePath);
			ObjectInputStream _objectInputStream = new ObjectInputStream(_fileInputStream);
	        @SuppressWarnings({ "unchecked", "unused" })
	        WritableTuple_2<String,String>_tuple2= (WritableTuple_2<String,String>) _objectInputStream.readObject();
	        _objectInputStream.close();
	        _fileInputStream.close();
	        System.out.println(_tuple1.toString());
	        System.out.println("deserializing");
	        */
			
			//WritableTuple_2<String,Integer>_tuple2=new WritableTuple_2<String,Integer>("prueba 1",4);
			
			WritableTuple_13<String,String,String,String,String,String,String,String,String,String,String,String,String>_tuple
				=new WritableTuple_13<String,String,String,String,String,String,String,String,String,String,String,String,String>
						("01","02","03","04","05","06","07","08","09","10","11","12","13");
			String _test = _tuple.toString();
			String aa=_test;
		}
		catch(Exception _ex)
		{
			_answer.setTheresError(true);
			_answer.setError(Utility.GetError(_ex));
		}
		return _answer;
	}
	
	private static Return<Object> TestDictionary()
	{
		Return<Object>_answer=new Return<Object>();
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
			_answer.setTheresError(true);
			_answer.setError(Utility.GetError(_ex));
		}
		return _answer;
	}
	
	private static Return<Object> TestJoin()
	{
		Return<Object>_answer=new Return<Object>();
		try
		{
			//List<String>_list=Arrays.asList("aaaaa","bbbbb","ccccc");
			//List<String>_list=Arrays.asList("aaaaa","bbbbb");
			//List<String>_list=Arrays.asList("aaaaa");
			List<String>_list=new ArrayList<String>();
			String _join=Utility.Join(".",_list);
			System.out.println(_join);
		}
		catch(Exception _ex)
		{
			_answer.setTheresError(true);
			_answer.setError(Utility.GetError(_ex));
		}
		return _answer;
	}
	
	private static Return<Object> TestSplit()
	{
		Return<Object>_answer=new Return<Object>();
		try
		{
			//comment 20170611_005
			
			String _word = "aaa.bbb..cc";
			
			List<String>_list=Arrays.asList(_word.split("[.]"));
			for (String _entity:_list)
			    System.out.println(_entity);
			
			
			/*
			List<String>_personalList=Utility.Split(_word,"[.]");
			for (String _entity:_personalList)
			    System.out.println(_entity);
			*/
			/*
			List<String>_personalList=Utility.Split(_word,"[.]",false);
			for (String _entity:_personalList)
			    System.out.println(_entity);
			*/
		}
		catch(Exception _ex)
		{
			_answer.setTheresError(true);
			_answer.setError(Utility.GetError(_ex));
		}
		return _answer;
	}
	
	private static Return<Object> TestLINQ()
	{
		Return<Object>_answer=new Return<Object>();
		try
		{
			List<Animal> _animals=new ArrayList<Animal>();
			_animals.add(new  Animal("lion"));
			_animals.add(new Animal("sheep"));
			_animals.add(new  Animal("wolf"));
			_animals.add(new  Animal("wolf"));
			_animals.add(new  Animal("wolf"));
			
			List<Animal> _animalsFiltered = _animals.stream().filter(s->s.getName()=="wolf").collect(Collectors.toList());
			for (int i = 0; i < _animalsFiltered.size(); i++) 
	        {
	            Animal animal = _animalsFiltered.get(i);
	            System.out.println("name animal[" + i + "]=" + animal.getName());
	        }
			
			List<String> _animalsUppercase = _animals.stream().map(s->s.getName().toUpperCase()).collect(Collectors.toList());
			for (String _entity:_animalsUppercase)
			    System.out.println(_entity);
			
			List<String> _animalsUppercaseLowercase = _animals.stream()
														.map(s->Arrays.asList(s.getName().toLowerCase(),s.getName().toUpperCase()))
														.flatMap(l -> l.stream())
														.collect(Collectors.toList());
			for (String _entity:_animalsUppercaseLowercase)
			    System.out.println(_entity);

			for (int i = 0; i < _animalsUppercase.size(); i++)
			{
	            String _string = _animalsUppercase.get(i);
	            System.out.println("name animal[" + i + "]=" + _string);
			}
			
			Optional<Animal>_firstAnimal=_animals.stream().findFirst();
			if(_firstAnimal.isPresent())
				System.out.println("first animal: " + _firstAnimal.get().getName());
			
			if (_animals.stream().anyMatch(s->s.getName()=="wolf"))
				System.out.println("hay wolfs");
			
		}
		catch(Exception _ex)
		{
			_answer.setTheresError(true);
			_answer.setError(Utility.GetError(_ex));
		}
		
		return _answer;
	}
	
}


class Animal
{
	protected String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Animal()
	{
		this.setName(Utility.EMPTY_STRING);
	}
	
	public Animal(String name)
	{
		this();
		this.setName(name);
	}
}