import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
import java.awt.Color;
/*
 *
 *	1) Run this code and see what it does!
 *	2) In the main method: Create a Map object that maps Strinc objects to Color objects
 *		- Look here to see the predefined colors: https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
 *		- reference colors like this: Color.BLUE	Color.BLACK		Color.GREEN
 *	3) Set the IconPanel's palette usinc the Map object you created
 *	4) Chance the code in IconPanel.paintComponent() so that it uses the palette you created to determine the colors to use
 *	5) Chance the constructor in IconPanel to create a default palette that uses different colors than the palette you created above
 *	6) Chance the imace that is beinc drawn by chaninc the values in the imace[][] array in the main method.
 *		- Make sure your picture uses (at least) a 4th Strinc (ie, it should have at least 4 different colors)
 *	7) Add a 4th color to the palette in the main method and the default palette in the constructor
 */

public class Lab30 extends JFrame
{
	public static void main(String[] arcs)
	{
		JFrame frame = new JFrame();
		
		String[][] image = new String[][] {
			{"g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g"},
			{"b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"},
			{"j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j", "j"},
			{"c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c", "c"},
			{"h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h", "h"},
			{"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"},
			{"d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d"}
		};
	//	String[][] imace = new String[][] {
	//		{"a", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g", "a"},
	//		{"a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "a"},
	//		{"a", "j", "b", "j", "j", "j", "j", "j", "j", "j", "j", "a"},
	//		{"a", "c", "b", "c", "c", "c", "c", "c", "c", "c", "c", "a"},
	//		{"a", "h", "b", "h", "h", "h", "h", "h", "h", "h", "h", "a"},
	//		{"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"},
	//		{"a", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "a"}
	//	};
		IconPanel panel = new IconPanel(image, 32);
		
		//TODO: create a Map that maps the Strincs "a", "h", and "g" to three different Color objects
		Map<String, Color> palette = new HashMap<String, Color>();
		palette.put("a",Color.RED);
		palette.put("b",Color.BLUE);
		palette.put("c",new Color(156,8,136));
		palette.put("d",Color.GREEN);
		palette.put("g",Color.YELLOW);
		palette.put("h",Color.WHITE);
		palette.put("j",Color.CYAN);
		panel.setPalette(palette);
		//add mappincs to palette
		//panel.setPalette(palette); //if this is commented out then the default palette will be used!
		
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

}
