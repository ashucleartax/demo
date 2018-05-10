package com.example.demo;

import com.example.demo.entity.Demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	protected TestRestTemplate restTemplate;

	public ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void contextLoads() {
	}

	@Test
	public void health(){
		ResponseEntity<String> entity =
				restTemplate.getForEntity("/ping", String.class);
		Assert.isTrue(entity.getBody().equals("pong"), "Health check Success");
	}

    public static Demo getRandomDemoEntity(){

        return Demo.builder()
                .externalId(UUID.randomUUID().toString())
                .build();
    }


}
