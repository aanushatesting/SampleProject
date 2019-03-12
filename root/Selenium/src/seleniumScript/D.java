package seleniumScript;


import org.junit.Rule;
//import org.junit.Test;
import org.junit.rules.TestName;

public class D {
	  @Rule
	  public TestName name= new TestName();
	  
      @DisplayName(value1 = "", value = "")
	  @org.junit.Test
	  public void testA(TestInfo info) {
	      //assertEquals("testA", name.getMethodName());
		  System.out.println(info.getDisplayName());
	     }
}
