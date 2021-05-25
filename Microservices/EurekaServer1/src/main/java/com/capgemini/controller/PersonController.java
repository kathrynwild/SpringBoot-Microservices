package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.beans.Person;

@RestController
public class PersonController {
	
	@Autowired
	private RestTemplate restTemplate;

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@RequestMapping(path="/persondetails", params={"personid"})
	public String getPersonDetails(@RequestParam String personid, Model m){
		
		Person p = restTemplate.getForObject("http://person-service/person/" + personid, Person.class);
		m.addAttribute("person", p);

		return "console";
	}

}
