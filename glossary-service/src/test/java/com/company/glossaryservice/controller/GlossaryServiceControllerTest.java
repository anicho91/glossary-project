package com.company.glossaryservice.controller;

import com.company.glossaryservice.dto.Definition;
import com.company.glossaryservice.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(GlossaryServiceController.class)
public class GlossaryServiceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createDefinition() throws Exception{
        List<String> gvmList = new ArrayList<>();
        gvmList.add("test1");
        gvmList.add("test2");
        Definition gvm = new Definition();
        gvm.setDefinition("Definition");
        gvm.setTerm("Test3");

        String inputJson = mapper.writeValueAsString(gvm);

        Definition outGvm = new Definition();
        outGvm.setId(1);
        outGvm.setDefinition("Definition");
        outGvm.setTerm("Test3");

        String outputJson = mapper.writeValueAsString(outGvm);

        when(serviceLayer.addTermDefintion(gvm)).thenReturn(outGvm);

        this.mockMvc.perform(post("/glossary").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getDefinitionsByTerm() throws Exception {
        Definition inDef = new Definition();
        inDef.setId(1);
        inDef.setDefinition("Definition");
        inDef.setTerm("Test3");


//        List<String> gvmList = new ArrayList<>();
//        gvmList.add("test1");
//        gvmList.add("test2");
     Definition outGvm = new Definition();
     outGvm.setId(2);
//        outGvm.setId(1);
        outGvm.setDefinition("Definition");
        outGvm.setTerm("Test3");

        List<Definition> dList = new ArrayList<>();
        dList.add(inDef);
        dList.add(outGvm);

        when(serviceLayer.getTermDefinitions("Test3")).thenReturn(dList);

        List<Definition> listChecker = new ArrayList<>();
        listChecker.addAll(dList);

//        Definition returnVal = outGvm;
        String outputjson = mapper.writeValueAsString(listChecker);
//        when(serviceLayer.getTermDefinitions("Test3")).thenReturn(gvmList);

        this.mockMvc.perform(get("/glossary/term/Test3"))
                .andDo(print())
                .andExpect(status().isFound())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputjson));
    }
}