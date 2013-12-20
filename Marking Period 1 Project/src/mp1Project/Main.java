package mp1Project;

import processing.core.PApplet;

public class Main extends PApplet
{	
	private Triangle tri;
	private TextForTri text;
	
	private Buttons buttonForTriColor;
	private Buttons buttonForOtherColors;
	private Buttons reset;
	private Buttons randomizer;
	
	public void setup()
	{
		size(600, 600);
		tri = new Triangle(this);
		text = new TextForTri(this, null);
		buttonForTriColor = new Buttons(this, 300, 0, -50, "Change Triangle Colors", 
				300, 150, 255, 0, 0);
		buttonForOtherColors = new Buttons(this, 0, 450, -100, "Change ALL (well almost) the colors",
				300, 150, 0, 255, 0);
		reset = new Buttons(this, 300, 450, -40, "Reset to original", 
				300, 150, 0, 255, 255);
		randomizer = new Buttons(this, 0, 250, -20, "Try it!", 
				100, 100, 255, 0, 255);
	}
	
	public void draw()
	{
		background(0);
		
		text.updateText("Triangle info:\nArea: " + round(tri.getArea()) + 
				" units\nPerimeter: " + round(tri.getPerimeter()) + 
				" units\nAB = " + round(tri.getpointA().getDistance(tri.getpointB())) +
				" units\nBC = " + round(tri.getpointB().getDistance(tri.getpointC())) + 
				" units\nAC = " + round(tri.getpointA().getDistance(tri.getpointC())) + 
				" units\nAngle A: " + round(tri.getAngle(1) * (180/Math.PI)) +
				" degrees\nAngle B: " + round(tri.getAngle(2) * (180/Math.PI)) +
				" degrees\nAngle C: " + round(tri.getAngle(3) * (180/Math.PI)) + " degrees");
		buttonForTriColor.draw();
		buttonForOtherColors.draw();
		reset.draw();
		
		randomizer.draw();

		text.draw();		
		
		tri.draw();
	}
	public void mouseDragged()
	{
		if(mouseX < 5)
			mouseX = 5;
		if(mouseX > 595)
			mouseX = 595;
		if(mouseY < 5)
			mouseY = 5;
		if(mouseY > 595)
			mouseY = 595;
		Vertex mouse = new Vertex(this, mouseX, mouseY, "", 0, 0);
		
		if(!text.beingDragged())
			tri.mouseDragged(mouse);
		if(!tri.beingDragged())
			text.mouseDragged(mouse);
	}
	
	public void mouseClicked()
	{
		Vertex mouse = new Vertex(this, mouseX, mouseY, "", 0, 0);
		
		if(buttonForTriColor.mouseClicked(mouse))
			tri.randomColor();
		
		if(buttonForOtherColors.mouseClicked(mouse))
		{
			buttonForTriColor.randomColor();
			buttonForOtherColors.randomColor();
			reset.randomColor();
			randomizer.randomColor();
			
			Vertex.randomColor();
			text.randomColor();
		}
		
		if(reset.mouseClicked(mouse))
		{
			setup();
			Vertex.resetColor();
		}
		
		if(randomizer.mouseClicked(mouse))
		{
			tri.getpointA().randomPoint();
			tri.getpointB().randomPoint();
			tri.getpointC().randomPoint();
		}
	}
	
	public static double round(double num)
	{
		return ((int)(num * 100)) / 100.0;
	}
}