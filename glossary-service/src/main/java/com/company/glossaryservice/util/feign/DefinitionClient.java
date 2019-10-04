package com.company.glossaryservice.util.feign;

import com.company.glossaryservice.dto.GlossaryViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("definition-service")
public interface DefinitionClient {

    @GetMapping(value = "/definition/term/{term}")
    public List getDefintionForTerm(@PathVariable String term);

    @PostMapping(value = "/defintion")
    public GlossaryViewModel addDefinition(@RequestBody GlossaryViewModel gvm);

    @GetMapping(value = "/defintion/{id}")
    public GlossaryViewModel getDefinition(@PathVariable int id);

}
