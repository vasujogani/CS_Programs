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



public class ChatBox extends JFrame{
	public static void main(String args[]){
		ChatBox frame = new ChatBox();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);	
		if(frame.isVisible())
			System.out.println("Frame is visible");
	}
	
	public ChatBox(){  
		changeName();
		//Set the layout of this Frame
		setLayout(new BorderLayout());
		
		JPanel sidepanel = new JPanel();
		sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
		this.add(sidepanel, BorderLayout.WEST);
	
		
		JPanel southpanel = new JPanel();
		southpanel.setLayout(new BoxLayout(southpanel, BoxLayout.X_AXIS));
		this.add(southpanel, BorderLayout.SOUTH);
		
		JTextArea area = new JTextArea();
		this.add(new JScrollPane(area), BorderLayout.CENTER);
		this.add(area, BorderLayout.CENTER);
	
		JTextField chat = new JTextField(8);
		final FancyButton send = new FancyButton("SEND", area,chat);
/*		chat.addActionListener(new ActionListener(){
			public void actionPerfomed(ActionEvent e)
			{
				send.actionPerformed(e);
			}
		});
*/		
		

		southpanel.add(chat);
		southpanel.add(send);
	}
	public void changeName()
	{
		String s = (String)JOptionPane.showInputDialog(null,"Enter your name");
			System.out.println("The person's name is : " + s);
	}
	public void display()
	{
		
	}
}