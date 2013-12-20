package mp1Project;

import processing.core.PApplet;

/**
 * Creates a triangle and draws it
 * @author Francis Joe
 *
 */
public class Triangle extends PApplet
{
	private PApplet myParent;
	private Vertex pointA, pointB, pointC;
	private double ab, bc, ac;
	private double colorA, colorB, colorC = 255;
	private boolean isBeingDragged;
	
	/**
	 * Creates the triangle. Default triangle are at these points
	 * @param parent
	 */
	public Triangle(PApplet parent)
	{
		myParent = parent;
		pointA = new Vertex(myParent, 300, 242, "A", 0, -30);
		pointB = new Vertex(myParent, 250, 329, "B", 0, 30);
		pointC = new Vertex(myParent, 350, 329, "C", 0, 30);
	}

	/**
	 * Returns area of the triangle
	 * @return area
	 */
	public double getArea()
	{
		return 1.0/2 * ab * bc * Math.sin(getAngle(2));
	}

	/**
	 * Returns the angle measurement of given angle
	 * @param v1 Angle
	 * @return angle measurement
	 */
	public double getAngle(int angle)
	{
		if(angle == 1)
			return Math.acos((ab * ab + ac * ac - bc * bc) / (2 * ab * ac));
		if(angle == 2)
			return Math.acos((ab * ab + bc * bc - ac * ac) / (2 * ab * bc));
		if(angle == 3)
			return Math.acos((bc * bc + ac * ac - ab * ab) / (2 * bc * ac));

		else
			return -1;
	}

	/**
	 * Returns perimeter of triangle
	 * @return perimeter
	 */
	public double getPerimeter()
	{
		return ab + bc + ac;
	}

	/**
	 * Returns the first point of the triangle
	 * @return point pointA
	 */
	public Vertex getpointA()
	{
		return pointA;
	}

	/**
	 * Returns the second point of the triangle
	 * @return point pointB
	 */
	public Vertex getpointB()
	{
		return pointB;
	}

	/**
	 * Returns the third point of the triangle
	 * @return point pointC
	 */
	public Vertex getpointC()
	{
		return pointC;
	}

	/**
	 * Draws the triangle and its points
	 */
	public void draw()
	{
		ab = pointA.getDistance(pointB);
		bc = pointB.getDistance(pointC);
		ac = pointA.getDistance(pointC);
		
		pointA.draw();
		pointB.draw();
		pointC.draw();
		
		myParent.fill((float)colorA, (float)colorB, (float)colorC);
		myParent.triangle((float) pointA.getX(), (float) pointA.getY(), (float) pointB.getX(),
				(float) pointB.getY(), (float) pointC.getX(), (float) pointC.getY());
	}
	
	/**
	 * If the mouse is in range of a vertex and clicks and moves, the vertex will move
	 * @param mouse mouse coordinates
	 */
	public void mouseDragged(Vertex mouse)
	{
		if (pointA.getDistance(mouse) <= 10)
		{
			pointA.setX(mouse.getX());
			pointA.setY(mouse.getY());
			isBeingDragged = true;
		}
		else if (pointB.getDistance(mouse) <= 10)
		{
			pointB.setX(mouse.getX());
			pointB.setY(mouse.getY());
			isBeingDragged = true;
		}
		else if (pointC.getDistance(mouse) <= 10)
		{
			pointC.setX(mouse.getX());
			pointC.setY(mouse.getY());
			isBeingDragged = true;
		}
		else
			isBeingDragged = false;
	}
	
	/**
	 * Returns if one of the vertexes are being dragged
	 * @return If a vertex is being dragged
	 */
	public boolean beingDragged()
	{
		return isBeingDragged;
	}
	
	/**
	 * Assisgns the triangle a random color
	 */
	public void randomColor()
	{
		colorA = Math.random() * 255;
		colorB = Math.random() * 255;
		colorC = Math.random() * 255;
	}
}