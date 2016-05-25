import javax.swing.*;
import java.awt.event.*;

public class FancyButton extends JButton implements ActionListener	//FancyButton performs an action when a button is clicked
{
	private JTextArea area; //a pointer to a TextArea that this button can modify when clicked
	private JTextField chatarea;
    public FancyButton(String label, JTextArea a, JTextField b) 
   {
    	super(label);	//Give the label to the JButton constructor to deal with
    	
    	//make this button listen to itself when it is clicked
    	addActionListener(this);
    	
    	//initialize the area instance variable 
    	area = a;
    	chatarea = b;
    }
    
    //This is called when anything that *this* is listening to triggers an action.
    //	ie: when a button is clicked, anything that is "listening" to that button will have its actionPerformed method called
    //		or when a checkbox is checked, etc...
    public void actionPerformed(ActionEvent e)
    {
    	area.append("Client said:  " + chatarea.getText() + "\n");
    	chatarea.setText("");
    }
    
    
}