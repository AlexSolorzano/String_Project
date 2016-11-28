import java.lang.IndexOutOfBoundsException;
/**
 * @author Alexandra Solorzano
 *Creates the exceptions specified to the MyString Class
 *extends IndexOutOfBoundsException
 */
public class MyStringIndexOutOfBoundsException extends IndexOutOfBoundsException{

/**
* Constructor that extends from IndexOutOfBoundsException class
*/
public MyStringIndexOutOfBoundsException()
{
super();
}

/**
* Constructor that extends from IndexOutOfBoundsException class
* @param String
* prints out custom error message
*/
public MyStringIndexOutOfBoundsException(String errMsg)
{
super(errMsg);
}
	
/**
* Constructor that extends from IndexOutOfBoundsException class
* @param index number that is out of range
* Prints out error message with the index 
*/
public MyStringIndexOutOfBoundsException(int index)
{
super("MyString index out of range: "+index);
}
}
