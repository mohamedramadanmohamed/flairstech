package com.flairstech.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.flairstech.assessment.services.CountryService;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AssessmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser
class AssessmentApplicationTests {

	
	private final int port=8081;

	@Autowired
	private TestRestTemplate restTemplate;

	
	@MockBean
	private CountryService countryService;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	@Test
	public void testNonExistentCountryCode() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/BDI", HttpMethod.GET,
				entity, String.class);
		assertEquals(500, response.getStatusCodeValue());
		assertTrue(response.getBody().contains("INVALID COUNTRY CODE"));
	}
	
	@Test
	public void testDataBaseIsDown() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/", HttpMethod.GET,
				entity, String.class);
		System.err.println(response.getBody());
		assertEquals(500, response.getStatusCodeValue());
		assertTrue(response.getBody().contains("INTERNAL ERROR"));
	}
	
}
