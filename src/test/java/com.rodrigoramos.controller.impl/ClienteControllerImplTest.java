package com.rodrigoramos.controller.impl;


import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ClienteControllerImplTest {
    //TODO: create the data Test generator class ClienteBuilder
   /* private static final String ENDPOINT_URL = "/clientes";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private ClienteControllerImpl clienteController;
    @MockBean
    private ClienteService clienteService;
    @MockBean
    private ClienteMapper clienteMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.clienteController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(clienteMapper.asDTOList(ArgumentMatchers.any())).thenReturn(ClienteBuilder.getListDTO());

        Mockito.when(clienteService.findAll()).thenReturn(ClienteBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(clienteMapper.asDTO(ArgumentMatchers.any())).thenReturn(ClienteBuilder.getDTO());

        Mockito.when(clienteService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(ClienteBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(clienteService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(clienteService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(clienteMapper.asEntity(ArgumentMatchers.any())).thenReturn(ClienteBuilder.getEntity());
        Mockito.when(clienteService.save(ArgumentMatchers.any(Cliente.class))).thenReturn(ClienteBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(ClienteBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(clienteService, Mockito.times(1)).save(ArgumentMatchers.any(Cliente.class));
        Mockito.verifyNoMoreInteractions(clienteService);
    }

*//*    @Test
    public void update() throws Exception {
        Mockito.when(clienteMapper.asEntity(ArgumentMatchers.any())).thenReturn(ClienteBuilder.getEntity());
        Mockito.when(clienteService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(ClienteBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(ClienteBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(clienteService, Mockito.times(1)).update(ArgumentMatchers.any(Cliente.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(clienteService);
    }*//*

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(clienteService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(clienteService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(clienteService);
    }
}*/
}