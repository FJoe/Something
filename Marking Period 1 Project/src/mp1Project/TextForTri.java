package mp1Project;

import processing.core.PApplet;

/**
 * Creates a textbox
 * @author Francis Joe
 *
 */
public class TextForTri extends PApplet
{
	
	private PApplet myParent;
	private Vertex dragThis;
	private String words;
	private double xOfRect, yOfRect;
	private double colorA, colorB, colorC;
	private boolean isBeingDragged;
	
	/**
	 * Creates a textbox with given words
	 * @param parent PApplet
	 * @param words Words to be displayed
	 */
	public TextForTri(PApplet parent, String words)
	{
		myParent = parent;
		this.words = words;
		
		colorA = colorC = 255;
		colorB = 0;
		
		dragThis = new Vertex(myParent, xOfRect + 200, yOfRect + 50, "Drag me!", -20, -20);
	}
	
	/**
	 * Draws the textbox
	 */
	public void draw()
	{
		myParent.fill((float)colorC, (float)colorA, (float)colorB);
		myParent.rect((float)xOfRect, (float)yOfRect, 300, 150);
		dragThis.draw();
		
		myParent.fill((float)colorA, (float)colorB, (float)colorC);
		myParent.text(words, (float)xOfRect + 5, (float)(yOfRect + 13));
	}	
	
	/**
	 * Updates text in box
	 * @param updated New words
	 */
	public void updateText(String updated)
	{
		words = updated;
	}
	
	/**
	 * Allows textbox to be dragged around
	 * @param mouse
	 */
	public void mouseDragged(Vertex mouse)
	{
		if (dragThis.getDistance(mouse) <= 10)
		{
			xOfRect = mouse.getX() - 200;
			yOfRect = mouse.getY() - 50;
			dragThis.setX(xOfRect + 200);
			dragThis.setY(yOfRect + 50);
			isBeingDragged = true;
		}
		else
			isBeingDragged = false;
	}
	
	/**
	 * Returns whether the textbox is being dragged
	 * @return If being dragged
	 */
	public boolean beingDragged()
	{
		return isBeingDragged;
	}
	
	/**
	 * Assigns the textbox a random color
	 */
	public void randomColor()
	{
		colorA = Math.random() * 255;
		colorB = Math.random() * 255;
		colorC = Math.random() * 255;
	}
}