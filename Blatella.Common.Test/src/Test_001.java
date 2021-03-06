import java.util.*;
import java.io.*;
import java.util.stream.*;
import blatella.Common.*;
import blatella.Common.Error;

public class Test_001 
{
	public static void main(String[] args) 
	{
		Return<Object>_answer=new Return<Object>();
		/*
		if(!_answer.theresError )
			_answer=TestTuples();
		
		if(!_answer.theresError )
			_answer=TestDictionary();
		
		if(!_answer.theresError )
			_answer=TestJoin();
		
		if(!_answer.theresError )
			_answer=TestSplit();
		
		if(!_answer.theresError )
			_answer=TestLINQ();
		*/
		if(!_answer.theresError )
			_answer=TestProcessor();
		
		
		if(_answer.theresError)
			ManageError(_answer.error);
		else
			System.out.println("finished test");
	}
	
	private static void ManageError(Error error)
	{
		ShowMessage(error.toString());
	}
	
	private static void ShowMessage(String message)
	{
		if(!Utility.IsNullOrWhiteSpace(message))
			System.out.println(message);
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
			_answer.theresError=true;
			_answer.error=Utility.GetError(_ex);
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
			_answer.theresError=true;
			_answer.error=Utility.GetError(_ex);
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
			_answer.theresError=true;
			_answer.error=Utility.GetError(_ex);
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
			_answer.theresError=true;
			_answer.error=Utility.GetError(_ex);
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
				System.out.println("there are wolfs");
			
		}
		catch(Exception _ex)
		{
			_answer.theresError=true;
			_answer.error=Utility.GetError(_ex);
		}
		
		return _answer;
	}
	
	private static Return<Object> TestProcessor()
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
			
			int _numberThreads=1, _pauseInMilliseconds=100;

			/*
			Processor<Animal>_processor=new Processor<Animal>(_numberThreads, _pauseInMilliseconds);
			_processor.AddListener_BeginProcessEntity((o)->TestIProcessObjectEvent(o));
			_processor.AddListener_EndProcessEntity((o)->TestIProcessObjectEvent(o));
			_processor.AddListener_ErrorProcessEntity((o,p)->TestIErrorProcessEntity(o,p));
			_processor.AddListener_MessageProcessEntity((o)->TestIProcessString(o));
			_processor.AddListener_Progress((o)->TestIProcessInteger(o));
			_processor.Process(_animals, e -> DoSomething(e));
			*/
			
			
			  try (Processor<Animal>_processor =new Processor<Animal>(_numberThreads, _pauseInMilliseconds))
			  {
				  _processor.AddListener_BeginProcessEntity((o)->TestIProcessObjectEvent(o));
				  _processor.AddListener_EndProcessEntity((o)->TestIProcessObjectEvent(o));
				  _processor.AddListener_ErrorProcessEntity((o,p)->TestIErrorProcessEntity(o,p));
				  _processor.AddListener_MessageProcessEntity((o)->TestIProcessString(o));
				  _processor.AddListener_Progress((o)->TestIProcessInteger(o));
				  _processor.Process(_animals, e -> DoSomething(e));
			  }
	
			for (Animal _a : _animals)
				System.out.println(_a.name );
			
			
			
		}
		catch(Exception _ex)
		{
			_answer.theresError=true;
			_answer.error=Utility.GetError(_ex);
		}
		
		return _answer;
	}

	public static Return<Object> DoSomething(Animal animal)
	{
		animal.name=String.format("%1$s_name", animal.name);
		Return<Object> _answer=new Return<Object>();
		return _answer;
	}
	
	private static void TestIProcessObjectEvent(Object parameter)
	{
		
	}
	
	private static void TestIErrorProcessEntity(Animal entity, Error error)
	{
		
	}
	
	private static void TestIProcessString(String parameter)
	{
		
	}
	
	private static void TestIProcessInteger(Integer parameter)
	{
		
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