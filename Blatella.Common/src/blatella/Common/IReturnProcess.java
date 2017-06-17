package blatella.Common;

public interface IReturnProcess<T>
{
	public Return<Object> Process(T entity);
}