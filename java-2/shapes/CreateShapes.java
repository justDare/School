//Darian Sampare
//T00578132
//COMP 1232
//Y.Linn
//Assignment 1
//*************************************************************************

// constructs a shape from each child class and displays their relative dimensions, surface area and volume
public class CreateShapes
{

	public static void main(String[]args)
	{
	
	Cube myCube = new Cube(2);
	Sphere mySphere = new Sphere(3);
	RectangularPrism myPrism = new RectangularPrism(4,3,3);


	String vol = ("the volume is: ");
	String sa  = ("the surface area is: ");
	String heightis = ("the height is: ");
	

	System.out.println("Cube:");
	System.out.println( heightis + myCube.getHeight());
	System.out.println( sa + myCube.getSurfaceArea());
	System.out.println( vol + myCube.getVolume());
	System.out.println();

	System.out.println("Sphere:");
	System.out.println("radius is: " + mySphere.getRadius());
	System.out.println( sa + mySphere.getSurfaceArea());
	System.out.println( vol + mySphere.getVolume());
	System.out.println();

	System.out.println("Rectangular Prism:");
	System.out.println("dimensions are: " + myPrism.getDimensions());
	System.out.println( sa + myPrism.getSurfaceArea());
	System.out.println( vol + myPrism.getVolume());
	System.out.println();
	}

}
