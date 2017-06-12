package blatella.Common;

class ProcessWrapper <T>
{
	protected boolean processed;
	boolean getProcessed() 
	{
		return processed;
	}
	void setProcessed(boolean processed) 
	{
		this.processed = processed;
	}
	
	protected boolean processing;
    boolean getProcessing() 
    {
		return processing;
	}
	void setProcessing(boolean processing) 
	{
		this.processing = processing;
	}
	
	protected T entity;
    T getEntity() 
    {
		return entity;
	}
	void setEntity(T entity) 
	{
		this.entity = entity;
	}
	
	public ProcessWrapper(T entity)
    {
        this.setEntity(entity);
        this.setProcessed(false);
        this.setProcessing(false);
    }
}
