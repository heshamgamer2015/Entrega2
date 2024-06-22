package org.example.Controller;

import org.example.Entity.Paciente;
import org.example.Service.PacienteService;
import java.util.Scanner;
import java.util.List;

public class PacienteController {
    private PacienteService service;
    private Scanner scanner;

    public PacienteController(PacienteService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void criarPaciente() {
        System.out.println("Digite o nome do paciente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do paciente:");
        String cpf = scanner.nextLine();
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        service.createPaciente(paciente);
        System.out.println("Paciente criado com sucesso!");
    }

    public void exibirPaciente() {
        System.out.println("Digite o ID do paciente:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        Paciente paciente = service.getPacienteById(id);
        if (paciente != null) {
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void listarPacientes() {
        List<Paciente> pacientes = service.getAllPacientes();
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void atualizarPaciente() {
        System.out.println("Digite o ID do paciente:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        Paciente paciente = service.getPacienteById(id);
        if (paciente != null) {
            System.out.println("Digite o novo nome do paciente:");
            String nome = scanner.nextLine();
            System.out.println("Digite o novo CPF do paciente:");
            String cpf = scanner.nextLine();
            paciente.setNome(nome);
            paciente.setCpf(cpf);
            service.updatePaciente(paciente);
            System.out.println("Paciente atualizado com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void deletarPaciente() {
        System.out.println("Digite o ID do paciente:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        service.deletePaciente(id);
        System.out.println("Paciente deletado com sucesso!");
    }
}
