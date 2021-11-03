package br.com.otero.BarberShop.service;

import br.com.otero.BarberShop.model.Cliente;
import br.com.otero.BarberShop.model.Funcionario;
import br.com.otero.BarberShop.model.dto.FuncionarioRequest;
import br.com.otero.BarberShop.model.dto.FuncionarioResponse;
import br.com.otero.BarberShop.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listaFuncionario(Long id) {
        Optional<Funcionario> funcionarios = this.funcionarioRepository.findById(id);
        return funcionarios.stream().map(funcionario ->
                Funcionario.builder()
                        .id(funcionario.getId())
                        .cargo(funcionario.getCargo())
                        .nome(funcionario.getNome())
                        .build()).collect(Collectors.toList());
    }

    public List<Funcionario> todosFuncionarios() {
    return this.funcionarioRepository.findAll();
    }

    public FuncionarioResponse novoFuncionario(FuncionarioRequest novoFuncionario) {
        Funcionario funcionario = Funcionario.builder()
                .nome(novoFuncionario.getNome())
                .cargo(novoFuncionario.getCargo())
                .build();
        this.funcionarioRepository.save(funcionario);
        return FuncionarioResponse.builder()
                .id(funcionario.getId())
                .build();
    }

    public void deletar(Long id) {
        List<Funcionario> funcionario = listaFuncionario(id);
        this.funcionarioRepository.deleteAll(funcionario);
    }
}
