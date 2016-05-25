/**
 * @(#)ChatBox.java
 *
 * ChatBox application
 *
 * @author 
 * @period 
 * @lab
 * @version 1.00 2016/3/10
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ChatBox extends JFrame {
	public static void main(String args[]){
		ChatBox frame = new ChatBox();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);	
		if(frame.isVisible())
			System.out.println("Frame is visible");
	}
	
	public ChatBox(){  
		super();
		//Set the layout of this Frame
		setLayout(new BorderLayout());
		String ip = (String)JOptionPane.showInputDialog(null,"Enter the IP");
		int port = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the port"));
		
		try{
			Client client = new Client(ip, port);
			System.out.println("Made a client");
			changeName(client);
			
			JTextArea user = new JTextArea(0,10);
			this.add(new JScrollPane(user), BorderLayout.WEST);
		
			JPanel southpanel = new JPanel();
			southpanel.setLayout(new BoxLayout(southpanel, BoxLayout.X_AXIS));
			this.add(southpanel, BorderLayout.SOUTH);
			
			JTextArea area = new JTextArea();
			
			this.add(new JScrollPane(area), BorderLayout.CENTER);
		//	this.add(area, BorderLayout.CENTER);
		
			JTextField chat = new JTextField();
			final FancyButton send = new FancyButton("SEND", area,chat, client);
			southpanel.add(chat);
			southpanel.add(send);
		//Creating Network Listeners
			INetworkListener say = new SayCommand(area);
			INetworkListener list = new ListCommand(area,user);
			INetworkListener rename = new RenameCommand(area);
			INetworkListener set = new SetHandleCommand(area);
			INetworkListener dis= new DisconnectCommand(area);
			INetworkListener bad = new BadHandleCommand(area);
			INetworkListener add = new AddCommand(area);
			INetworkListener rem = new RemoveCommand(area);
			client.addNetworkListener(say);
			client.addNetworkListener(list);
			client.addNetworkListener(rename);
			client.addNetworkListener(set);
			client.addNetworkListener(dis);
			client.addNetworkListener(bad);
			client.addNetworkListener(add);
			client.addNetworkListener(rem);
		//	client.run();
			Thread t = new Thread(client);
			t.start();
			System.out.println("Ending the try!");
		}catch (Exception e){
				System.out.println("Error is : " + e.getMessage());
				e.printStackTrace();	
		} 
	
	}
	public void changeName(Client c)
	{
		String s = (String)JOptionPane.showInputDialog(null,"Enter your name");
			System.out.println("The person's name is : " + s);
		c.send("SETHANDLE " + s);
	}
	public void display()
	{
		
	}
}