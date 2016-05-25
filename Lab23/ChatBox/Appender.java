import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Appender
{
	JTextArea area;
	public Appender(JTextArea a)
	{
		area = a;
	}
	public void append(String s)
	{
		area.append("\n"+s);
	}
}