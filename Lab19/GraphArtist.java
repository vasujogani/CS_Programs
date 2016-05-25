import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;

public class GraphArtist extends JFrame
{
	private JLabel textField;
	private GraphPanel panel;
	private IGraph<IGraphable> graph;
	private String message;
	private long delay;
	private Queue<Integer> nodeUpdatesIndex;
	private Queue<Color> nodeUpdatesColor;
	private Queue<String> edgeUpdatesIndex;
	private Queue<Color> edgeUpdatesColor;
	private boolean directed;
	
	public GraphArtist(IGraph<IGraphable> graph, boolean directed)
	{
		this(graph, Color.WHITE, Color.BLACK, directed);
	}
	
	public GraphArtist(IGraph<IGraphable> graph)
	{
		this(graph, false);
	}
	
	public GraphArtist(IGraph<IGraphable> graph, Color node, Color edge, boolean directed)
	{
		super("Graph Art");
		
		this.directed = directed;
		this.graph = graph;
		this.message = "";
		this.textField = new JLabel(this.message);
		this.panel = new GraphPanel(graph, node, edge, directed);
		this.nodeUpdatesIndex = new LinkedList<Integer>();
		this.nodeUpdatesColor = new LinkedList<Color>();
		this.edgeUpdatesIndex = new LinkedList<String>();
		this.edgeUpdatesColor = new LinkedList<Color>();
		
		this.delay = 1000;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		getContentPane().add(textField, BorderLayout.SOUTH);
		getContentPane().add(panel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GraphArtist update()
	{
		return redraw().delay();
	}
	
	public GraphArtist setDelay(long delay)
	{
		this.delay = delay;
		return this;
	}
	
	private GraphArtist delay()
	{
		long future = System.currentTimeMillis() + delay;
		while(System.currentTimeMillis() < future)
		{
			Thread.yield();
		}
		return this;
	}
	
	private GraphArtist redraw()
	{
		textField.setText(message);
		
		while(!nodeUpdatesIndex.isEmpty())
		{
			int v = nodeUpdatesIndex.remove();
			Color c = nodeUpdatesColor.remove();
			panel.updateNode(v, c);
		}
		
		while(!edgeUpdatesIndex.isEmpty())
		{
			String vs = edgeUpdatesIndex.remove();
			Color c = edgeUpdatesColor.remove();
			panel.updateEdge(vs, c);
		}
		
		repaint();
			
		return this;
	}
	
	public GraphArtist setMessage(String message)
	{
		this.message = message;
		return this;
	}
	
	public GraphArtist updateNode(int index, Color color)
	{
		nodeUpdatesIndex.add(index);
		nodeUpdatesColor.add(color);
		return this;
	}
	
	public GraphArtist updateEdge(int v1, int v2, Color color)
	{
		String key = v1+","+v2;
		edgeUpdatesIndex.add(key);
		edgeUpdatesColor.add(color);
		
		if(!directed)
		{
			key = v2+","+v1;
			edgeUpdatesIndex.add(key);
			edgeUpdatesColor.add(color);
		}
		
		return this;
	}
}

class GraphPanel extends JPanel
{
	private IGraph<IGraphable> graph;
	private Map<Integer, Color> nodeColors;
	private Map<String, Color> edgeColors; //Key: "v1,v2"
	private Color defaultNode;
	private Color defaultEdge;
	private BufferedImage background;
	private int radius;
	private boolean directed;
	
	public GraphPanel(IGraph<IGraphable> graph, Color node, Color edge)
	{
		this(graph, node, edge, false);
	}
	
	public GraphPanel(IGraph<IGraphable> graph, Color node, Color edge, boolean directed)
	{
		this.directed = directed;
		this.radius = 10;
		this.graph = graph;
		this.nodeColors = new HashMap<Integer, Color>();
		this.edgeColors = new HashMap<String, Color>();
		this.defaultNode = node;
		this.defaultEdge = edge;

		background = null;		
		try
		{
		//	background = ImageIO.read(new File("masdfaps.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Cannot find map.jpg file");
		}
		
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.BLACK);
	}
	
	public void updateNode(int index, Color color)
	{
		nodeColors.put(index, color);
	}
	
	public void updateEdge(int v1, int v2, Color color)
	{
		updateEdge(v1+","+v2, color);
	}
	
	public void updateEdge(String s, Color color)
	{
		edgeColors.put(s, color);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(null != background)
			g.drawImage(background, 0, 0, this);
		
		//draw the graph		
		java.util.List<IGraphable> verticies = graph.getVerticies();
		if(null != verticies)
		{
			for(int i = 0; i < verticies.size(); i++)
			{
				IGraphable v1 = graph.getVertex(i);
				int[] neighbors = graph.getNeighbors(i);
				for(int j = 0; j < neighbors.length; j++)
				{
					int k = neighbors[j];
					IGraphable v2 = graph.getVertex(k);
					Color color = getEdgeColor(i, k);
					String label = "";//weight
					
					int xOff = 0;
					int yOff = 0;
					int d = 1;
					if(directed)
					{
						if(i > k)
						{
							xOff += d;
							yOff -= d;
						}
						else
						{
							xOff -= d;
							yOff += d;
						}
					}
					drawEdge(g, v1.getX() + xOff, v1.getY() + yOff, v2.getX() + xOff, v2.getY() + yOff, color, label, i < k);
				}	
			}
			
			for(int i = 0; i < verticies.size(); i++)
			{
				IGraphable vertex = verticies.get(i);
				Color color = getVertexColor(i);
				drawVertex(g, vertex.getX(), vertex.getY(), color, vertex.getLabel());
			}
		}
	}
	
	private Color getVertexColor(int index)
	{
		return null == nodeColors.get(index) 
			? defaultNode 
			: nodeColors.get(index);
	}
	
	private Color getEdgeColor(int v1, int v2)
	{
		String key = v1+","+v2;
		return null == edgeColors.get(key) 
			? defaultEdge 
			: edgeColors.get(key);
	}
	
	private void drawVertex(Graphics g, int x, int y, Color c, String label)
	{
		g.setColor(c);
		x -= radius/2;
		y -= radius/2;
		g.fillOval(x, y, radius, radius);
		
		g.drawString(label, x+radius/2, y-radius/2);
	}
	
	private void drawEdge(Graphics g, int x1, int y1, int x2, int y2, Color c, String label, boolean side)
	{
		Graphics2D g2 = (Graphics2D)g;
		Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
		g.setColor(c);
		g2.draw(line);
		
		label = "999";
		if(null != label && !"".equals(label))
		{
			int offx = 10;
			int offy = -10;
			
			int minx = Math.min(x1, x2);
			int miny = Math.min(y1, y2);
			
			int maxx = Math.max(x1, x2);
			int maxy = Math.max(y1, y2);
			
			if(side && directed)
			{
				offx = -10;
				offy = 10;
			}
			
			int mx = minx + (maxx - minx) / 2;
			int my = miny + (maxy - miny) / 2;
			g.drawString(label, mx + offx, my + offy);
		}
	}
}