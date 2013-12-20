package mp1Project;

import processing.core.PApplet;

/**
 * Creates a button and a background box
 * @author Francis Joe
 *
 */
public class Buttons extends PApplet
{
	private PApplet myParent;
	private Vertex button;
	private double x, y;
	private double colorA, colorB, colorC;
	private double length, width;
	
	/**
	 * Creates a button and background box with given parameters
	 * @param parent PApplet
	 * @param xcoor X coordinate for box
	 * @param ycoor Y coordinate for box
	 * @param xSpace space between label and button (horizontally)
	 * @param label label for button
	 * @param length Length of box
	 * @param width Width of box
	 * @param color1 Initial first color
	 * @param color2 Initial second color
	 * @param color3 Initial third color
	 */
	public Buttons(PApplet parent, double xcoor, double ycoor, double xSpace, String label, 
			double length, double width, double color1, double color2, double color3)
	{
		myParent = parent;
		x = xcoor;
		y = ycoor;
		button = new Vertex(myParent, (2 * x + length) / 2, (2 * y + width) / 2, label, xSpace, -20);
		
		colorA = color1;
		colorB = color2;
		colorC = color3;
		
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Draws the button
	 */
	public void draw()
	{
		myParent.fill((float)colorA, (float)colorB, (float)colorC);
		myParent.rect((float)x, (float)y, (float)length, (float)width);
		button.draw();
	}
	
	/**
	 * Returns true if mouse clicks on button
	 * @param mouse Mouse coordinates
	 * @return If mouse clicks on button
	 */
	public boolean mouseClicked(Vertex mouse)
	{
		if(button.getDistance(mouse) <= 5)
			return true;
		else
			return false;
	}
	
	/**
	 * Assigns the box of the button a random color
	 */
	public void randomColor()
	{
		colorA = Math.random() * 255;
		colorB = Math.random() * 255;
		colorC = Math.random() * 255;
	}
}