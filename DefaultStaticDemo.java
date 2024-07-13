package java8;

interface Shape {


    default String description() {
        return "This is a shape.";
    }


    static double perimeter(double length, double width) {
        return 2 * (length + width);
    }
}
public class DefaultStaticDemo implements Shape{
  
    private double length;
    private double width;
    public DefaultStaticDemo(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public String description() {
        return "This is a rectangle.";
    }
	public static void main(String[] args) {
		
		DefaultStaticDemo rectangle= new DefaultStaticDemo(5,3);
		System.out.println(rectangle.description()); 

	   double perimeter = Shape.perimeter(rectangle.length, rectangle.width);
	    System.out.println("Perimeter: " + perimeter);
	}

}
