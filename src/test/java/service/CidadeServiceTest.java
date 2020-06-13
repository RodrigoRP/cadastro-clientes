package service;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.repository.CidadeRepository;
import com.rodrigoramos.cadastroclientes.service.impl.CidadeServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CidadeServiceTest {

    @Mock
    private CidadeRepository cidadeRepository;

    @InjectMocks
    private CidadeServiceImpl cidadeService;


/*    @Test
    public void shouldSavedCidadeSuccessFully() {
        final Cidade cidade = new Cidade(null, "Lajeado", "RS");

        //given(cidadeRepository.findCidadeByEstado(cidade.getEstado())).willReturn(null);
        given(cidadeRepository.save(cidade)).willAnswer(invocation -> invocation.getArgument(0));

        Cidade savedCidade = cidadeService.save(cidade);

        assertThat(savedCidade);

        verify(cidadeRepository).save(any(Cidade.class));
    }*/


}
