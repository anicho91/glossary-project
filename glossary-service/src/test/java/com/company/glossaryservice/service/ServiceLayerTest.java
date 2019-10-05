package com.company.glossaryservice.service;

import com.company.glossaryservice.dto.Definition;
import com.company.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


    }

    // client = mock(Definition.class)

    @Test
    public void addTermDefintion() {
    }
}