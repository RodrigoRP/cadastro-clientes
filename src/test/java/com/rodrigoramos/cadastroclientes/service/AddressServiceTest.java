package com.rodrigoramos.cadastroclientes.service;

import com.rodrigoramos.cadastroclientes.model.Address;
import com.rodrigoramos.cadastroclientes.repository.CidadeRepository;
import com.rodrigoramos.cadastroclientes.service.exceptions.ObjectNotFoundException;
import com.rodrigoramos.cadastroclientes.service.impl.CidadeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    private CidadeRepository cidadeRepository;

    @InjectMocks
    private CidadeServiceImpl cidadeService;


    @Test
    public void shouldSavedCidadeSuccessFullyTest() {
        final Address address = new Address(null, "Lajeado", "RS");

        given(cidadeRepository.save(address)).willAnswer(invocation -> invocation.getArgument(0));

        Address savedAddress = cidadeService.save(address);

        assertThat(savedAddress).isNotNull();

        verify(cidadeRepository).save(any(Address.class));
    }

    @Test
    public void findCidadeByNomeTest() {

        final Address address = new Address(null, "Lajeado", "RS");

        given(cidadeRepository.findCidadeByNome(address.getNome())).willReturn(address);

        final Address expected = cidadeService.findCidadeByNome(address.getNome());

        assertThat(expected).isNotNull();
    }

    @Test
    public void findCidadeByEstadoTest() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address(null, "Lajeado", "RS"));

        given(cidadeRepository.findCidadeByEstado("RS")).willReturn(addresses);

        List<Address> expected = cidadeService.findCidadeByEstado("RS");

        assertEquals(expected, addresses);
    }

    @Test
    public void findCidadeByIdTest() {
        final Address address = new Address(null, "Lajeado", "RS");

        given(cidadeRepository.findById(address.getId())).willReturn(Optional.of(address));

        Address expected = cidadeService.findById(address.getId());

        assertEquals(expected, address);
    }

    @Test
    public void shouldThrowErrorWhenFindClienteByIdTest() {
        final Address address = new Address(null, "Lajeado", "RS");

        assertThrows(ObjectNotFoundException.class, () -> cidadeService.findById(2L));

        verify(cidadeRepository, never()).findById(22L);
    }


}
