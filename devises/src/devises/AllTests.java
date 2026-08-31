package devises;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ MoneyTest.class, MoneyBagTest.class })
class AllTests {
}
