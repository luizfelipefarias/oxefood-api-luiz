package br.com.ifpe.oxefood.modelo.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
     public Estado save(Estado estado) {

        estado.setHabilitado(Boolean.TRUE);
        return estadoRepository.save(estado);
    }

    public List<Estado> listarTodos() {

        return estadoRepository.findAll();
    }

    public Estado obterPorID(Long id) {

        return estadoRepository.findById(id).get();
    } 

    @Transactional
    public void update(Long id, Estado estadoAlterado) {

        Estado estado = estadoRepository.findById(id).get();
        estado.setNome(estadoAlterado.getNome());
        estado.setSigla(estadoAlterado.getSigla());

        estadoRepository.save(estado);
    }

    public Estado delete(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estado.setHabilitado(Boolean.FALSE);

        return estadoRepository.save(estado);
    }



}
