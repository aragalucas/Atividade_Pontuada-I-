package com.prova.demo.service;

import com.prova.demo.model.Funcionario;
import com.prova.demo.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
    }

    public Funcionario criar(Funcionario funcionario) {
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }
        return repository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = buscarPorId(id);
        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setCpf(funcionarioAtualizado.getCpf());
        funcionario.setEmail(funcionarioAtualizado.getEmail());
        funcionario.setSalario(funcionarioAtualizado.getSalario());
        return repository.save(funcionario);
    }

    public void deletar(Long id) {
        Funcionario funcionario = buscarPorId(id);
        repository.delete(funcionario);
    }
}