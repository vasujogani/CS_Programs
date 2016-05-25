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
		
		//Set the layout of this Frame
//		setLayout(new BorderLayout());
		System.out.println("In The Construture");
//		
//		JPanel sidepanel = new JPanel();
//		sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
//		this.add(sidepanel, BorderLayout.WEST);
	
		setLayout(new BorderLayout());
		
		//Create a Panel that has its own layout and can have components added to it
		JPanel sidepanel = new JPanel();
		
		//Set the layout of the sidepanel JPanel
		sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
		
		//Add the sidepanel to this Frame (on the left side)
		this.add(sidepanel, BorderLayout.WEST);
	
		JButton b2 = new JButton("This is another button");
		sidepanel.add(b2);
		
		//Moar buttonzzzzzz
		JButton b3 = new JButton("Tad Cooper is a dragon");
		sidepanel.add(b3);
		
	//	JPanel southpanel = new JPanel();
	//	southpanel.setLayout(new BoxLayout(southpanel, BoxLayout.X_AXIS));
	//	this.add(southpanel, BorderLayout.SOUTH);
	//	
	//	JTextArea area = new JTextArea();
	//	this.add(new JScrollPane(area), BorderLayout.CENTER);
	//	this.add(area, BorderLayout.CENTER);
	//	
	//	JTextArea chat = new JTextArea();
	//	this.add(new JScrollPane(area), BorderLayout.CENTER);
	//	this.add(chat, BorderLayout.SOUTH);
	//	
	//	JButton send = new JButton("SEND");
	//	this.add(send, BorderLayout.SOUTH);
	//	
	//	southpanel.add(chat);
	//	southpanel.add(send);
	//	JPanel bottom = new JPanel();
	//	bottom.add(chat);
	//	bottom.add(send);	
		
	//	this.add(bottom, BorderLayout.SOUTH);	
		
	}
}