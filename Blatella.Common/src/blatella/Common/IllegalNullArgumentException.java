package blatella.Common;

public class IllegalNullArgumentException extends IllegalArgumentException 
{
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
