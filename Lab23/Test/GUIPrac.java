import javax.swing.*;
import java.awt.*;

public class GUIPrac extends JFrame
{
	//This method is called when you run your program
	public static void main(String[] args)
	{
		//Create a Frame to hold everything
		GUIPrac frame = new GUIPrac();
		
		//Clicking the [X] button stops your program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//how big should hte JFrame be?
		frame.setSize(800, 600);
		
		//Do you want to be able to see the Frame?
		frame.setVisible(true);
		
	}
	
	//Constructor is called when a new GuiPractice object is created.
	public GUIPrac()
	{
		//Set the layout of this Frame
		setLayout(new BorderLayout());
		
		//Create a Panel that has its own layout and can have components added to it
		JPanel sidepanel = new JPanel();
		
		//Set the layout of the sidepanel JPanel
		sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
		
		//Add the sidepanel to this Frame (on the left side)
		this.add(sidepanel, BorderLayout.WEST);
		
		//Create an editable TextArea and add it to the center of this frame
		JTextArea area = new JTextArea();
		this.add(new JScrollPane(area), BorderLayout.CENTER);
		
		//Create a button and add it to the sidepanel
		JButton b = new FancyButton("This is a fancy button", area);
		sidepanel.add(b);
		
		//Create another button!
		JButton b2 = new JButton("This is another button");
		sidepanel.add(b2);
		
		//Moar buttonzzzzzz
		JButton b3 = new JButton("Tad Cooper is a dragon");
		sidepanel.add(b3);

	}
}