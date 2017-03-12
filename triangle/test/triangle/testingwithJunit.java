package triangle;

import static org.junit.Assert.*;

import org.junit.Test;



public class testingwithJunit {

	
    private triangletest t1= new triangletest();
	@Test
	public void test()
	{
		
		    assertEquals(t1.test(3,3,3),1);
		    assertEquals(t1.test(3,2,2),2);
		    assertEquals(t1.test(9,5,7),3);
    }


}
