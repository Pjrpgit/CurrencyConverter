package com.zero.currency.servicetest;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.List;

import com.zero.currency.models.Country;
import com.zero.currency.services.XmlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class XmlServiceTest {
	
	@Autowired
	XmlService xmlService;

	@Test
	public void readXml() throws IOException {
		List<Country> countries=xmlService.readXml();
		assertNotNull(countries);
	}
	
}
