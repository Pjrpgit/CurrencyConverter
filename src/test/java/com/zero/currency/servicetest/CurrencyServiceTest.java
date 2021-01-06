package com.zero.currency.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.money.CurrencyUnit;
import javax.money.UnknownCurrencyException;

import com.zero.currency.services.CurrencyService;
import org.javamoney.moneta.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CurrencyServiceTest {

	
	@Autowired
	private CurrencyService currencyService;
	
	@Test
	public void givenCurrencyCode_whenString_thanExist() {
	    CurrencyUnit usd = currencyService.getCurrencyUnit("USD");
	 
	    assertNotNull(usd);
	    assertEquals(usd.getCurrencyCode(), "USD");
	    assertEquals(usd.getNumericCode(), 840);
	    assertEquals(usd.getDefaultFractionDigits(), 2);
	}
	
	@Test(expected = UnknownCurrencyException.class)
	public void givenCurrencyCode_whenNoExist_thanThrowsError() {
	    currencyService.getCurrencyUnit("AAA");
	}
	
	@Test
	public void givenAmounts_whenStringified_thanEquals() {
	 
	    CurrencyUnit usd = currencyService.getCurrencyUnit("USD");
	    Money moneyof = currencyService.getMoney(new Float(12), usd);
	 
	    assertEquals("USD", usd.toString());
	    assertEquals("USD 12.00", moneyof.toString());
	}
}
