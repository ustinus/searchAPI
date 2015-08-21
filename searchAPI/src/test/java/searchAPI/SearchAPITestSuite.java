package searchAPI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   CountryTests.class,
   GeneralTestsPositive.class,
   GeneralTestsNegative.class,
   LimitTests.class,
   MediaTests.class,
   TermTests.class
})


public class SearchAPITestSuite {
}
