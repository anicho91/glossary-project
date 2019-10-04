package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@EnableConfigServer
@SpringBootApplication
@RequestMapping(value = "/glossary")
public class ConfigServerApplication {

	//private ServiceLayer service;

	//generate constructor

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Definition createDefinition(@RequestBody Definition def){
		//return service.createDefinition(def);
		return def;
	}

	@GetMapping(value = "/term/{term}")
	@ResponseStatus
	public List<Definition> getDefinitions(@PathVariable String term){
		//List<Definition> defs = service.getDefinitions(term);
		//return defs;
	}




}
