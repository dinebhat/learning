package com.dfte.oracle.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OracleRpaServiceImpl implements OracleRpaService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${uipath.orchestrator.url}")
	String orchestratorUrl;
	
	@Value("${uipath.orchestrator.auth.endpoint}")
	String authEndpoint;
	
	@Value("${uipath.orchestrator.robot.endpoint}")
	String robotEndpoint;
	
	@Value("${uipath.orchestrator.username}")
	String userName;
	
	@Value("${uipath.orchestrator.password}")
	String password;

	/**
	 * @author naichowdhury
	 * method returns the status of all the
	 * rpa job statuses
	 * @return the status of rpa bot job
	 */
	@Override
	public String getRpaJobStatus() {

		String authToken = getAuthToken();
		HttpHeaders robotHeaders = new HttpHeaders();
		robotHeaders.setBearerAuth(authToken);
		HttpEntity<String> botEntity = new HttpEntity<String>("", robotHeaders);
		ResponseEntity<String> response = restTemplate.exchange(orchestratorUrl+robotEndpoint, HttpMethod.GET, botEntity, String.class);
		String botResponse = response.getBody();
		return botResponse;
	}
	
	/**
	 * @author naichowdhury
	 * to get the authorization bearer token
	 * for communicating with the uipath orchestrator
	 * @return authorization token
	 */
	public String getAuthToken() {
		
		JSONObject authRequest = new JSONObject();
		// requestBody.put("tenancyName", requestBody);
		authRequest.put("usernameOrEmailAddress", userName);
		authRequest.put("password", password);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(authRequest.toString(), headers);
		String authResponse = restTemplate.postForObject(orchestratorUrl+authEndpoint, entity, String.class);

		JSONObject authResponseJson = new JSONObject(authResponse);
		String authToken = authResponseJson.getString("result");
		
		return authToken;
	}

}
