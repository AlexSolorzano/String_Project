//package edu.uga.cs1302.muttxt;

/**
 * @author Alexandra Solorzano
 * This MyString class creates all the string methods found in java through the use
 * of well crafted algorithms, and array methods. 
 */
public class MyString extends MyStringIndexOutOfBoundsException{

/**
 * array that will be utilized for all of the methods
 */
private char[] charArray;
/**
 * default size of the array and MyString Object
 */
public final int DEFAULT_SIZE=5;

		/**
		 * Creates an Empty String
		 */
        public MyString()//Constructor creates an empty MyString object
        {

        	charArray= new char[DEFAULT_SIZE];
        }
       
        /**
         * @param ch places character in object
         */
        public MyString(char ch)//Constructor creates MyString with a character
        {
        	charArray= new char[DEFAULT_SIZE];
        	charArray[0]=ch;
        }
      
        //Personal Constructor
        public MyString(int newSize)

        {
        	charArray=new char[newSize];
        }
        
        /**
         * @return the MyString length
         */
        public int myLength()//Tells you the length of the MyString Object
        {
        	int counter=0;
        	for (int i=0; i<charArray.length;i++)
        	{
        		if(charArray[i]!=0)
        		{
        			counter++;
        		}
        	}
        	return counter;
        }
        
        /**
         * @param otherMyString is set to MyString
         */
        public MyString(MyString otherMyString)//Copies a MyString object to another
        {
        	if(otherMyString==null)
        	{
        		throw new IllegalArgumentException();
        	}
        	else
        	{
	        	charArray=new char[otherMyString.myLength()];//From one array to the other
	        	for (int i=0; i<otherMyString.myLength();i++)
	        	{
	        		charArray[i]=otherMyString.myCharAt(i);
	        	}
        	}
        }
        
        //PUT THIS INTO NIKE!!!!!!!!!
        /**
         * @param index , spot to search
         * @return a character
         */
        public char myCharAt(int index)//Gives you the char at that spot
        {
        	if((index>charArray.length)||(index<0))
        	{
        		throw new MyStringIndexOutOfBoundsException(index);
        	}
        	else
        	return charArray[index];
        }
       
        
       /**
        * @param MyString object
        * @return true
        * @return false
        */
        public boolean equals(Object o)//Checks equality of object
        {
        	boolean equals=false;
        	if (!(o instanceof MyString))
        		equals=false;
        	else if (o instanceof MyString)
        	{
        		MyString o2=(MyString)o;
	        	for (int i=0; i<this.myLength();i++)
				{
					if ( this.myCharAt(i)!= o2.myCharAt(i) )
					{
							equals=false;
							break;//goes directly to the return statement
					}
					else
						equals=true;
				}
        	}
			else if(o==null)
					equals=false;
			
        	//will only return true if conditions are met
        	return equals;
        }
       
        
        /**
         * @param otherMyString, used for comparison to another object
         * @return a empty string 
         * @return MyStringObject
         */ 
        public MyString myConcat(MyString otherMyString)
        {
        	if (otherMyString==null)
        	{
        		throw new IllegalArgumentException();
        	}
        	else if(otherMyString.myLength()==0)
        	{
        		return this;
        	}
        	else 
        	{
        		/*creates a new MyString object, then loops through 
        		both the array and otherMyString and copies it one at 
        		a time into the new object. */
        		int length=this.myLength()+otherMyString.myLength();
	        	MyString concat=new MyString(length);
	        	for(int i=0;i<this.myLength();i++)
	        	{
	        		concat.setAt(i,this.myCharAt(i));
	        	}
	    
	        	for(int counter=0,i=this.myLength();i<length;i++, counter++)
	        	{
	        		concat.setAt(i, otherMyString.myCharAt(counter));
	        	}
	        	return concat;
        	}
        	
        }
        
        /**
         * @param index, place in object 
         * @param ch, character to place
         * @exception MyStringIndexOutOfBoundsException index is not valid
         */
        public void setAt(int index, char ch) 
       
        {
        	//Lengthens the array by adding an extra character
        	if(index==charArray.length)
        	{
        		char[] tempArray= new char[index*2];//array is doubled
        		for(int i=0; i<charArray.length;i++)
        		{
        			tempArray[i]=charArray[i];
        		}
        		tempArray[index]=ch;
        		charArray=tempArray;
        	}
        	else if((index>charArray.length)||(index<0))
        	{
        		throw new MyStringIndexOutOfBoundsException(index);
        	}
        	else
        	{	
        		//simply just places the character at index
	        	charArray[index]=ch;
        	}
        }
       
        
        /**
         * Simply prints out the MyString Object contents
         */
        public void myLineDisplay()
        {
        	for(int i=0; i<charArray.length;i++)
        	{
  	
        		System.out.print(this.myCharAt(i));
        	}
        }
       
        /**
         * @param ch character to be found
         * @return index place where letter is
         * @return -1 if char isn't found
         */
        public int myIndexOf(char ch)
        {
        	//loops through trying to find a match 
        	int index=0;
        	boolean found=false;
        	for(int i=0;i<charArray.length;i++)
        	{
	        	if(ch==this.myCharAt(i))
	        	{
	        		found=true;
	        		index=i;
	        		break;
	        	}
	        	else if (found==false)
	        	{
	        		return -1;
	        	}
        	}
	        		return index;
        }
        
        /**
         * @param low beginning place of old MyString
         * @param high ending place of old MyString
         * @return substring new MyString Object
         * @return empty MyString object
         * @exception MyStringIndexOutOfBoundsException 
         * 			high and low values aren't valid
         * 
         */
        public MyString mySubString(int low, int high) 
        {
        	if(low<high)
        	{
        		//Places new String part inside of new MyString Object
	        	MyString substring=new MyString();
	        	int length=high-low;
	        	for (int i=0;i<length;i++)
	        	{
	        		substring.setAt(i, this.myCharAt(i+low));
	        	}
	        return substring;
        	}
        	else if(high<low)
        	{
        		throw new MyStringIndexOutOfBoundsException("High index= "
        		+high+" less than lowIndex= "+low);
        	}
        	else
        	{
        		return new MyString();
        	}
        }    

        /**       

         * @return myStringArray, array filled with the MyString characters
         */
        public char[] myToCharArray()//puts the MyString object contents into a array
        {
        	char [] newArray = charArray;
        	return newArray;
}
       
        public static void main(String[]args)
        {
         MyString test = new MyString('a');
         test.setAt(1, 'b');
         test.myLineDisplay();
        }
}

