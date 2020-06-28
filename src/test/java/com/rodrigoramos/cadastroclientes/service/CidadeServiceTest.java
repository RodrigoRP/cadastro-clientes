package com.rodrigoramos.cadastroclientes.service;

import com.rodrigoramos.cadastroclientes.model.Cidade;
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
public class CidadeServiceTest {

    @Mock
    private CidadeRepository cidadeRepository;

    @InjectMocks
    private CidadeServiceImpl cidadeService;


    @Test
    public void shouldSavedCidadeSuccessFullyTest() {
        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        given(cidadeRepository.save(cidade)).willAnswer(invocation -> invocation.getArgument(0));

        Cidade savedCidade = cidadeService.save(cidade);

        assertThat(savedCidade).isNotNull();

        verify(cidadeRepository).save(any(Cidade.class));
    }

    @Test
    public void findCidadeByNomeTest() {

        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        given(cidadeRepository.findCidadeByNome(cidade.getNome())).willReturn(cidade);

        final Cidade expected = cidadeService.findCidadeByNome(cidade.getNome());

        assertThat(expected).isNotNull();
    }

    @Test
    public void findCidadeByEstadoTest() {
        List<Cidade> cidades = new ArrayList<>();
        cidades.add(new Cidade(null, "Lajeado", "RS"));

        given(cidadeRepository.findCidadeByEstado("RS")).willReturn(cidades);

        List<Cidade> expected = cidadeService.findCidadeByEstado("RS");

        assertEquals(expected, cidades);
    }

    @Test
    public void findCidadeByIdTest() {
        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        given(cidadeRepository.findById(cidade.getId())).willReturn(Optional.of(cidade));

        Cidade expected = cidadeService.findById(cidade.getId());

        assertEquals(expected, cidade);
    }

    @Test
    public void shouldThrowErrorWhenFindClienteByIdTest() {
        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        assertThrows(ObjectNotFoundException.class, () -> cidadeService.findById(2L));

        verify(cidadeRepository, never()).findById(22L);
    }


}
