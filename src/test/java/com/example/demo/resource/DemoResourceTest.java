package com.example.demo.resource;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;

/**
 * Created by ashutoshpandey on 11/05/18.
 */
public class DemoResourceTest extends DemoApplicationTests {

    @Test
    public void createDemoTest(){

        Demo demoRequest = getRandomDemoEntity();
        ResponseEntity<Demo> response = restTemplate.postForEntity("/demo", demoRequest, Demo.class);

        Assert.assertTrue(response.getStatusCode() == HttpStatus.CREATED);
        Demo responseDemo = response.getBody();
        Assert.assertTrue(demoRequest.getExternalId().equals(responseDemo.getExternalId()));

    }

    @Test
    public void getDemoTest(){

        Demo demoRequest = getRandomDemoEntity();
        ResponseEntity<Demo> response = restTemplate.postForEntity("/demo", demoRequest, Demo.class);

        Assert.assertTrue(response.getStatusCode() == HttpStatus.CREATED);

        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add("" , "");


        ResponseEntity<Demo> getDemoResponseEntity = restTemplate.exchange(
                "/demo/" + demoRequest.getExternalId(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Demo.class);
        System.out.println("ASHU "+ getDemoResponseEntity);
        Demo getDemoResponse = getDemoResponseEntity.getBody();
        Assert.assertTrue(demoRequest.getExternalId().equals(getDemoResponse.getExternalId()));


    }
}
