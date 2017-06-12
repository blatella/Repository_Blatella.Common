package blatella.Common;

public class IllegalNullArgumentException extends IllegalArgumentException 
{
	private static final long serialVersionUID = -3458516204096575719L;

	public IllegalNullArgumentException()
	 {
		 super();
	 }
	 
	 public IllegalNullArgumentException(String nameOfArgument)
	 {
		 super(String.format("\"%1$s\" must not be null",nameOfArgument));
	 }
	 
	 public IllegalNullArgumentException(String nameOfArgument, Throwable cause)
	 {
		 super(String.format("\"%1$s\" must not be null",nameOfArgument),cause);
	 }
	 
	 public IllegalNullArgumentException(Throwable cause)
	 {
		 super(cause);
	 }
}
