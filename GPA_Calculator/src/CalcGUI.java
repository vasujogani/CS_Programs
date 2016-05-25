import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.*;

public class CalcGUI extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcGUI frame = new CalcGUI();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600,800);
		frame.setResizable(false);
		frame.setVisible(true);	
		if(frame.isVisible())
			System.out.println("Frame is visible");
	}
	public CalcGUI(){
		super();
		//Set the layout of this Frame
		setLayout(new BorderLayout());
		
		JTextField first = new JTextField();
		first.setPreferredSize(new Dimension(100,30));
		JTextField second = new JTextField();
		second.setPreferredSize(new Dimension(100,30));
		JTextField third = new JTextField();
		third.setPreferredSize(new Dimension(100,30));
		JTextField fourth = new JTextField();
		fourth.setPreferredSize(new Dimension(100,30));
		JTextField fifth = new JTextField();
		fifth.setPreferredSize(new Dimension(100,30));
		JTextField sixth= new JTextField();
		sixth.setPreferredSize(new Dimension(100,30));
		JTextField seventh = new JTextField();
		seventh.setPreferredSize(new Dimension(100,30));
		JTextField eight = new JTextField();
		eight.setPreferredSize(new Dimension(100,30));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.add(panel, BorderLayout.CENTER);
		panel.add(first);
		panel.add(second);
		panel.add(third);
		panel.add(fourth);
		panel.add(fifth);
		panel.add(sixth);
		panel.add(seventh);
		panel.add(eight);
		Calculate calc = new Calculate("CALCULATE!");
	
		this.add(calc, BorderLayout.SOUTH);
	//	this.add(extra, BorderLayout.SOUTH);	
	}

}
