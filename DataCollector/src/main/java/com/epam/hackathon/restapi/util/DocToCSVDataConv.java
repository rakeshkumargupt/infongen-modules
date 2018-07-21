package com.epam.hackathon.restapi.util;

import java.util.ArrayList;
import java.util.List;

import com.epam.hackathon.restapi.model.ResponseDocuments;
import com.epam.hackathon.restapi.serialize.BaseDto;

public class DocToCSVDataConv {
	
	public static List<BaseDto> getCSVDto(final ResponseDocuments docs){
		List<BaseDto> dtos=new ArrayList<>();
		
		docs.getDocuments().stream().forEach(
				doc->{
					
					BaseDto dto=new BaseDto();
					dto.setContent(doc.getHeadline());
					
					dto.setDate(doc.getPublished_at());
					dto.setLink(doc.getUri());
					dto.setTag(doc.getTags().toString());
					dto.setTime(doc.getPublished_at());
					dtos.add(dto);
				}
				
				);
		
		
		
		
		
		return dtos;
	}
	

}
