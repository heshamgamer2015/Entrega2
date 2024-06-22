package org.example.Controller;

import org.example.Entity.Endereco;
import org.example.Service.EnderecoService;

import java.util.List;
import java.util.Scanner;

public class EnderecoController {
    private EnderecoService service;
    private Scanner scanner;

    public EnderecoController(EnderecoService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void criarEndereco() {
        System.out.println("Digite o CEP do endereço:");
        String cep = scanner.nextLine();
        System.out.println("Digite a rua do endereço:");
        String rua = scanner.nextLine();
        System.out.println("Digite o número da residência:");
        String numero = scanner.nextLine();
        System.out.println("Digite a cidade do endereço:");
        String cidade = scanner.nextLine();
        System.out.println("Digite o estado do endereço:");
        String estado = scanner.nextLine();
        System.out.println("Digite o ID do paciente:");
        int pacienteId = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setPacienteId(pacienteId);
        service.createEndereco(endereco);
        System.out.println("Endereço criado com sucesso!");
    }

    public void atualizarEndereco() {
        System.out.println("Digite o ID do endereço:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Endereco endereco = service.getEnderecoById(id);
        if (endereco != null) {
            System.out.println("Digite o novo CEP do endereço:");
            String cep = scanner.nextLine();
            System.out.println("Digite a nova rua do endereço:");
            String rua = scanner.nextLine();
            System.out.println("Digite o novo número da residência:");
            String numero = scanner.nextLine();
            System.out.println("Digite a nova cidade do endereço:");
            String cidade = scanner.nextLine();
            System.out.println("Digite o novo estado do endereço:");
            String estado = scanner.nextLine();
            System.out.println("Digite o novo ID do paciente:");
            int pacienteId = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            endereco.setCep(cep);
            endereco.setRua(rua);
            endereco.setNumero(numero);
            endereco.setCidade(cidade);
            endereco.setEstado(estado);
            endereco.setPacienteId(pacienteId);
            service.updateEndereco(endereco);
            System.out.println("Endereço atualizado com sucesso!");
        } else {
            System.out.println("Endereço não encontrado.");
        }
    }

    public void listarEnderecos() {
        List<Endereco> enderecos = service.getAllEnderecos();
        for (Endereco endereco : enderecos) {
            System.out.println(endereco);
        }
    }

    public void deletarEndereco() {
        System.out.println("Digite o ID do endereço:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        service.deleteEndereco(id);
        System.out.println("Endereço deletado com sucesso!");
    }
}