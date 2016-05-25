import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RenameCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "RENAME";

	JTextArea area;
	public RenameCommand(JTextArea a)
	{
		area = a;		
	}
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			//process the Rename command
			//RENAME # oldHandle# newHandle
			//Example: 
			//		RENAME 9 Ned Stark17 Headless Horseman
			//
			//This should rename the user "Ned Stark" to "Headless Horseman"
			
			message = message.substring(7);
			System.out.println("1) meesage is :" + message);
			int size = Integer.parseInt(message.substring(0,message.indexOf(" ")));
			message = message.substring(message.indexOf(" ")+1);
			String before = message.substring(0,size+1);
			message = message.substring(0,size+1);
			size = Integer.parseInt(message.substring(0,message.indexOf(" ")));
			message = message.substring(message.indexOf(" ")+1);
			String after = message;
			System.out.println("Renaming: " + before + " to "+ after);
			String fin = before + " changed his name to "+after;
			area.append(fin+ " \n");
		}
	}
}