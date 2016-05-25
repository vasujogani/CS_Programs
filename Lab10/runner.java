public class runner
{
	public static void main(String args[])
	{
		int a = 0;
		Donald d = new Donald();
		for(int i = 0; i < 10; i++)
		{
				try{
				Client c = new Client("10.99.84.32",9091);
				c.send("SETHANDLE DonalTrump");
				while(a<1000)
				{
					c.send("SAY " + d.talk);
					a++;
				}
			}catch(Exception e)
			{
				System.out.println("Error is : " + e.getMessage());
			}
				
		}
	}
}