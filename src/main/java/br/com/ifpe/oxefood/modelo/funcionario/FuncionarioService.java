package br.com.ifpe.oxefood.modelo.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public Funcionario save(Funcionario funcionario) {

        funcionario.setHabilitado(Boolean.TRUE);
        return repository.save(funcionario);
    }

    public List<Funcionario> listarTodos() {
  
        return repository.findAll();
    }

    public Funcionario obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Funcionario funcionarioAlterado) {

        Funcionario funcionario = repository.findById(id).get();
        funcionario.setTipo(funcionarioAlterado.getTipo());
        funcionario.setNome(funcionarioAlterado.getNome());
        funcionario.setCpf(funcionarioAlterado.getCpf());
        funcionario.setRg(funcionarioAlterado.getRg());
        funcionario.setDataNascimento(funcionarioAlterado.getDataNascimento());
        funcionario.setFoneCelular(funcionarioAlterado.getFoneCelular());
        funcionario.setFoneFixo(funcionarioAlterado.getFoneFixo());
        funcionario.setSalario(funcionarioAlterado.getSalario());
        funcionario.setEnderecoRua(funcionarioAlterado.getEnderecoRua());
        funcionario.setEnderecoNumero(funcionarioAlterado.getEnderecoNumero());
        funcionario.setEnderecoBairro(funcionarioAlterado.getEnderecoBairro());
        funcionario.setEnderecoCidade(funcionarioAlterado.getEnderecoCidade());
        funcionario.setEnderecoCep(funcionarioAlterado.getEnderecoCep());
        funcionario.setEnderecoUf(funcionarioAlterado.getEnderecoUf());
        funcionario.setEnderecoComplemento(funcionarioAlterado.getEnderecoComplemento());
        
        repository.save(funcionario);
    }

    @Transactional
    public void delete(Long id) {

        Funcionario funcionario = repository.findById(id).get();
        funcionario.setHabilitado(Boolean.FALSE);
        repository.save(funcionario);
    }
}
