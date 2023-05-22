package shapes;

public class Rectangle extends BoundedShapes{
	private double length;
	private double breadth;

	public Rectangle(int x,int y,double length,double breadth) 
	{
		super(x,y);
		this.length=length;
		this.breadth=breadth;
	}
	
	public String toString()
	{
		return "Rectangle"+super.toString()+"[length="+length+",breadth="+breadth+"]";
	}
	
    public double area()
    {
    	return length*breadth;
    }
    public double perimeter()
    {
    	return 2*(length+breadth);
    }

}
