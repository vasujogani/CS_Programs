import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;


public class runner
{
	public static void main(String args[]) throws IOException
	{
		//read from file
		List<Integer> intList = new ArrayList<Integer>();
		String fr = "";
		File file = new File("data.txt");
		Scanner s = new Scanner(file);
		if(!file.exists()) 
			System.out.println("Your file has been Hacked");
		int count=0;
		int numberOfLines = 0;
		while(s.hasNextLine())
		{
			if(count==0){ numberOfLines = Integer.parseInt(s.next()); count++;s.nextLine();continue;}
			System.out.println("count is : " + count + " NumberOfLines is : " +numberOfLines);
			if(count==numberOfLines)break;
			while(s.hasNextInt())
				intList.add(s.nextInt());
			System.out.println(intList);
			count++;
			
			formulateAnswer("1541",1);
		}		
	}
	public static boolean checkRepeat(String o, String n)
	{
		//check the old is alternating by itself
		String ob = Integer.toBinaryString(Integer.parseInt(o));
		String nb = Integer.toBinaryString(Integer.parseInt(n));
		boolean c;
		if(ob.substring(0,1).equals("1"))
			c = true;
		else c = false;
		boolean works = true;
		for(int i = 0; i<ob.length(); i++)
		{
			if(c==true&&ob.substring(i,i+1).equals("1"))
				c = false;
			else if(c==false&&ob.substring(i,i+1).equals("1"))
				c = true;
			else works = false;
		}
		if(nb.substring(0,1).equals("1"))
			c = true;
		else c = false;
		boolean work1 = true;
		for(int i = 0; i<nb.length(); i++)
		{
			if(c==true&&nb.substring(i,i+1).equals("1"))
				c = false;
			else if(c==false&&nb.substring(i,i+1).equals("1"))
				c = true;
			else work1 = false;
		}
		int num = Integer.parseInt(o+n);
		int numb = Integer.toBinaryString(Integer.parseInt(num));
		//odd check
		boolean firstis;
		if(numb.substring(0,1).equals("1"))
				firstis = true;
		else{
			firstis = false;
		}
		for(int i = 0; i < numb.length(); i+=2)
		{
			if(firstis == true && !numb.substring(i,i+1).equals("1"))
				
		}
		return false;
	}
	public static void formulateAnswer(String in, int breakpoints)
	{
		List<String> entered = new ArrayList<String>();
		for(int i = 0; i < in.length(); i++)
		{
			entered.add(in.substring(i,i+1));
		}
		String old;
		//List<String> answer = new ArrayList<String>();
		String[] answer = new String[breakpoints];
		int count = 0;
		answer[0] = entered.get(0);
		old = entered.get(0);
		for(int i = 1; i < entered.size(); i++)
		{
			String newb = entered.get(i);
			if(checkRepeat(old,newb))
			{
				old += newb;
			}
			else{
				answer[count] = old;
				old = newb;
				count++;
			}
		}
	}
}