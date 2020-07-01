package com.rodrigoramos.cadastroclientes.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodrigoramos.cadastroclientes.dto.AddressDTO;
import com.rodrigoramos.cadastroclientes.dto.ClienteDTO;
import com.rodrigoramos.cadastroclientes.model.Address;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.repository.ClienteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteControllerTest {

    private final String BASE_URL = "/cadastro-clientes/v1/cliente";

    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ClienteRepository mockRepository;

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }


    @Test
    public void buscar_id_200() throws Exception {
        final Address address = new Address(null, "Lajeado", "RS");
        final Cliente cliente = new Cliente(1L, "Pedro da Silva", "123123", "M",
                LocalDate.of(1960, Month.JANUARY, 1), 88, address);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(cliente));

        mockMvc.perform(get(BASE_URL + "/1"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nomeCompleto", is("Pedro da Silva")))
                .andExpect(jsonPath("$.cpf", is("123123")))
                .andExpect(jsonPath("$.sexo", is("M")));

        verify(mockRepository, times(1)).findById(1L);
    }

    @Test
    public void find_nomeCompleto_200() throws Exception {
        final Address address = new Address(null, "Lajeado", "RS");
        final Cliente cliente = new Cliente(1L, "Pedro", "123123", "M",
                LocalDate.of(1960, Month.JANUARY, 1), 88, address);

        when(mockRepository.findClienteByNomeCompleto(cliente.getNomeCompleto())).thenReturn(Optional.of(cliente));

        mockMvc.perform(get(BASE_URL + "/nome/" + cliente.getNomeCompleto()))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nomeCompleto", is("Pedro")))
                .andExpect(jsonPath("$.cpf", is("123123")))
                .andExpect(jsonPath("$.sexo", is("M")));

        verify(mockRepository, times(1)).findClienteByNomeCompleto(cliente.getNomeCompleto());
    }

    @Test
    public void find_all_200() throws Exception {
        List<Cliente> clienteList = new ArrayList<>();
        final Address address = new Address(null, "Lajeado", "RS");
        final Cliente cliente1 = new Cliente(1L, "Pedro", "123123", "M",
                LocalDate.of(1960, Month.JANUARY, 1), 88, address);
        final Cliente cliente2 = new Cliente(2L, "Maria", "123123", "F",
                LocalDate.of(1960, Month.JANUARY, 1), 88, address);

        clienteList.add(cliente1);
        clienteList.add(cliente2);

        when(mockRepository.findAll()).thenReturn(clienteList);

        mockMvc.perform(get(BASE_URL + "/"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nomeCompleto", is("Pedro")))
                .andExpect(jsonPath("$[0].cpf", is("123123")))
                .andExpect(jsonPath("$[0].sexo", is("M")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nomeCompleto", is("Maria")))
                .andExpect(jsonPath("$[1].cpf", is("123123")))
                .andExpect(jsonPath("$[1].sexo", is("F")));

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    public void deletar_200() throws Exception {
        final Address address = new Address(null, "Lajeado", "RS");
        final Cliente cliente = new Cliente(1L, "Pedro", "123123", "M",
                LocalDate.of(1960, Month.JANUARY, 1), 88, address);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(cliente));

        mockMvc.perform(delete(BASE_URL + "/1"))
                .andExpect(status().isNoContent());

        verify(mockRepository, times(1)).deleteById(1L);
    }


    @Test
    public void criar_200_v2() throws Exception {
        final ClienteDTO dto = new ClienteDTO("Pedro", "123123", "M",
                LocalDate.of(1960, Month.JANUARY, 1), 88, new AddressDTO( "Lajeado", "RS"));
        final Cliente cliente = new Cliente(1L, "Pedro", "123123", "M",
                LocalDate.now(), 88, new Address(null, "Lajeado", "RS"));

        when(mockRepository.save(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post(BASE_URL + "/")
                .content(objectMapper.writeValueAsString(dto))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(mockRepository, times(1)).save(any(Cliente.class));
    }

}
