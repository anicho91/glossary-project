package com.company.glossaryservice.service;

import com.company.glossaryservice.dto.GlossaryViewModel;
import com.company.glossaryservice.util.feign.DefinitionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    GlossaryViewModel gvm;

    DefinitionClient client;

    @Autowired
    public ServiceLayer(GlossaryViewModel gvm, DefinitionClient client) {
        this.gvm = gvm;
        this.client = client;
    }






    /*
    Add Method

    Get List
     */

    public GlossaryViewModel addTermDefintion(GlossaryViewModel gvm) {
        // grab id from client first
//        client.getDefinition(gvm.getId());
        if (client.getDefintionForTerm(gvm.getTerm()) != null) {
//            client
            return null;
        }
        // if statement
        return null;
    }

    public GlossaryViewModel getTermDefinitions(String term) {
        return null;
    }
}
