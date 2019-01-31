//Darian Sampare
//T00578132
//COMP 1232
//Y.Linn
//Assignment 1
//*************************************************************************

//derives a cube object from the Shape class
public class Cube extends Shape
{
	
	;
	//construct the cube with a given side length(constructor)
	public Cube(double side)
	{
	
		height = side;
	
	}

	//changes the side length of the cube(mutator)
	public void setHeight(double side)
	{

		height = side;

	}

	//tells us the side length of the cube(accessor)
	public double getHeight()
	{

		return height;

	}

	//computes the surface area of the cube
	public double getSurfaceArea()
	{

		return Math.pow(height,2) * 6;

	}

	//computes the volume of the cube
	public double getVolume()
	{

		return Math.pow(height,3);

	}

}