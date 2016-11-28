import static org.junit.Assert.*;
import org.junit.Test;

public class MyStringTester {
/**
 *Creates MyString object
 *@result a String object
 *@exception IllegalArgumentException
 */
	//Testing MyString
	@Test
	public void testMyString()
	{
		MyString test = new MyString();
		boolean result=false;	
		if(test instanceof MyString)
			result=true;
		assertEquals(true,result);
	}
	@Test
	public void testMyString2()
	{
		MyString test= new MyString('a');
		boolean result=false;
		if((test instanceof MyString)&&(test.myLength()==1))
			result=true;
		assertEquals(true,result);
	}
	@Test(expected=IllegalArgumentException.class)	
	public void testMyString3()
	{
		MyString test= new MyString(null);
		MyString result= new MyString(test);
	}
	
	//Testing out myLength
	@Test
	public void testMyLength()
	{
		MyString test = new MyString('a');
		int result= test.myLength();
		assertEquals(1,result);
	}
	
	//Testing myToCharArray
	@Test
	public void testMyToCharArray()
	{
		MyString test = new MyString();
		char[] result = test.myToCharArray();
		char[] array = new char[5];
		boolean result2=true;
		for(int i=0; i<result.length; i++)
		{
			if(result[i]!=array[i])
				result2 = false;
		}
		assertEquals(true, result2);
	}
	@Test
	public void testMyToCharArray2()
	{
		MyString test = new MyString();
		char []test2=test.myToCharArray();
		Boolean result=false;
		if (test2 instanceof char[])
		{
			result=true;
		}
		assertEquals(true,result);
	}
	
	//TestingSetAt
	@Test
	public void test1SetAt()
	{
		MyString test = new MyString();
		test.setAt(0,'a');
		MyString result = new MyString();
		result.setAt(0,'a');
		assertEquals(test,result);
	}
	@Test
	public void test2SetAt()
	{
		MyString test = new MyString();
		test.setAt(2,'b');
		MyString result = new MyString();
		result.setAt(2,'b');
		assertEquals(test,result);
	}
	@Test
	public void test3SetAt()
	{
		MyString test = new MyString();
		test.setAt(4,'c');
		MyString result = new MyString();
		result.setAt(4,'c');
		assertEquals(test,result);
	}
	@Test(expected=MyStringIndexOutOfBoundsException.class)
	public void test4SetAt()
	{
		MyString test=new MyString();
		test.setAt(6,'a');
	}
	
	//Testing Equals
	@Test 
	public void test1Equals()
	{
		MyString test= new MyString();
		boolean result=test.equals('5');
		assertEquals(false,result);
	}
	@Test
	public void test2Equals()
	{
		MyString test = new MyString('a');
		MyString otherMyString = new MyString('b');
		boolean result=test.equals(otherMyString);
		assertEquals(false,result);
	}
	@Test
	public void test3Equals()
	{
		MyString test = new MyString('a');
		MyString otherMyString =new MyString('a');
		boolean result=test.equals(otherMyString);
		assertEquals(true,result);
	}
	@Test
	public void test4Equals()
	{	
		Integer test= new Integer(1);
		Integer test2= new Integer(1);
		boolean result=test.equals(test2);
		assertEquals(true,result);
		
	}
	@Test
	public void test5Equals()
	{
		MyString test= new MyString();
		boolean result=test.equals(null);
		assertEquals(false, result);
	}
	@Test
	public void test6Equals()
	{
		MyString test= new MyString();
		Integer number= new Integer(1);
		boolean result=test.equals(number);
		assertEquals(false,result);
	}	
	
	//Testing MyCharAt
	@Test
	public void testMyCharAt()
	{
		MyString test = new MyString('a');
		char result=test.myCharAt(0);
		assertEquals('a',result);
	}
	@Test(expected=MyStringIndexOutOfBoundsException.class)
	public void testMyCharAt2()
	{
		MyString test = new MyString();
		char result=test.myCharAt(6);
	}
	@Test(expected=MyStringIndexOutOfBoundsException.class)
	public void testMyCharAt3()
	{
		MyString test = new MyString();
		char result=test.myCharAt(-1);
	}
	
	//Testing MySubString
	@Test
	public void testMySubString()
	{
		MyString test = new MyString('a');
		test.setAt(1, 'b');
		test.setAt(2, 'c');
		test.setAt(3, 'd');
		MyString result = test.mySubString(1, 3);
		MyString result2 = new MyString('b');
		result2.setAt(1,'c');
		assertEquals(result2, result);
	}
	@Test(expected=MyStringIndexOutOfBoundsException.class)
	public void testMySubString2()
	{
		MyString test= new MyString('a');
		test.setAt(1, 'b');
		test.setAt(2, 'c');
		test.setAt(3, 'd');
		
		MyString result=test.mySubString(10,5);
	}
	
	//Testing MyConcat
	@Test
	public void testMyConcat()
	{
		MyString test = new MyString('a');
		MyString test2 = new MyString('b');
		MyString result= test.myConcat(test2);
		MyString result2= new MyString(2);
		result2.setAt(0, 'a');
		result2.setAt(1, 'b');
		assertEquals(result2, result);	
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testMyConcat2()
	{
		MyString test = new MyString(null);
		MyString test2 = new MyString();
		MyString result=test2.myConcat(test);
	}
		
	
}
