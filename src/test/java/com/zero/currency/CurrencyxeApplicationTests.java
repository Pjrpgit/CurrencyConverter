package com.zero.currency;

import com.zero.currency.servicetest.CurrencyServiceTest;
import com.zero.currency.servicetest.XmlServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({

		CurrencyServiceTest.class,
		XmlServiceTest.class

})
class XeconverterApplicationTests {


}
