//Darian Sampare
//T00578132
//COMP 1232
//Y.Linn
//Assignment 1
//*************************************************************************

// derives a sphere object from the Shape class
public class Sphere extends Shape
{

	// radius and pie are added to variables for calculations 
	protected double radius;
	public double pi = Math.PI;

	// constructs a sphere with a given radius(constructor)
	public Sphere(double rad)
	{

		radius = rad;

	}

	// changes the length of the radius(mutator)
	public void setRadius(double rad)
	{

		radius = rad;

	}

	// tells us the radius of the sphere(accessor)
	public double getRadius()
	{

		return radius;

	}

	// computes the surface area of the sphere
	public double getSurfaceArea()
	{

		return 4 * pi * Math.pow(radius,2); 

	}

	// computes the volume of the sphere
	public double getVolume()
	{

		return (4/3) * pi * Math.pow(radius,3);

	}
	
}