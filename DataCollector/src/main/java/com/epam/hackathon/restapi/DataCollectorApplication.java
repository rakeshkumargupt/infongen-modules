package com.epam.hackathon.restapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
		
		Random random=new Random();
		
		
		Map<String, String> values = new HashMap<>();
		values.put("apple",
				"http://igen-api.qa.infongen.cc/v2/searches/135149c8-21bb-4b8a-96e2-6443288e4029/results?limit=250&show_options=documents&rnd="+random.nextInt());
	values.put("samsung",
		"http://igen-api.qa.infongen.cc/v2/searches/d632ade4-b0ce-4e39-8fd3-232192fd6d74/results?limit=250&show_options=documents&rnd="+random.nextInt());
		 values.put("sony",
				 "http://igen-api.qa.infongen.cc/v2/searches/cdc77938-8f84-4ac6-ab3a-22283103fea9/results?limit=250&show_options=documents&rnd="+random.nextInt());
		Map<String, Float> allCal = new HashMap<>();
		
		values.forEach((product, uri) -> {
			ResponseDocuments data = restCallUtil.callGetMethod(uri);

			Map<String, Integer> counter = new HashMap<>();
			Map<String, Integer> counterNeg = new HashMap<>();
			Map<String, Integer> counterPos = new HashMap<>();
			Map<String, Float> calCulated = new HashMap<>();
			
			CsvFileWriter.writeToCSV(product, DocToCSVDataConv.getCSVDto(data, counter, counterNeg, counterPos));

			System.out.println(product+"---"+counter+ ""+counterNeg+ counterPos);
			
			
			counterPos.forEach((day, val) -> {
				int tot = 0;
				if (counterNeg.containsKey(day)) {
					tot = counterNeg.get(day) + counterPos.get(day);
					
					System.out.println("Negative - "+counterNeg.get(day) + " Positive - "+ counterPos.get(day)); 
					
					if (tot > 0 && counterPos.get(day) > 0) {
						float cal = (float)( (float) counterPos.get(day) / (float) tot)*100;
						System.out.println("Cal - " + cal);
						calCulated.put(day, cal);
					}
				}

			});

			float totPos = (float) counterPos.values().stream().mapToDouble(i -> i).sum();
			float totlNeg =(float) counterNeg.values().stream().mapToDouble(i -> i).sum();
			
			float tot =(totPos/( totPos + totlNeg))*100;
			allCal.put(product, tot);

			System.out.println("calCulated" + calCulated);

			CsvFileWriter.writeFileFromMapInt(product + "_neg", counterNeg);

			CsvFileWriter.writeFileFromMapInt(product + "_pos", counterPos);

			CsvFileWriter.writeFileFromMapFloat(product + "_consolidated", calCulated);

		});

		CsvFileWriter.writeFileFromMapFloat("_speedo", allCal);

	}

}
