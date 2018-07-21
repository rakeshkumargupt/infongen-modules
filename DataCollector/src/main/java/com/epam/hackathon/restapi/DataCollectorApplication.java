package com.epam.hackathon.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.epam.hackathon.restapi.model.ResponseDocuments;
import com.epam.hackathon.restapi.serialize.CsvFileWriter;
import com.epam.hackathon.restapi.util.DocToCSVDataConv;
import com.epam.hackathon.restapi.util.RestCallUtil;

@SpringBootApplication
public class DataCollectorApplication implements CommandLineRunner {

	@Autowired
	private RestCallUtil restCallUtil;

	public static void main(String[] args) {
		SpringApplication.run(DataCollectorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		ResponseDocuments data = restCallUtil.callGetMethod();
		//System.out.println(DocToCSVDataConv.getCSVDto(data));
		CsvFileWriter.appendFile("apple_1", DocToCSVDataConv.getCSVDto(data));
		
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		ResponseDocuments dco = objectMapper.readValue(data, ResponseDocuments.class);
//		System.out.println(dco);

	}

}
