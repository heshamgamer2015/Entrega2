package org.example.Service;

import org.example.Entity.Consulta;
import org.example.Repository.ConsultaRepository;

import java.sql.SQLException;
import java.util.List;

public class ConsultaService {
    private ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void createConsulta(Consulta consulta) {
        try {
            repository.save(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Consulta getConsultaById(int id) {
        try {
            return repository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Consulta> getAllConsultas() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateConsulta(Consulta consulta) {
        try {
            repository.update(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteConsulta(int id) {
        try {
            repository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

