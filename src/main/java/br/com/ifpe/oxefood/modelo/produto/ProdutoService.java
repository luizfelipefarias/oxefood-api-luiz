package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }
    
    public List<Produto> listarTodos() {
  
        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    public void update(Long id, Produto produtoAnterior){

        Produto produto = repository.findById(id).get();
        produto.setCodigo(produtoAnterior.getCodigo());
        produto.setCategoria(produtoAnterior.getCategoria());
        produto.setTitulo(produtoAnterior.getTitulo());
        produto.setDescricao(produtoAnterior.getDescricao());
        produto.setValorUnitario(produtoAnterior.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAnterior.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAnterior.getTempoEntregaMaximo());

        repository.save(produto);
    }

    public Produto delete(Long id){

        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        return repository.save(produto);
    }
}
