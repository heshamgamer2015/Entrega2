package org.example.Service;

import org.example.Entity.Paciente;
import org.example.Repository.PacienteRepository;

import java.sql.SQLException;
import java.util.List;

public class PacienteService {
    private PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public void createPaciente(Paciente paciente) {
        try {
            repository.save(paciente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Paciente getPacienteById(int id) {
        try {
            return repository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Paciente> getAllPacientes() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePaciente(Paciente paciente) {
        try {
            repository.update(paciente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePaciente(int id) {
        try {
            repository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
