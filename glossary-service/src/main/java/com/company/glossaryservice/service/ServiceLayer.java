package com.company.glossaryservice.service;

import com.company.glossaryservice.dto.GlossaryViewModel;
import com.company.glossaryservice.util.feign.DefinitionClient;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceLayer {

    GlossaryViewModel service;

    DefinitionClient client;

    @Autowired
    public ServiceLayer(GlossaryViewModel service, DefinitionClient client) {
        this.service = service;
        this.client = client;
    }

    /*
    Add Method
    Get List
     */
}
