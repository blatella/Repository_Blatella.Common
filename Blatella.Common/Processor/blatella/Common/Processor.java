package blatella.Common;

import java.util.*;

public class Processor<T> implements AutoCloseable 
{
	protected int numberThreads;
	public 	int getNumberThreads() {
		return numberThreads;
	}
	
	protected int pausesInMilliseconds;
	public int getPausesInMilliseconds() {
		return pausesInMilliseconds;
	}

	protected List<Object> Objects;

	protected int progress;
	
	public Return<Object> Process(List<T> entities, IReturnProcess<T> process)
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
                    for (T _entity:entities)
                    	_listProcessWrapper.add(new ProcessWrapper<T>(_entity));
                    
                    List<Thread> _listProcessors = new ArrayList<Thread>();

                    List<ProcessWrapper<T>> _listEntitiesProcessing = null;
                    List<ProcessWrapper<T>> _listEntitiesNoProcessed = null;
                    List<ProcessWrapper<T>> _listEntitiesProcessed = null;
                    int _numberOfEntitiesToProcess = entities.size();
                    this.progress = 0;
                    do
                    {
                    	/*
                        List<Thread> _listFinishedThreads = _listProcessors.Where(p => p.ThreadState == ThreadState.Stopped).ToList();
                        foreach (Thread _hilo in _listFinishedThreads)
                            _listProcessors.Remove(_hilo);
                        ProcessWrapper<T> _envoltorioEntidad = _listProcessWrapper.Where(e => !e.processing && !e.processed).FirstOrDefault();
                        if (_envoltorioEntidad != null)
                        {//hay que procesar una entidad más
                            if (_listProcessors.Count() < numberThreads)
                            {//hay un procesador libre, añadir la entidad
                                Thread _nuevoProceso = new Thread(() =>
                                {
                                    OnBeginProcessEntity(_envoltorioEntidad.entity);
                                    _envoltorioEntidad.processing = true;
                                    Return<Object> _respuestaProceso = process(_envoltorioEntidad.entity);
                                    if (_respuestaProceso.theresError)
                                        OnErrorProcessEntity(_envoltorioEntidad.entity, _respuestaProceso.error);
                                    else
                                        if (!string.IsNullOrEmpty(_respuestaProceso.message))
                                            OnMessageProcessEntity(_respuestaProceso.message);

                                    _envoltorioEntidad.processed = true;
                                    _envoltorioEntidad.processing = false;
                                    OnEndProcessEntity(_envoltorioEntidad.entity);
                                });
                                _nuevoProceso.CurrentCulture = System.Threading.Thread.CurrentThread.CurrentCulture;
                                _nuevoProceso.CurrentUICulture = System.Threading.Thread.CurrentThread.CurrentUICulture;
                                _listProcessors.Add(_nuevoProceso);
                                _nuevoProceso.Start();
                            }//hay un procesador libre, añadir la entidad
                        }//hay que procesar una entidad más
                        Thread.Sleep(pausesInMilliseconds);
                        _listEntitiesProcessing = _listProcessWrapper.Where(e => e.processing).ToList();
                        _listEntitiesNoProcessed = _listProcessWrapper.Where(e => !e.processed).ToList();
                        _listEntitiesProcessed = _listProcessWrapper.Where(e => e.processed).ToList();
                        OnProgress(_numberOfEntitiesToProcess, _listEntitiesProcessed.Count);
                        */
                    }
                    while (_listEntitiesNoProcessed.size() >= 1 || _listEntitiesProcessing. .Any());
                }
                catch (Exception _ex)
                {
                    _answer.theresError = true;
                    _answer.error = Utility.GetError(_ex, this.GetType());
                }
            }
        return _answer;
    }
	
	
	@Override
	public void close() 
	{
		if (this.Objects != null)
          for (Object _object : this.Objects)
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
