package seleniumScript;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit5Annotations {
	
	@Before
	public void setUp()
	{
		System.out.println("@BeforeEach");
	}
	@After
	public void tearDown()
	{
		System.out.println("@AfterEach");
	}
	@BeforeClass
	public static void oneTimeSetUp()
	{
		System.out.println("@BeforeAll");
	}
	@AfterClass
	public static void oneTimeTearDown()
	{
		System.out.println("@AfterAll");
	}
	//@DisplayName("Verify A test")
	@Test
	public void testA()
	{
		System.out.println("@Test1");
	}
	//@DisplayName("Verify B test")
	@Disabled
	@Test
	public void testB()
	{
		System.out.println("@Test2");
	}

}
