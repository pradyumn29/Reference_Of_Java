package shapes;
import static java.lang.Math.PI;
public class Circle extends BoundedShapes{

	public double radius;
	
	public Circle(int x,int y,double radius) {
		
		super(x,y);
	this.radius=radius;
	}
	
	@Override	
	public String toString()
	{
		return "Circle"+super.toString()+"radius="+radius;
	}
	
	@Override
	public double area()
	{
		return PI*radius*radius;
	}    
	
	@Override
	public double perimeter()
	{
		return 2*PI*radius;
	}
	
	public void drawArc(double angle)
	{
		System.out.println("Enetr angle to draw arc:"+angle);
	}

}
