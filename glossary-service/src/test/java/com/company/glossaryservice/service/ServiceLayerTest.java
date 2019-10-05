package com.company.glossaryservice.service;

import com.company.glossaryservice.dto.Definition;
import com.company.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    private ServiceLayer service;
    private DefinitionClient client;

    @Before
    public void setUp() throws Exception {

        setUpClientMock();


        service = new ServiceLayer(client);
    }

    // HELPER METHODS

    private void setUpClientMock() {
        client = mock(DefinitionClient.class);
        Definition definition = new Definition();
        definition.setId(1);
        definition.setTerm("Term");
        definition.setDefinition("Definition");

        Definition definition2 = new Definition();
        definition2.setId(1);
        definition2.setTerm("Term");
        definition2.setDefinition("Definition");

        List<Definition> dList = new ArrayList<>();
        dList.add(definition);
        dList.add(definition2);

        doReturn(definition).when(client).addDefinition(definition2);
        doReturn(dList).when(client).getDefintionForTerm("Term");
//        doReturn(dList).when(client).getDefinition(1);

    }

    // client = mock(Definition.class)

    @Test
    public void addTermDefintion() {
        Definition definition = new Definition();
        definition.setId(1);
        definition.setTerm("Term");
        definition.setDefinition("Definition");

        client.addDefinition(definition);

        assertNotNull(definition);


    }

    @Test
    public void getTermDefinitions() {
        Definition definition = new Definition();
        definition.setId(1);
        definition.setTerm("Term");
        definition.setDefinition("Definition");

        Definition definition2 = new Definition();
        definition2.setId(2);
        definition2.setTerm("Term");
        definition2.setDefinition("Definition");

        List<Definition> dList = new ArrayList<>();
        dList.add(definition);
        dList.add(definition2);

        List<Definition> fromService = service.getTermDefinitions("Term");

        assertEquals(fromService.size(), dList.size());


    }
}