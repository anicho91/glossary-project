package com.company.glossaryservice.util.feign;

import com.company.glossaryservice.dto.Definition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("definition-service")
public interface DefinitionClient {

    @GetMapping(value = "/definition/term/{term}")
    public List<Definition> getDefintionForTerm(@PathVariable String term);

    @PostMapping(value = "/definition")
    public Definition addDefinition(@RequestBody Definition definition);

    @GetMapping(value = "/definition/{id}")
    public Definition getDefinition(@PathVariable int id);

}
