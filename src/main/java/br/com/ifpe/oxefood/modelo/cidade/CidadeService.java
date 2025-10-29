package br.com.ifpe.oxefood.modelo.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public Cidade save(Cidade cidade) {
        cidade.setHabilitado(Boolean.TRUE);
        return cidadeRepository.save(cidade);
    }
    
    public List<Cidade> listarTodos() {
  
        return cidadeRepository.findAll();
    }

    public Cidade obterPorID(Long id) {

        return cidadeRepository.findById(id).get();
    }

    public void update(Long id, Cidade cidadeAnterior){

        Cidade cidade = cidadeRepository.findById(id).get();
        cidade.setEstado(cidadeAnterior.getEstado());
        cidade.setNome(cidadeAnterior.getNome());
        cidade.setQtdPopulacao(cidadeAnterior.getQtdPopulacao());
        cidade.setEhCapital(cidadeAnterior.getEhCapital());
        cidade.setDataFundacao(cidadeAnterior.getDataFundacao());

        cidadeRepository.save(cidade);
    }

    public Cidade delete(Long id){

        Cidade cidade = cidadeRepository.findById(id).get();
        cidade.setHabilitado(Boolean.FALSE);

        return cidadeRepository.save(cidade);
    }
}
