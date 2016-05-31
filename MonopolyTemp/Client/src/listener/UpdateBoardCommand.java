package listener;

import java.util.*;
import java.awt.Point;

import javax.swing.JFrame;

import mainClient.IClient;
public class UpdateBoardCommand extends ClientListenerAdapter
{
	public static String COMMAND = "UPDATEBOARD";
	private JFrame frame;

	HashMap<String, Point> listofPlayersOnline;

	public UpdateBoardCommand(HashMap<String, Point> s,JFrame f){
		listofPlayersOnline = s;
		frame = f;
	}
	
	
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			System.out.println("In the updateboard command");
			frame.repaint();
			frame.validate();
		}
	}
}