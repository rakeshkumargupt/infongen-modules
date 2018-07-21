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
		Map<String, String> values=new HashMap<>();
		values.put("apple", "http://igen-api.qa.infongen.cc/v2/searches/135149c8-21bb-4b8a-96e2-6443288e4029/results?limit=250&show_options=documents");
		
	//	values.put("samsung", "http://igen-api.qa.infongen.cc/v2/searches/135149c8-21bb-4b8a-96e2-6443288e4029/results?limit=5&show_options=documents");
		
		
		
		
		values.forEach((product, uri)->{
			ResponseDocuments data = restCallUtil.callGetMethod(uri);
			//System.out.println(DocToCSVDataConv.getCSVDto(data));
			
			Map<String, Integer> counter=new HashMap<>();
			Map<String, Integer> counterNeg=new HashMap<>();
			Map<String, Integer> counterPos=new HashMap<>();
			Map<String, Float> calCulated=new HashMap<>();
			
			
			counterPos.forEach((day, val)->{
				int tot=0;
				if(counterNeg.containsKey(day)) {
					tot=counterNeg.get(day)+counterPos.get(day);
					float cal=(float)counterPos.get(day)%tot;
					calCulated.put(day, cal);
				}
				
			});
			
			CsvFileWriter.writeFileFromMapInt(product+"_neg", counterNeg);
			
			CsvFileWriter.writeFileFromMapInt(product+"_pos", counterPos);
			
			CsvFileWriter.writeFileFromMapFloat(product+"_all", calCulated);
			
			CsvFileWriter.appendFile(product, DocToCSVDataConv.getCSVDto(data, counter,counterNeg, counterPos));
			
			
		});
	
		
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		ResponseDocuments dco = objectMapper.readValue(data, ResponseDocuments.class);
//		System.out.println(dco);

	}

}
