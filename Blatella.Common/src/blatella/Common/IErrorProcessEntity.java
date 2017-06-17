package blatella.Common;

public interface IErrorProcessEntity<T>
{
	void Process(T entity, Error error);
}
