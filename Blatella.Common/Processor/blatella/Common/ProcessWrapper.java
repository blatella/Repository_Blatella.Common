package blatella.Common;

class ProcessWrapper <T>
{
	boolean processed;
	boolean processing;
    T entity;
    
	ProcessWrapper(T entity)
    {
        this.entity=entity;
        this.processed=false;
        this.processing=false;
    }
}
