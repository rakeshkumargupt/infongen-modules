/**
 * 
 */
package com.epam.hackathon.restapi.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rakesh_Gupta
 *
 */
@Service
public class RestCallUtil {

	static String auth = "eyJraWQiOiJWbUZEN0pIU2ZEeE14K05wakZiS1hoVXEwOGVOenBWbUcrNHluMWdseUkwPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YmE0YThjMi1kNWYwLTRiOTQtOGMxMi0yYmNkYTVjYzU2YTAiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6InNlYXJjaFwvcmVhZCBzZWFyY2hcL2FsbCIsImF1dGhfdGltZSI6MTUzMjE2NTg4NCwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfZjNBNW44Y2xJIiwiZXhwIjoxNTMyMTY5NDg0LCJpYXQiOjE1MzIxNjU4ODQsInZlcnNpb24iOjIsImp0aSI6IjdlZTBkZWUyLTZhZDMtNDkyNi1iMDY4LWE1Mjc1NTVlODBmYiIsImNsaWVudF9pZCI6IjI4NnJpaHZsdGF2ajVrOWhibHFjamlqa3BsIiwidXNlcm5hbWUiOiJFUEFNX3N3eHdlcW1nMDBhQmpMNzd0VjRMc2c9PSJ9.Rq2IyCtdUCwxgMMqQpnYHIFGv9pRndzegrdoeVSb9MxzgJsfHpq8DRwiRI01x7jlvTGJT90_Rs7aLcyKaMiJa1bmyZft5pvKWR9beeMqFVuQutkGbEIFgjYnWb-QM3TE9CChBy01PeU7VtrY3K1NzIJTdCbsrpbRr_sTGGsuZ477ty6-MN34rb3Z4G2Rug7VuqUngpMqiElZH98FHYZRe8SlgXpmnTnaoNDfujr4AZ0f8vNp_czcN6O4NjrBMVQIFei2l5eQ4v-688fXYay6mvldFIijVsROFArN3ZrWpA1y17-wQrMJeD6QIBQxgAmxis7G9oHzkBtA6PM8JplBgw";
	String xAPI = "sEEi7skqmF7oWIjmkz9jL8z7Dz2Yt3GAaXcErfpi";
	String uri = "http://igen-api.qa.infongen.cc/v2/searches/135149c8-21bb-4b8a-96e2-6443288e4029/results?limit=10&show_options=documents";

	@Autowired
	RestTemplate restTemplate;

	HttpHeaders createHeaders() {

		return new HttpHeaders() {
			{

				String authHeader = "Basic " + new String(auth);
				set("Authorization", authHeader);
				set("x-api-key", "sEEi7skqmF7oWIjmkz9jL8z7Dz2Yt3GAaXcErfpi");
				set("Content-Type", "application/json");
			}
		};
	}

	public String callGetMethodTest() {

		HttpEntity<String> entity = new HttpEntity<>(createHeaders());
		return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();

	}

	/**
	 * For calling rest post call with headers and basic auths
	 * 
	 * @param url
	 * @param headers
	 * @param body
	 * @return
	 */
	public Object callPostMethod(String url, Map<String, String> headers, String body) {
		return null;
	}

}
