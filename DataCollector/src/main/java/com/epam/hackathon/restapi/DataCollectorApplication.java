package com.epam.hackathon.restapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, String> values = new HashMap<>();
		values.put("apple",
				"http://igen-api.qa.infongen.cc/v2/searches/e66e1565-24ca-485e-94d1-21be6701c59d/results?limit=10&show_options=documents");

		 values.put("samsung",
		 "http://igen-api.qa.infongen.cc/v2/searches/4915165f-edab-4fb9-8fef-282c663be1da/results?limit=10&show_options=documents");
		 values.put("nokia",
				 "http://igen-api.qa.infongen.cc/v2/searches/c113c296-447f-4db0-acf7-fc5ebf48a575/results?limit=10&show_options=documents");
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

			float sum = (float) calCulated.values().stream().mapToDouble(i -> i).sum();
			System.out.println("Sum - " + sum);
			sum = sum / calCulated.size();
			allCal.put(product, sum);

			System.out.println("calCulated" + calCulated);

			CsvFileWriter.writeFileFromMapInt(product + "_neg", counterNeg);

			CsvFileWriter.writeFileFromMapInt(product + "_pos", counterPos);

			CsvFileWriter.writeFileFromMapFloat(product + "_all", calCulated);

		});

		CsvFileWriter.writeFileFromMapFloat("_all", allCal);

	}

}
