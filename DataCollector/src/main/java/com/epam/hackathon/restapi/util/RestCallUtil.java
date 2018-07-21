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

import com.epam.hackathon.restapi.model.ResponseDocuments;

/**
 * @author Rakesh_Gupta
 *
 */
@Service
public class RestCallUtil {

	static String auth = "Bearer eyJraWQiOiJWbUZEN0pIU2ZEeE14K05wakZiS1hoVXEwOGVOenBWbUcrNHluMWdseUkwPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1YmE0YThjMi1kNWYwLTRiOTQtOGMxMi0yYmNkYTVjYzU2YTAiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6InNlYXJjaFwvcmVhZCBzZWFyY2hcL2FsbCIsImF1dGhfdGltZSI6MTUzMjE4NTE5MywiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfZjNBNW44Y2xJIiwiZXhwIjoxNTMyMTg4NzkzLCJpYXQiOjE1MzIxODUxOTMsInZlcnNpb24iOjIsImp0aSI6IjA2MjI3ZGE3LWRkZjQtNDU3Zi05NWNjLTczNmQ2ZDZiOGIxYiIsImNsaWVudF9pZCI6IjI4NnJpaHZsdGF2ajVrOWhibHFjamlqa3BsIiwidXNlcm5hbWUiOiJFUEFNX3N3eHdlcW1nMDBhQmpMNzd0VjRMc2c9PSJ9.MOvRSqQYAHhaRiVmOfnFzf8DxVXsdTp0ckd4BxjZTdAA1ny7-G4IzTvEC4u3FpKQ998MLzWlgbXnhJl-8xecdg_fix47K0hk1oqBYzQkhuQKYgJ3rlmwmsa2ZgLYm5u7odKD2QezKMHuHhb_SGQuTl-hgZFc61ww5viRjfJjjSJ0Ox_welmpcbseebvezjf-xV-qR019XqTIFdklOwPD9nZfrjh-S1fj35kP3vuEx6HCeZQ9xG5GKUyLNa8kJeg7qf4ae6Hh-CXH2hbrdGmJ3AywVndl0bC7pdF6bQcnEn2ndn0GK3G1mnUiA3le49DAsmaM3NHgDWUq_tn2dvKxFQ";
	String xAPI = "sEEi7skqmF7oWIjmkz9jL8z7Dz2Yt3GAaXcErfpi";
	String uri = "http://igen-api.qa.infongen.cc/v2/searches/135149c8-21bb-4b8a-96e2-6443288e4029/results?limit=5&show_options=documents";

	@Autowired
	RestTemplate restTemplate;

	HttpHeaders createHeaders() {

		return new HttpHeaders() {
			{

				String authHeader = new String(auth);
				set("Authorization", authHeader);
				set("x-api-key", "sEEi7skqmF7oWIjmkz9jL8z7Dz2Yt3GAaXcErfpi");
				set("Content-Type", "application/json");
			}
		};
	}

	public ResponseDocuments callGetMethod(String uri) {

		HttpEntity<String> entity = new HttpEntity<>(createHeaders());
		return restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseDocuments.class).getBody();

	}
	
	
	

	public String callGetMethodMock() {

		return "{\r\n" + 
				"    \"documents\": [\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Professional Industry Publications\",\r\n" + 
				"            \"contributor\": \"PaymentsSource\",\r\n" + 
				"            \"id\": \"7868254365\",\r\n" + 
				"            \"uri\": \"https://www.paymentssource.com/news/apple-pay-eviction-ad-is-p2ps-foot-in-the-door-for-bigger-payments?feed=00000157-2a59-dceb-aff7-bf7b8c720000\",\r\n" + 
				"            \"published_at\": \"2018-07-21T01:08:17.648Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Venmo LLC\",\r\n" + 
				"                                \"value\": \"100721433\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"PaymentsSource | Wallet\",\r\n" + 
				"            \"summary\": \"The commercial that shows a landlord using Apple Pay Cash and iMessage to pry rent out of a tenant is meant to elicit a chuckle, but it also shows how P2P providers must aggressively communicate the capabilities of their apps.\",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Private Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"private_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Internet Software & Services\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"451010\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financials\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"40\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Diversified financials\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"402010\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Banks\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"401010\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Satisfy\",\r\n" + 
				"                    \"name\": \"sentwordverbsofsatisfaction\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Satisfy\",\r\n" + 
				"                            \"value\": \"Verbs_Satisfy\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Bad\",\r\n" + 
				"                    \"name\": \"sentwordadjbad\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Bad\",\r\n" + 
				"                            \"value\": \"Adj_Bad\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Love\",\r\n" + 
				"                    \"name\": \"sentwordverbslove\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Love\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Love\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Paypal Holdings Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"100713494\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Venmo LLC\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"100721433\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Financial Services Topics\",\r\n" + 
				"                    \"name\": \"financialservices\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Products\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"1Productsameri\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Payment Cards\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"1creditcardsameri\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Emerging Card Technologies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"EmergiCardTechnol\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Mobile Payments\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Mobilepayments\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial Services Platforms\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"1Technology\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Mobile Financial Services\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1Mobilefinancialservices\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Social Media Financial Services\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"1socialmediafinancialservices\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial Marketing\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1Marketing\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Advertising & Marketing in Financial Industry\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1Advertising\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Industries\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1Industriesameri\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Payments Industry\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1PaymentsIndustry\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Card Issuers\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"CardIssuers\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"PayPal, Inc.\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"100331158\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Apple Pay 'eviction' ad is P2P's foot in the door for bigger payments\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Aggregated News\",\r\n" + 
				"            \"contributor\": \"Yahoo! News\",\r\n" + 
				"            \"id\": \"7866708424\",\r\n" + 
				"            \"uri\": \"https://in.news.yahoo.com/apple-watch-fitbit-could-see-104040725.html\",\r\n" + 
				"            \"published_at\": \"2018-07-20T12:03:38.194Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Apple Inc\",\r\n" + 
				"                                \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                                \"value\": \"100000671\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Shares\",\r\n" + 
				"                                \"Revenue\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"negative\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Revenue\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"Yahoo India News | Tech\",\r\n" + 
				"            \"summary\": \"Smartwatches could be the latest victim of trade war sparring between the US and China with new tariffs hitting the Apple Watch and Fitbit activity trackers. The $200bn list of tariffs could see the original Apple Watch face a 10pc tariff under an obscure tax code as part of a growing trade war. While smartphones and laptops have so far been spared, smartwatch devices assembled in China, such as the original Apple Watch and Fitbit Charge, Charge HR and Surge models could all be hit by the...\",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Macro\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"macro\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Taxes\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"tax\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Private Companies\",\r\n" + 
				"                            \"value\": \"private_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"China\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"CN\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Computers & Peripherals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"452020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Discretionary\",\r\n" + 
				"                            \"value\": \"25\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Household Durables\",\r\n" + 
				"                            \"value\": \"252010\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Congress\",\r\n" + 
				"                    \"name\": \"congress\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Presidents & World Leaders\",\r\n" + 
				"                            \"value\": \"presidents\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Donald Trump\",\r\n" + 
				"                            \"value\": \"DonaldTrump1\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Down\",\r\n" + 
				"                    \"name\": \"sentwordverbsdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Down\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Down\",\r\n" + 
				"                    \"name\": \"sentwordnoundown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Noun_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Apple Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                            \"value\": \"100000671\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Sonos Inc\",\r\n" + 
				"                            \"value\": \"100721305\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Corporate Topics\",\r\n" + 
				"                    \"name\": \"corptopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Market Forces\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"marketforces\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Pricing\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"pricingchanges\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Price Increase\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"pricingincrease\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Asia Excluding Japan\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"AXJ\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Tech Topics\",\r\n" + 
				"                    \"name\": \"techtopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Immersive Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"TechnologyTopics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Wearable Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Wearabletechnology\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Apple Watch and Fitbit could see price rise in US tariff standoff\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Business & Financial Publications\",\r\n" + 
				"            \"contributor\": \"The Financial Times\",\r\n" + 
				"            \"id\": \"7865641544\",\r\n" + 
				"            \"uri\": \"https://www.ft.com/content/35dd9ef4-8bc5-11e8-bf9e-8771d5404543\",\r\n" + 
				"            \"published_at\": \"2018-07-20T02:55:55.857Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Taiwan Semiconductor Manufacturing Co Ltd\",\r\n" + 
				"                                \"display_value_short\": \"2330:TPE\",\r\n" + 
				"                                \"value\": \"100036566\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Guidance\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"Financial Times | Mergermarket\",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Taiwan\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"TW\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Computers & Peripherals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"452020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Semiconductors & Semiconductor Equipment\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"453010\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Apple Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                            \"value\": \"100000671\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Taiwan Semiconductor Manufacturing Co Ltd\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"2330:TPE\",\r\n" + 
				"                            \"value\": \"100036566\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Asia Excluding Japan\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"AXJ\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Tech Topics\",\r\n" + 
				"                    \"name\": \"techtopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Electronics\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"ConsumerElectronics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Smartphones\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Smartphones\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Apple supplier TSMC jumps after smartphone outlook lifts\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Major News Publications\",\r\n" + 
				"            \"contributor\": \"CNBC\",\r\n" + 
				"            \"id\": \"7864188493\",\r\n" + 
				"            \"uri\": \"https://www.cnbc.com/2018/07/19/amazon-is-hot-on-apples-trail-in-the-race-to-1-trillion.html\",\r\n" + 
				"            \"published_at\": \"2018-07-19T15:38:56.076Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Amazon.Com Inc\",\r\n" + 
				"                                \"display_value_short\": \"AMZN:NMS\",\r\n" + 
				"                                \"value\": \"100023164\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"CNBC | Top News and Analysis\",\r\n" + 
				"            \"summary\": \"Amazon may be in second place, but it has better odds to cross the finish line first in getting to a $1 trillion market cap, market watchers say.\",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Event Driven Investments\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"eventdriveninvestments\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Positive Business Fundamentals\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"pbf\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"financial\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Discretionary\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"25\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Internet & Catalog Retail\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"255020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Computers & Peripherals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"452020\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Apple Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                            \"value\": \"100000671\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Amazon.Com Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AMZN:NMS\",\r\n" + 
				"                            \"value\": \"100023164\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Corporate Topics\",\r\n" + 
				"                    \"name\": \"corptopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Major Corporate News\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"majornewstopics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Initial Public Offering\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"ipo\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Corporate Actions\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"corporateactions\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Amazon is hot on Apple’s trail in the race to $1 trillion\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Aggregated News\",\r\n" + 
				"            \"contributor\": \"Yahoo! News\",\r\n" + 
				"            \"id\": \"7863293593\",\r\n" + 
				"            \"uri\": \"https://in.news.yahoo.com/iphone-rumours-know-far-apple-092111839.html\",\r\n" + 
				"            \"published_at\": \"2018-07-19T09:41:04.613Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Apple Inc\",\r\n" + 
				"                                \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                                \"value\": \"100000671\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"negative\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"Yahoo India News | Tech\",\r\n" + 
				"            \"summary\": \"Amid the usual fanfare, Apple is expected to reveal its latest iPhone developments later this year with the launch of an update to its premium iPhone X and two new smartphones including a smaller model and its largest model ever. The California tech giant normally keeps its plans tightly under wraps, and this year is no exception. \",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Outlook\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"outlook\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Company Rumor\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"gossip\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"financial\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings Positive\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earningsplus\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Sales Figures\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"salesfigs\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Commodities\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"commodities\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Metals\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"metal\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Precious Metals\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"preciousm\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Private Companies\",\r\n" + 
				"                            \"value\": \"private_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Computers & Peripherals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"452020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"IT Consulting & Services\",\r\n" + 
				"                            \"value\": \"451020\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Bad\",\r\n" + 
				"                    \"name\": \"sentwordadjbad\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Bad\",\r\n" + 
				"                            \"value\": \"Adj_Bad\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Love\",\r\n" + 
				"                    \"name\": \"sentwordverbslove\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Love\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Love\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Down\",\r\n" + 
				"                    \"name\": \"sentwordverbsdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Down\",\r\n" + 
				"                    \"name\": \"sentwordnoundown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Down\",\r\n" + 
				"                            \"value\": \"Noun_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Apple Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                            \"value\": \"100000671\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Huawei Technologies Co Ltd\",\r\n" + 
				"                            \"value\": \"100325157\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Corporate Topics\",\r\n" + 
				"                    \"name\": \"corptopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Negative Company News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NegativeCompanyNews\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Company Rumor\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"CompanyRumor\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Major Product News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"ProductNewsTopics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Product Announcements\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"product\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Products & Services\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"productsandservices\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Major Corporate News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"majornewstopics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings Positive\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earningsplus\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"State\",\r\n" + 
				"                    \"name\": \"state\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"California\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"CA\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Tech Topics\",\r\n" + 
				"                    \"name\": \"techtopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Electronics\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"ConsumerElectronics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Smartphones\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Smartphones\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Down\",\r\n" + 
				"                    \"name\": \"sentwordadjdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"iPhone rumours: What we know so far about Apple's new handsets\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Consumer Publications\",\r\n" + 
				"            \"contributor\": \"Extremetech\",\r\n" + 
				"            \"id\": \"7862061122\",\r\n" + 
				"            \"uri\": \"https://www.extremetech.com/computing/273734-apple-cant-handle-the-heat-severe-core-i9-throttling-found-on-new-macbook-pros\",\r\n" + 
				"            \"image_uri\": \"https://www.extremetech.com/wp-content/uploads/2016/10/AppleMacFeature-300x166.png\",\r\n" + 
				"            \"published_at\": \"2018-07-18T21:25:40.004Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Apple Inc\",\r\n" + 
				"                                \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                                \"value\": \"100000671\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Revenue\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"negative\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"ExtremeTech | News\",\r\n" + 
				"            \"summary\": \"Apple systems aren't immune to the laws of physics. This simple fact puts significant limits on the upgrade-option Core i9 CPU inside the latest MacBook Pros -- and suggests that Apple didn't do its due diligence when designing the CPUs. The post Apple Can’t Handle the Heat: Severe Core i9 Throttling Found on New MacBook Pros appeared first on ExtremeTech.\",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Computers & Peripherals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"452020\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Bad\",\r\n" + 
				"                    \"name\": \"sentwordadjbad\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Bad\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Bad\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Down\",\r\n" + 
				"                    \"name\": \"sentwordnoundown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Noun_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Love\",\r\n" + 
				"                    \"name\": \"sentwordverbslove\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Love\",\r\n" + 
				"                            \"value\": \"Verbs_Love\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Apple Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                            \"value\": \"100000671\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Down\",\r\n" + 
				"                    \"name\": \"sentwordverbsdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Tech Topics\",\r\n" + 
				"                    \"name\": \"techtopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Laptops\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Laptops\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Macbook Series | Apple\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"macbook\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Down\",\r\n" + 
				"                    \"name\": \"sentwordadjdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Apple Can’t Handle the Heat: Severe Core i9 Throttling Found on New MacBook Pros\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Investment News\",\r\n" + 
				"            \"contributor\": \"Investor's Business Daily\",\r\n" + 
				"            \"id\": \"7858843751\",\r\n" + 
				"            \"uri\": \"https://www.investors.com/market-trend/stock-market-today/consumer-tech-stocks-boost-nasdaq-why-apple-could-rise/?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+StockMarketTodayRss+%28Investor%27s+Business+Daily+-+Stock+Market+Today+RSS%29\",\r\n" + 
				"            \"published_at\": \"2018-07-17T17:34:58.026Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Netflix Inc\",\r\n" + 
				"                                \"display_value_short\": \"NFLX:NMS\",\r\n" + 
				"                                \"value\": \"100032759\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"negative\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Losses\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"Investor's Business Daily | Stock Market Today\",\r\n" + 
				"            \"summary\": \"The Nasdaq composite is commanding the market upside in stocks today. Fiber optic, chip equipment, homebuilding and consumer-oriented shares led. Apple is trailing some of its peers within the Dow Jones industrial average, yet the rally following a May 4 breakout remains fully intact. The post Consumer, Tech Stocks Boost Nasdaq; 3 Reasons Why Apple Could Rise Another 25% appeared first on Investor's Business Daily.\",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"financial\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Market\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"market\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Equity Indices\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"index\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Macro\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"macro\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Central Banks\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"cenbank\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Fed Interest Rate Policy\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"FedInterestRatePolicy\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Fixed Income\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"fixedincome\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Treasury Department US News\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"treasury\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Private Companies\",\r\n" + 
				"                            \"value\": \"private_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Pharmaceuticals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"352020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Discretionary\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"25\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Specialty Retail\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"255040\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Internet & Catalog Retail\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"255020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Textiles, Apparel & Luxury Goods\",\r\n" + 
				"                            \"value\": \"252030\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Health Care\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"35\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Industrials\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"20\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Industrial Conglomerates\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"201050\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Semiconductors & Semiconductor Equipment\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"453010\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Bad\",\r\n" + 
				"                    \"name\": \"sentwordadjbad\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Bad\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Bad\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Love\",\r\n" + 
				"                    \"name\": \"sentwordverbslove\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Love\",\r\n" + 
				"                            \"value\": \"Verbs_Love\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Down\",\r\n" + 
				"                    \"name\": \"sentwordverbsdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Down\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Down\",\r\n" + 
				"                    \"name\": \"sentwordnoundown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Down\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Noun_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Johnson & Johnson\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"JNJ:NYX\",\r\n" + 
				"                            \"value\": \"100005163\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Home Depot Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"display_value_short\": \"HD:NYX\",\r\n" + 
				"                            \"value\": \"100004582\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Netflix Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"NFLX:NMS\",\r\n" + 
				"                            \"value\": \"100032759\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Etsy Inc\",\r\n" + 
				"                            \"display_value_short\": \"ETSY:NMS\",\r\n" + 
				"                            \"value\": \"100708511\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Lululemon Athletica Inc\",\r\n" + 
				"                            \"display_value_short\": \"LULU:NMS\",\r\n" + 
				"                            \"value\": \"100303776\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"3M Company\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"display_value_short\": \"MMM:NYX\",\r\n" + 
				"                            \"value\": \"100006305\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"NVIDIA Corp\",\r\n" + 
				"                            \"display_value_short\": \"NVDA:NMS\",\r\n" + 
				"                            \"value\": \"100029544\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Momo S.A.\",\r\n" + 
				"                            \"value\": \"100622061\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Corporate Topics\",\r\n" + 
				"                    \"name\": \"corptopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Typically Excluded - All\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"exlusion\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Major Corporate News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"majornewstopics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Down\",\r\n" + 
				"                    \"name\": \"sentwordadjdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Down\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Consumer, Tech Stocks Boost Nasdaq; 3 Reasons Why Apple Could Rise Another 25%\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Professional Industry Publications\",\r\n" + 
				"            \"contributor\": \"Digit\",\r\n" + 
				"            \"id\": \"7858094081\",\r\n" + 
				"            \"uri\": \"https://www.digit.in/mobile-phones/apple-sold-less-than-a-million-iphones-in-first-half-of-2018-in-india-report-42261.html\",\r\n" + 
				"            \"image_uri\": \"https://static.digit.in/default/6b0992f246d517bb9e0537cba3c89a6d9355fd9e.jpeg\",\r\n" + 
				"            \"published_at\": \"2018-07-17T13:30:20.411Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Apple Inc\",\r\n" + 
				"                                \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                                \"value\": \"100000671\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Revenue\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"negative\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Revenue\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"OnePlus\",\r\n" + 
				"                                \"value\": \"100720837\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Samsung Electronics Co Ltd\",\r\n" + 
				"                                \"display_value_short\": \"SMSN:LIB\",\r\n" + 
				"                                \"value\": \"100087892\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"Digit | News\",\r\n" + 
				"            \"summary\": \"Two days ago it was reported that three Apple India executives have quit as the company looks to rejig its iPhone sales strategy in the country. Until now, there was foggy explanation on why the Cupertino-based giant wants to change its India strategy; a new development could clear the picture. According to a Bloomberg report, in India, where it has a market share of about 2 percent, Apple has sold just 3.2 million iPhones in 2017 and in the first half of 2018, fewer than a million devices have...\",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Private Companies\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"private_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"China\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"CN\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"India\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"IN\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"South Korea\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"KR\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Computers & Peripherals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"452020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"IT Consulting & Services\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"451020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Discretionary\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"25\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Internet & Catalog Retail\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"255020\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Executives (new)\",\r\n" + 
				"                    \"name\": \"execs\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Neil Shah\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"NeilShah\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Tim Cook\",\r\n" + 
				"                            \"value\": \"TimothyCook\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Bad\",\r\n" + 
				"                    \"name\": \"sentwordadjbad\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Bad\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Bad\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Down\",\r\n" + 
				"                    \"name\": \"sentwordverbsdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Financial Services Topics\",\r\n" + 
				"                    \"name\": \"financialservices\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial Marketing\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1Marketing\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Branding in Financial Industry\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1Branding\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Branding Trends\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"1BrandingTrends\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Down\",\r\n" + 
				"                    \"name\": \"sentwordnoundown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Down\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Noun_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"HCL Infosystems Ltd\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"display_value_short\": \"EQHCL-INSYS:NSE\",\r\n" + 
				"                            \"value\": \"100262214\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Samsung Electronics Co Ltd\",\r\n" + 
				"                            \"display_value_short\": \"SMSN:LIB\",\r\n" + 
				"                            \"value\": \"100087892\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Apple Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                            \"value\": \"100000671\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Brightstar Information Technology Group Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"display_value_short\": \"BTSR:OTC\",\r\n" + 
				"                            \"value\": \"100028699\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"OnePlus\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"100720837\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Ingram Micro Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"100022657\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Corporate Topics\",\r\n" + 
				"                    \"name\": \"corptopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Management\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Management\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Top Ranking Executives\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"TopRankingExecutives\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Asia Excluding Japan\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"AXJ\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Tech Topics\",\r\n" + 
				"                    \"name\": \"techtopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Electronics\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"ConsumerElectronics\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Down\",\r\n" + 
				"                    \"name\": \"sentwordadjdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Down\",\r\n" + 
				"                            \"value\": \"Adj_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Apple sold less than a million iPhones in first half of 2018 in...\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Regional/Local\",\r\n" + 
				"            \"contributor\": \"The Centre Daily Times\",\r\n" + 
				"            \"id\": \"7855171139\",\r\n" + 
				"            \"uri\": \"https://www.centredaily.com/news/business/article214944875.html#navlink=SecList\",\r\n" + 
				"            \"published_at\": \"2018-07-16T08:44:22.425Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Amazon.Com Inc\",\r\n" + 
				"                                \"display_value_short\": \"AMZN:NMS\",\r\n" + 
				"                                \"value\": \"100023164\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"Centre Daily Times | News\",\r\n" + 
				"            \"summary\": \"So, two years ago she made the leap from Amazon to Eaze, becoming vice president of product at the 4-year-old San Francisco start-up, which operates an online cannabis marketplace. For decades, those looking to change the world arrived in Silicon Valley seeking the latest frontier: social media companies, gadget makers, delivery and transportation apps, e-commerce platforms. \",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Private Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"private_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"financial\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Sales Figures\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"salesfigs\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings Positive\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earningsplus\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Singapore\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"SG\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Health Care Technology\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"351030\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Internet Software & Services\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"451010\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Software\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"451030\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Discretionary\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"25\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Internet & Catalog Retail\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"255020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Auto Components\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"251010\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Industrials\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"20\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Professional Services\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"202020\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Health Care\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"35\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financials\",\r\n" + 
				"                            \"value\": \"40\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Capital Markets\",\r\n" + 
				"                            \"value\": \"402030\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"USFedAgency\",\r\n" + 
				"                    \"name\": \"usfedagency\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Drug Enforcement Administration\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"DrugEnforcementAdministration\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"City\",\r\n" + 
				"                    \"name\": \"city\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"San Francisco\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"SanFrancisco\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Love\",\r\n" + 
				"                    \"name\": \"sentwordverbslove\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Love\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Love\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Practice Areas\",\r\n" + 
				"                    \"name\": \"wcglobalpractices\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial Market Law\",\r\n" + 
				"                            \"value\": \"FinancialMarketLaw\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Venture Capital Law\",\r\n" + 
				"                            \"value\": \"wc_venturecapital\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Down\",\r\n" + 
				"                    \"name\": \"sentwordverbsdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Down\",\r\n" + 
				"                            \"value\": \"Verbs_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Financial Services Topics\",\r\n" + 
				"                    \"name\": \"financialservices\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Demographics\",\r\n" + 
				"                            \"value\": \"1Demographics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Wealth\",\r\n" + 
				"                            \"value\": \"1Wealth\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"The Wealthy\",\r\n" + 
				"                            \"value\": \"1wealthy\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Satisfy\",\r\n" + 
				"                    \"name\": \"sentwordverbsofsatisfaction\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Satisfy\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Verbs_Satisfy\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Good\",\r\n" + 
				"                    \"name\": \"sentwordadjgood\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Good\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Good\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Amazon.Com Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AMZN:NMS\",\r\n" + 
				"                            \"value\": \"100023164\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Lyft Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"100693748\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Electronic Arts\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"EA:NMS\",\r\n" + 
				"                            \"value\": \"100014396\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"August Home Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"100720827\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Groupon Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"display_value_short\": \"GRPN:NMS\",\r\n" + 
				"                            \"value\": \"100644153\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Omada Health Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"100721204\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"IDEO LLC\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"100673233\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Netflix Inc\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"display_value_short\": \"NFLX:NMS\",\r\n" + 
				"                            \"value\": \"100032759\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Google Inc\",\r\n" + 
				"                            \"display_value_short\": \"GOOG:NMS\",\r\n" + 
				"                            \"value\": \"100034212\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"500 Startups\",\r\n" + 
				"                            \"value\": \"100716777\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Alphabet Inc\",\r\n" + 
				"                            \"display_value_short\": \"GOOGL:NMS\",\r\n" + 
				"                            \"value\": \"100626051\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Nintendo Co Ltd\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"display_value_short\": \"7974:TYO\",\r\n" + 
				"                            \"value\": \"100209939\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Baker Technology Ltd\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"568:SIN\",\r\n" + 
				"                            \"value\": \"100275162\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Corporate Topics\",\r\n" + 
				"                    \"name\": \"corptopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Management\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Management\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Top Ranking Executives\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"TopRankingExecutives\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Major Corporate News\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"majornewstopics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings Positive\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"earningsplus\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"State\",\r\n" + 
				"                    \"name\": \"state\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"California\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"CA\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Asia Excluding Japan\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"AXJ\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"They worked at Apple, Amazon and Lyft. Now they’re working to get you stoned\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"category\": \"Aggregated News\",\r\n" + 
				"            \"contributor\": \"Yahoo! News\",\r\n" + 
				"            \"id\": \"7854898939\",\r\n" + 
				"            \"uri\": \"https://in.news.yahoo.com/apple-struggling-india-key-executives-042000439.html\",\r\n" + 
				"            \"published_at\": \"2018-07-16T06:16:34.5Z\",\r\n" + 
				"            \"sentiments\": [\r\n" + 
				"                {\r\n" + 
				"                    \"subject\": {\r\n" + 
				"                        \"display_name\": \"Company\",\r\n" + 
				"                        \"name\": \"company\",\r\n" + 
				"                        \"values\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"display_value\": \"Apple Inc\",\r\n" + 
				"                                \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                                \"value\": \"100000671\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"polarities\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"polarity\": \"negative\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"aspects\": [\r\n" + 
				"                                \"Revenue\"\r\n" + 
				"                            ],\r\n" + 
				"                            \"polarity\": \"positive\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"source\": \"Yahoo India News | Tech\",\r\n" + 
				"            \"summary\": \"Representational image of an iPhone. Apple is the richest phone brand in the world, but the same can not be said for its performance in India. While Apple CEO Tim Cook has repeatedly said that Apple is very \\\"bullish\\\" about India, it has remained a niche brand as its pricing keeps it out of the hands of most Indians. \",\r\n" + 
				"            \"tags\": [\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Investment Topics\",\r\n" + 
				"                    \"name\": \"traderdemo\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Financial\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"financial\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Sales Figures\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"salesfigs\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings Negative\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earningsminus\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"US Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"USCos\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Public Companies\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"public_co\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Up\",\r\n" + 
				"                    \"name\": \"sentwordadjup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Up\",\r\n" + 
				"                            \"relevancy\": \"Medium\",\r\n" + 
				"                            \"value\": \"Adj_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Country\",\r\n" + 
				"                    \"name\": \"country\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"United States of America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"US\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"India\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"IN\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Up\",\r\n" + 
				"                    \"name\": \"sentwordnounup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Up\",\r\n" + 
				"                            \"value\": \"Noun_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Industry Sector\",\r\n" + 
				"                    \"name\": \"gics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Information Technology\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"45\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Computers & Peripherals\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"452020\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Executives (new)\",\r\n" + 
				"                    \"name\": \"execs\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Tim Cook\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"TimothyCook\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Down\",\r\n" + 
				"                    \"name\": \"sentwordverbsdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Down\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Verbs_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Verbs_Up\",\r\n" + 
				"                    \"name\": \"sentwordverbsup\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Verbs_Up\",\r\n" + 
				"                            \"value\": \"Verbs_Up\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Noun_Down\",\r\n" + 
				"                    \"name\": \"sentwordnoundown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Noun_Down\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Noun_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Company\",\r\n" + 
				"                    \"name\": \"company\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Apple Inc\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"display_value_short\": \"AAPL:NMS\",\r\n" + 
				"                            \"value\": \"100000671\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Corporate Topics\",\r\n" + 
				"                    \"name\": \"corptopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Major Corporate News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"majornewstopics\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Management Changes\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Mgmtchng\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings News\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earn\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Earnings Negative\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"earningsminus\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Management\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"Management\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Top Ranking Executives\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"TopRankingExecutives\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Region\",\r\n" + 
				"                    \"name\": \"region\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Asia Excluding Japan\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"AXJ\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"North America\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"NAM\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Tech Topics\",\r\n" + 
				"                    \"name\": \"techtopics\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Consumer Electronics\",\r\n" + 
				"                            \"relevancy\": \"High\",\r\n" + 
				"                            \"value\": \"ConsumerElectronics\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"display_name\": \"Adj_Down\",\r\n" + 
				"                    \"name\": \"sentwordadjdown\",\r\n" + 
				"                    \"values\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"display_value\": \"Adj_Down\",\r\n" + 
				"                            \"value\": \"Adj_Down\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"headline\": \"Apple Is Struggling In India As Key Executives Leave, Sales Drop\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"documents_total\": 519\r\n" + 
				"}";

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
