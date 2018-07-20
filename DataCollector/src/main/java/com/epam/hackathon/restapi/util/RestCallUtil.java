/**
 * 
 */
package com.epam.hackathon.restapi.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import com.epam.hackathon.restapi.model.Quote;

/**
 * @author Rakesh_Gupta
 *
 */
@Service
public class RestCallUtil {

	@Autowired
	RestTemplate restTemplate;

	HttpHeaders createHeaders(HashMap<String, String> headers) {
		String username = headers.get("username");
		String password = headers.get("password");
		
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64Utils.encode(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

	/**
	 * Test sample rest call
	 * 
	 * @return
	 */
	public Object testRestCall() {
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote;
	}

	/**
	 * For calling rest get call with headers and basic auths
	 * 
	 * @param url
	 * @param headers
	 * @return
	 */
	public Object callGetMethod(String url, HashMap<String, String> headers) {
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("username", "password"));
		return restTemplate.exchange(url, HttpMethod.GET, null, Quote.class);
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
