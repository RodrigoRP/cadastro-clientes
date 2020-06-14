package com.rodrigoramos.cadastroclientes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodrigoramos.cadastroclientes.controller.impl.ClienteControllerImpl;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.service.impl.ClienteServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(controllers = ClienteControllerImpl.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteServiceImpl clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Cliente> clienteList;

    @BeforeEach
    public void setUp() {
        this.clienteList = new ArrayList<>();
        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        this.clienteList.add(new Cliente(null, "Maria da Silva", "12312", "M", Instant.now(), 88, cidade));
        this.clienteList.add(new Cliente(null, "Carlos da Silva", "1233", "M", Instant.now(), 88, cidade));
        this.clienteList.add(new Cliente(null, "Ricardo da Silva", "123", "M", Instant.now(), 88, cidade));

    }

    @Test
    public void shouldFetchAllClientes() throws Exception {

    //    given(clienteService.findAll()).willReturn(clienteList);
/*
        this.mockMvc.perform(get("/cadastro-clientes/v1/cliente/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(clienteList.size())));*/
    }


}
