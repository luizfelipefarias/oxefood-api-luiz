package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;
    
    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto){

        categoriaProduto.setHabilitado(Boolean.TRUE);
        return repository.save(categoriaProduto);
    }

    public List<CategoriaProduto> listarTodos(){
        
        return repository.findAll();
    }

    public CategoriaProduto obterPorId(Long id){

        return repository.findById(id).get();
    }

    public CategoriaProduto update(Long id, CategoriaProduto produtoNovo){
        
        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setDescricao(produtoNovo.getDescricao());

        return repository.save(categoriaProduto);
    }

    public CategoriaProduto delete(Long id){
        
        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setHabilitado(Boolean.FALSE);

        return repository.save(categoriaProduto);
    }
}
