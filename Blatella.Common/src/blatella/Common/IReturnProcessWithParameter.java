package blatella.Common;

public interface IReturnProcessWithParameter<T>
{
	public Return<Object> Process(T entity, Object parameter);
}
