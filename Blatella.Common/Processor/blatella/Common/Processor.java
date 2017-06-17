package blatella.Common;

import java.lang.Thread.State;
import java.util.*;
import java.util.stream.Collectors;

public class Processor<T> implements AutoCloseable 
{
	protected int numberThreads;
	public 	int getNumberThreads() {
		return numberThreads;
	}
	
	protected int pauseInMilliseconds;
	public int getPauseInMilliseconds() {
		return pauseInMilliseconds;
	}

	protected List<Object> objectsToParameters;

	protected int progress;
	
	public Processor(int numberThreads, int pauseInMilliseconds)
    {
		if(numberThreads<1)
			throw new IllegalNullArgumentException("numberThreads");
		else
			if(pauseInMilliseconds<0)
				throw new IllegalNullArgumentException("pauseInMilliseconds");
			else
			{
				this.numberThreads = numberThreads;
		        this.pauseInMilliseconds = pauseInMilliseconds;
		        this.objectsToParameters=new ArrayList<Object>();
		        this.progress=0;
		        
		        this.listenersBeginProcessEntity = new ArrayList<IProcessObject>();
		        this.listenersErrorProcessEntity = new ArrayList<IErrorProcessEntity<T>>();
		        this.listenersMessageProcessEntity = new ArrayList<IProcessString>();
		        this.listenersEndProcessEntity = new ArrayList<IProcessObject>();
		        this.listenersProgress = new ArrayList<IProcessInteger>();
			}
    }
	
	public Processor(int numberThreads, int pauseInMilliseconds, List<Object> objectsToParameters)
    {
		this(numberThreads,pauseInMilliseconds);
		
		if (objectsToParameters == null)
            throw new IllegalNullArgumentException("objectsToParameters");
		else
        {
            for (Object _object : objectsToParameters)
                if (_object == null)
                    throw new IllegalNullArgumentException("objectsToParameters");
            this.objectsToParameters = objectsToParameters;
        }
    }
	
	
	
	
	
	
	public Return<Object> Process(List<T> entities,IReturnProcess<T>process)
    {
        Return<Object> _answer = new Return<Object>();
        if (entities == null)
        {
            _answer.theresError=true;
            _answer.error=Utility.GetError(new IllegalNullArgumentException("entities"));
        }
        else
        	if (process == null)
            {
                _answer.theresError=true;
                _answer.error=Utility.GetError(new IllegalNullArgumentException("process"));
            }
            else
            {
                try
                {
                    List<ProcessWrapper<T>> _listProcessWrapper = new ArrayList<ProcessWrapper<T>>();
                    for (T _e:entities)_listProcessWrapper.add(new ProcessWrapper<T>(_e));
                    List<Thread> _listProcessors = new ArrayList<Thread>();

                    List<ProcessWrapper<T>> _listEntitiesProcessing = null;
                    List<ProcessWrapper<T>> _listEntitiesNoProcessed = null;
                    List<ProcessWrapper<T>> _listEntitiesProcessed = null;
                    int _numberOfEntitiesToProcess = entities.size();
                    this.progress = 0;
                    do
                    {
                    	List<Thread> _listFinishedThreads = _listProcessors.stream().filter(p -> p.getState() == State.TERMINATED).collect(Collectors.toList());
                    	for (Thread _thread : _listFinishedThreads)
                            _listProcessors.remove(_thread);

                    	Optional<ProcessWrapper<T>>_optionalEntityWrapper = _listProcessWrapper.stream().filter(e -> !e.processing && !e.processed).findFirst();
                        if (_optionalEntityWrapper. isPresent())
                        {//we need to process one more entity
                        	ProcessWrapper<T> _entityWrapper=  _optionalEntityWrapper.get();
                        	if (_listProcessors.size() < numberThreads)
                            {//there's a free processor, add entity
                        		Thread _newThread = new Thread(() ->
                        		{
                        			OnBeginProcessEntity(_entityWrapper.entity);
                        			_entityWrapper.processing = true;
                        			Return<Object> _answerProcess =process.Process(_entityWrapper.entity);
                        			if (_answerProcess.theresError)
                                        OnErrorProcessEntity(_entityWrapper.entity, _answerProcess.error);
                                    else
                                        if (!Utility.IsNullOrEmpty(_answerProcess.message))
                                            OnMessageProcessEntity(_answerProcess.message);
                        			
                        			_entityWrapper.processed = true;
                        			_entityWrapper.processing = false;
                                    OnEndProcessEntity(_entityWrapper.entity);
                        		});
                            	_listProcessors.add(_newThread);
                            	_newThread.start(); 
                            }//there's a free processor, add entity
                        }//we need to process one more entity
                        
                        Thread.sleep(pauseInMilliseconds);
                        _listEntitiesProcessing = _listProcessWrapper.stream().filter(e -> e.processing).collect(Collectors.toList());
                        _listEntitiesNoProcessed = _listProcessWrapper.stream().filter(e -> !e.processed).collect(Collectors.toList());
                        _listEntitiesProcessed = _listProcessWrapper.stream().filter(e -> e.processed).collect(Collectors.toList());
                        OnProgress(_numberOfEntitiesToProcess, _listEntitiesProcessed.size());
                    }
                    while (_listEntitiesNoProcessed.size() >= 1 || _listEntitiesProcessing.stream().anyMatch(e->true));
                }
                catch (Exception _ex)
                {
                    _answer.theresError=true;
        			_answer.error=Utility.GetError(_ex);
                }
            }
        return _answer;
    }
	
	
	public Return<Object> Process(List<T> entities, IReturnProcessWithParameter<T> process)
    {
        Return<Object> _answer = new Return<Object>();
        if (entities == null)
        {
            _answer.theresError=true;
            _answer.error=Utility.GetError(new IllegalNullArgumentException("entities"));
        }
        else
        	if (process == null)
            {
                _answer.theresError=true;
                _answer.error=Utility.GetError(new IllegalNullArgumentException("process"));
            }
            else
                if (objectsToParameters == null || objectsToParameters.size() < numberThreads)
                {
                    _answer.theresError = true;
                    String _message =String.format("The number of elements in the list \"%1$d\" can't be less than the number of threads \"%2$s\"."
                                                        , objectsToParameters.size(), numberThreads);
                    _answer.error=Utility.GetError(new Exception(_message));
                }
                else
                {
                	try
                    {
                		List<ProcessWrapper<Object>> _objectsList = new ArrayList<ProcessWrapper<Object>>();
                		for(Object _o : this.objectsToParameters)
                			_objectsList.add(new ProcessWrapper<Object>(_o));

                		List<ProcessWrapper<T>> _listProcessWrapper = new ArrayList<ProcessWrapper<T>>();
                        for (T _e:entities)_listProcessWrapper.add(new ProcessWrapper<T>(_e));
                        List<Thread> _listProcessors = new ArrayList<Thread>();

                        List<ProcessWrapper<T>> _listEntitiesProcessing = null;
                        List<ProcessWrapper<T>> _listEntitiesNoProcessed = null;
                        List<ProcessWrapper<T>> _listEntitiesProcessed = null;
                        int _numberOfEntitiesToProcess = entities.size();
                        this.progress = 0;
                        do
                        {
                        	List<Thread> _listFinishedThreads = _listProcessors.stream().filter(p -> p.getState() == State.TERMINATED).collect(Collectors.toList());
                        	for (Thread _thread : _listFinishedThreads)
                                _listProcessors.remove(_thread);

                        	Optional<ProcessWrapper<T>>_optionalEntityWrapper = _listProcessWrapper.stream().filter(e -> !e.processing && !e.processed).findFirst();
                        	Optional<ProcessWrapper<Object>>_optionalObjectWrapper = _objectsList.stream().filter(e -> !e.processing).findFirst();
                        	
                            
                        	if (_optionalEntityWrapper. isPresent()&&_optionalObjectWrapper. isPresent())
                            {//we need to process one more entity
                        		ProcessWrapper<T> _entityWrapper=  _optionalEntityWrapper.get();
                        		ProcessWrapper<Object> _objectWrapper=  _optionalObjectWrapper.get();
                        		
                        		if (_listProcessors.size() < numberThreads)
                                {//there's a free processor, add entity
                        			Thread _newThread = new Thread(() ->
                            		{
                            			OnBeginProcessEntity(_entityWrapper.entity);
                            			
                            			_entityWrapper.processing = true;
                            			_objectWrapper.processing = true;
                            			
                            			Return<Object> _answerProcess =process.Process(_entityWrapper.entity,_objectWrapper.entity);
                            			if (_answerProcess.theresError)
                                            OnErrorProcessEntity(_entityWrapper.entity, _answerProcess.error);
                                        else
                                            if (!Utility.IsNullOrEmpty(_answerProcess.message))
                                                OnMessageProcessEntity(_answerProcess.message);
                            			
                            			_objectWrapper.processing = false;
                            			_entityWrapper.processed = true;
                            			_entityWrapper.processing = false;
                                        OnEndProcessEntity(_entityWrapper.entity);
                            		});
                        			_listProcessors.add(_newThread);
                                    _newThread.start();
                                }//there's a free processor, add entity
                            }//we need to process one more entity
                        	Thread.sleep(pauseInMilliseconds);
                            _listEntitiesProcessing = _listProcessWrapper.stream().filter(e -> e.processing).collect(Collectors.toList());
                            _listEntitiesNoProcessed = _listProcessWrapper.stream().filter(e -> !e.processed).collect(Collectors.toList());
                            _listEntitiesProcessed = _listProcessWrapper.stream().filter(e -> e.processed).collect(Collectors.toList());
                            OnProgress(_numberOfEntitiesToProcess, _listEntitiesProcessed.size());                        }
                        while (_listEntitiesNoProcessed.size() >= 1 || _listEntitiesProcessing.stream().anyMatch(e->true));
                    }
                    catch (Exception _ex)
                    {
                        _answer.theresError=true;
            			_answer.error=Utility.GetError(_ex);
                    }
                }
        return _answer;
    }
	
	
	
	
	
	
	protected List<IProcessObject> listenersBeginProcessEntity;
	public void AddListener_BeginProcessEntity(IProcessObject listener) 
	{
		listenersBeginProcessEntity.add(listener);
    }
	protected void OnBeginProcessEntity(T entity)
    {
		for (IProcessObject _listener : listenersBeginProcessEntity)
			_listener.Process(entity);
    }
	
	protected List<IErrorProcessEntity<T>> listenersErrorProcessEntity;
	public void AddListener_ErrorProcessEntity(IErrorProcessEntity<T> listener) 
	{
		listenersErrorProcessEntity.add(listener);
    }
	protected void OnErrorProcessEntity(T entity, Error error)
    {
		for (IErrorProcessEntity<T> _listener : listenersErrorProcessEntity)
			_listener.Process(entity,error);
    }
	
	
	protected List<IProcessString> listenersMessageProcessEntity;
	public void AddListener_MessageProcessEntity(IProcessString listener) 
	{
		listenersMessageProcessEntity.add(listener);
    }
	protected void OnMessageProcessEntity(String message)
    {
		for (IProcessString _listener : listenersMessageProcessEntity)
			_listener.Process(message);
    }
	
	
	protected List<IProcessObject> listenersEndProcessEntity;
	public void AddListener_EndProcessEntity(IProcessObject listener) 
	{
		listenersEndProcessEntity.add(listener);
    }
	protected void OnEndProcessEntity(T entity)
    {
		for (IProcessObject _listener : listenersEndProcessEntity)
			_listener.Process(entity);
    }
	
	protected List<IProcessInteger> listenersProgress;
	public void AddListener_Progress(IProcessInteger listener) 
	{
		listenersProgress.add(listener);
    }
	protected void OnProgress(int reachedPercentage)
    {
		for (IProcessInteger _listener : listenersProgress)
			_listener.Process(reachedPercentage);
    }
	protected void OnProgress(int numberOfEntitiesToProcess, int numberOfEntitiesProcessed)
    {
		int _progress = numberOfEntitiesProcessed == 0 ? 0 : (int)(numberOfEntitiesProcessed * 100 / numberOfEntitiesToProcess);
        _progress = _progress > 100 ? 100 : _progress;

        if (_progress != this.progress)
        {
            for (IProcessInteger _listener : listenersProgress)
    			_listener.Process(this.progress);
        }
    }
	
	
	@Override
	public void close() 
	{
		if (this.objectsToParameters != null)
          for (Object _object : this.objectsToParameters)
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
