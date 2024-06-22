package org.example.Service;

import org.example.Entity.Endereco;
import org.example.Repository.EnderecoRepository;

import java.sql.SQLException;
import java.util.List;

public class EnderecoService {
    private EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public void createEndereco(Endereco endereco) {
        try {
            repository.save(endereco);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Endereco getEnderecoById(int id) {
        try {
            return repository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Endereco> getAllEnderecos() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEndereco(Endereco endereco) {
        try {
            repository.update(endereco);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEndereco(int id) {
        try {
            repository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}