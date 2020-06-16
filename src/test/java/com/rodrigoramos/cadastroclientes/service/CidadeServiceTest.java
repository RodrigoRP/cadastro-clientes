package com.rodrigoramos.cadastroclientes.service;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.repository.CidadeRepository;
import com.rodrigoramos.cadastroclientes.service.impl.CidadeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CidadeServiceTest {

    @Mock
    private CidadeRepository cidadeRepository;

    @InjectMocks
    private CidadeServiceImpl cidadeService;


    @Test
    public void shouldSavedCidadeSuccessFully() {
        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        given(cidadeRepository.save(cidade)).willAnswer(invocation -> invocation.getArgument(0));

        Cidade savedCidade = cidadeService.save(cidade);

        assertThat(savedCidade).isNotNull();

        verify(cidadeRepository).save(any(Cidade.class));
    }

    @Test
    public void findCidadeByNome() {

        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        given(cidadeRepository.findCidadeByNome(cidade.getNome())).willReturn(cidade);

        final Cidade expected = cidadeService.findCidadeByNome(cidade.getNome());

        assertThat(expected).isNotNull();
    }

    @Test
    public void findCidadeByEstado() {
        List<Cidade> cidades = new ArrayList<>();
        cidades.add(new Cidade(null, "Lajeado", "RS"));

        given(cidadeRepository.findCidadeByEstado("RS")).willReturn(cidades);

        List<Cidade> expected = cidadeService.findCidadeByEstado("RS");

        assertEquals(expected, cidades);
    }


}
