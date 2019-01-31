//Darian Sampare
//T00578132
//COMP 1232
//Y.Linn
//Assignment 1
//*************************************************************************


// derives a rectangular prism object from the Shape class
public class RectangularPrism extends Shape
{
	
	// add variables needed for computations
	protected double length;
	protected double width;
	protected String dimensions = getDimensions();
	//^^^opted to show the value of the dimensions as a string for clarity

	// constructs the rectangular prism with given length, width and height
	public RectangularPrism(double l, double w, double h)
	{

		length = l;
		height = h;
		width  = w;

	}

	// changes the dimensions of the prism(mutator)
	public void setDimensions(double l, double w, double h)
	{

		length = l;
		height = h;
		width  = w;


	}

	// tells us the dimensions of the prism and returns it as a string(accessor)
	public String getDimensions()
	{	

		return (length +" by " + width + " by " + height);

	}

	// computes the surface area of the prism
	public double getSurfaceArea()
	{

		return 2 * (length * width) + 2 * (length * height) + 2 * (height * width);

	}

	// computes the volume of the prism
	public double getVolume()
	{

		return length * width * height;

	}

}