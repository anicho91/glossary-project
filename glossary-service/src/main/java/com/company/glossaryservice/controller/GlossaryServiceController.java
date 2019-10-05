package com.company.glossaryservice.controller;

import com.company.glossaryservice.dto.Definition;
import com.company.glossaryservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/glossary")
public class GlossaryServiceController {

    private ServiceLayer service;

    @Autowired
    public GlossaryServiceController(ServiceLayer service) {
        this.service = service;
    }

    //post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Definition createDefinition(@RequestBody Definition definition){
        return service.addTermDefintion(definition);
    }

    //get
    @GetMapping(value = "/term/{term}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Definition> getDefinitionsByTerm(@PathVariable String term){
        return service.getTermDefinitions(term);
    }
}
