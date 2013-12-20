package mp1Project;

import processing.core.PApplet;

/**
 * Creates a circle that can be dragged around
 * @author Francis Joe
 *
 */
public class Vertex
{
	private double x, y, xSpace, ySpace;
	private PApplet myParent;
	private String label;
	private static double colorA = 100;
	private static double colorB = 100;
	private static double colorC = 100;
	
	/**
	 * Creates ellipse with given parameters
	 * @param parent PApplet
	 * @param xCoor x coordinate
	 * @param yCoor y coordinate
	 * @param label label
	 * @param xSpace space between label and point (horizontally)
	 * @param ySpace space between label and point (vertically)
	 */
	public Vertex(PApplet parent, double xCoor, double yCoor, String label, double xSpace, double ySpace)
	{
		myParent = parent;
		x = xCoor;
		y = yCoor;
		this.label = label;
		this.xSpace = xSpace;
		this.ySpace = ySpace;
	}

	/**
	 * Set x coordinate to given value
	 * @param xCoor New x coordinate
	 */
	public void setX(double xCoor)
	{
		x = xCoor;
	}

	/**
	 * Set y coordinate to given value
	 * @param yCoor New y coordinate
	 */
	public void setY(double yCoor)
	{
		y = yCoor;
	}

	/**
	 * Returns x coordinate
	 * @return x coordinate
	 */
	public double getX()
	{
		return x;
	}

	/**
	 * Returns y coordinate
	 * @return y coordinate
	 */
	public double getY()
	{
		return y;
	}

	/**
	 * Draws the vertex
	 */
	public void draw()
	{
		myParent.fill((float)colorA, (float)colorB, (float)colorC);
		myParent.ellipse((float)x, (float)y, 10, 10);
		myParent.text(label, (float)(x + xSpace), (float)(y + ySpace));
	}
	
	/**
	 * Returns distance between two vertices
	 * @param v1
	 * @param v2
	 * @return
	 */
	public double getDistance(Vertex v2)
	{
		double x1 = x;
		double y1 = y;
		double x2 = v2.getX();
		double y2 = v2.getY();

		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	
	/**
	 * Assigns a random color to all of the vertices
	 */
	public static void randomColor()
	{
		colorA = Math.random() * 255;
		colorB = Math.random() * 255;
		colorC = Math.random() * 255;
	}
	
	/**
	 * Assigns a random color to vertex and label
	 */
	public static void resetColor()
	{
		colorA = colorB = colorC = 100;
	}
	
	/**
	 * Assigns a random point to vertex
	 */
	public void randomPoint()
	{
		x = Math.random() * 590 + 5;
		y = Math.random() * 300 + 145;
		if((x > 0 && x < 100) && (y > 250 && y < 350))
			randomPoint();
	}
}