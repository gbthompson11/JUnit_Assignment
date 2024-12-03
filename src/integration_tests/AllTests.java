package integration_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.*;

@RunWith(Suite.class)
@SuiteClasses({ BookUserTest.class, 
				UserLibraryTest.class, 
				BookTest.class, 
				UserTest.class, 
				LibraryTest.class})
public class AllTests {

}
