package com.epam.hackathon.restapi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.epam.hackathon.restapi.model.ResponseDocuments;
import com.epam.hackathon.restapi.serialize.BaseDto;

public class DocToCSVDataConv {
	
	public static List<BaseDto> getCSVDto(final ResponseDocuments docs, Map<String, Integer> counter, Map<String, Integer> counterNeg, Map<String, Integer> counterPos){
		List<BaseDto> dtos=new ArrayList<>();
		
		docs.getDocuments().stream().forEach(
				doc->{
					
					BaseDto dto=new BaseDto();
					dto.setContent(doc.getHeadline());
					DateTime dt = new DateTime(doc.getPublished_at());
					System.err.println(dt);
					String day=dt.getDayOfMonth()+""+dt.getMonthOfYear()+""+dt.getYear();
					int val=1;
					if(counter.containsKey(day)) {
						val+=counter.get(day);
						
						
					}
					counter.put(day, val);
					
					dto.setDate(doc.getPublished_at());
					dto.setLink(doc.getUri());
					dto.setTag(doc.getTags().toString());
					dto.setTime(doc.getPublished_at());
					System.out.println("Polarity ---"+doc.getSentiments().get(0).getPolarities().get(0).getPolarity());
					try {
						if(doc.getSentiments().get(0).getPolarities().get(0).getPolarity()!=null)
						if(doc.getSentiments().get(0).getPolarities().get(0).getPolarity().equals("negative"))
						{
							int valN=1;
							if(counterNeg.containsKey(day)) {
								
								valN+=counterNeg.get(day);
								
							}
							counterNeg.put(day, valN);
							
							
						}
						
						else if(doc.getSentiments().get(0).getPolarities().get(0).getPolarity().equalsIgnoreCase("positive"))
						{
							int valN=1;
							if(counterPos.containsKey(day)) {
								
								valN+=counterPos.get(day);
								
							}
							counterPos.put(day, valN);
							
							
						}
						
					dto.setSenNegetiveCount(doc.getSentiments().get(0).getPolarities().get(0).getPolarity());
					}catch(Exception ex) {
						System.err.println("Error");
					}
					dtos.add(dto);
				}
				
				);
		System.out.println(counter);
		
		
		
		
		return dtos;
	}
	

}
