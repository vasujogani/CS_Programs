/**
 * @(#)FizzBuzz.java
 *
 *
 * @author 
 * @version 1.00 2015/8/26
 */
 

public class FizzBuzz {

    public static void main(String args[]){
    
    		for(int x = 1; x <= 100; x++)
    		{
    			if(x%3==0 && x%5==0)
    				System.out.println("FizzBuzz");
    			else if(x%5==0)
    				System.out.println("Buzz");
    			else if(x%3==0)
    				System.out.println("Fizz");
    			else 
    				System.out.println(x);
    		}
    	
    }
    
    
}