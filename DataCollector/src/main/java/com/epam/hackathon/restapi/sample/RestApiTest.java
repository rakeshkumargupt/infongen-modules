/**
 * 
 */
package com.epam.hackathon.restapi.sample;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.hackathon.restapi.util.RestCallUtil;

/**
 * @author Rakesh_Gupta
 *
 */
@Component
public class RestApiTest {

	@Autowired
	private RestCallUtil restCallUtil;

	@PostConstruct
	public void testRest() {
		Object data = restCallUtil.testRestCall();
		System.out.println(data);
	}
}
