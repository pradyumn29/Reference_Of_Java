package tester;

import shapes.*;

public class TestBoundsShapes {

	public static void main(String[] args) {
		

		//BoundedShape s=new BoundedShape(10,20);
		
		BoundedShapes []shapes= {new Circle(10,20,12.5),new Rectangle(30,60,15.6,40.5)};
		
		for(BoundedShapes s:shapes)
		{
			System.out.println(s);
		
		 System.out.println("area"+s.area()+"perimeter"+s.perimeter());
		 
		 if(s instanceof Circle)
			 ((Circle)s).drawArc(15);
		 }
		
	}

}
