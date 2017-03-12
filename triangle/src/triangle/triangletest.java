package triangle;

public class triangletest {
	
	public int test (int  edgea, int edgeb, int edgec )
	{
		System.out.println(" into the test function");
		if( edgea == edgeb && edgea == edgec)
		{
			System.out.println(" the triangle is equilateral! ");
			return 1;
		}
		else if ( edgea != edgeb && edgea != edgec && edgeb != edgec)
		{
			System.out.println(" the triangle is scalene! ");
			return 3;
		}
		else
		{
			System.out.println(" the triangle is isosceles! ");
			return 2;
		}
	}

}
