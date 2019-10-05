package com.company.glossaryservice.service;

import com.company.glossaryservice.dto.Definition;
import com.company.glossaryservice.util.feign.DefinitionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

//    Definition gvm;

    DefinitionClient client;

    @Autowired
    public ServiceLayer(DefinitionClient client) {
        this.client = client;
    }

    // ======================================================


    /*
    The definition must be family friendly. It cannot contain any
    of the following words (case insensitive), however these
    words may exist within other words
    - darn
    - heck (however, heckler and checkmate are allowed, for example)
    - drat (however, dehydrated is allowed, for example)
    - jerk
    - butt (however, buttress is allowed, for example)

     */

    public Definition addTermDefintion(Definition definition) {
        // grab id from client first
        List<String> badWordList = new ArrayList<>();
        badWordList.add("darn");
        badWordList.add("heck");
        badWordList.add("drat");
        badWordList.add("jerk");
        badWordList.add("butt");
        if (badWordList.contains(definition.getDefinition())) {
            throw new IllegalArgumentException("The definition must be family friendly");
        } else {
            return client.addDefinition(definition);
        }

    }

    // ======================================================

    public List<Definition> getTermDefinitions(String term) {

        return client.getDefintionForTerm(term);
    }
}
