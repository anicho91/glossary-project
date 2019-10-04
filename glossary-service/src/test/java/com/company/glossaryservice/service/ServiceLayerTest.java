package com.company.glossaryservice.service;

import com.company.glossaryservice.dto.GlossaryViewModel;
import com.company.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    private ServiceLayer service;
    private DefinitionClient client;
    private GlossaryViewModel gvm;
    // No ViewModel

    @Before
    public void setUp() throws Exception {
        setUpServiceMock();
        setUpClientMock();

        service = new ServiceLayer(gvm, client);
    }

    // HELPER METHODS
    private void setUpServiceMock() {
        gvm = mock(gvm.class)
    }

    @Test
    public void addTermDefintion() {
    }
}