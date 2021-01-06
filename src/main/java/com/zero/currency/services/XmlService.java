package com.zero.currency.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zero.currency.models.Country;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class XmlService {

	public List<Country> readXml() throws IOException {
		File file = new File("src/main/resources/static/xml/codes.xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = inputStreamToString(new FileInputStream(file));
		LogManager.getLogger(this.getClass()).info(">>>>>>>>"+xml);
		return xmlMapper.readValue(xml, new TypeReference<List<Country>>() {});

	}

	private String inputStreamToString(InputStream is) throws IOException {

		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();

	}

}
