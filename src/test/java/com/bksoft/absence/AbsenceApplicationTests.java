package com.bksoft.absence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AbsenceApplicationTests {

	@LocalServerPort
	private Integer port;
	private String baseUrl = "http://localhost:";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void editAbsences_whenParameterIsValid_thenStatus200AndExpectedResult(){
		restTemplate.getForEntity(baseUrl + port + "/api/absence" + "/GL1/2022-12-05", String.class);

	}

}
