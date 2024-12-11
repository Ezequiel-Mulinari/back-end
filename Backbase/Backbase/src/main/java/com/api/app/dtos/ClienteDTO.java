package com.api.app.dtos;

import java.util.UUID;

/**
 * DTO utilizado para transportar informações de um cliente entre camadas.
 * Inclui dados identificadores e de contato do cliente.
 */
public class ClienteDTO {

    private UUID identificador;
    private String nomeCompleto;
    private String cpf;
    private String telefoneContato;
    private String enderecoResidencial;

    /**
     * Construtor para conversão do modelo em DTO.
     *
     * @param identificador        Identificador único do cliente
     * @param nomeCompleto         Nome completo do cliente
     * @param cpf                  CPF do cliente
     * @param telefoneContato      Telefone de contato do cliente
     * @param enderecoResidencial  Endereço residencial do cliente
     */
    public ClienteDTO(UUID identificador, String nomeCompleto, String cpf, String telefoneContato, String enderecoResidencial) {
        this.identificador = identificador;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefoneContato = telefoneContato;
        this.enderecoResidencial = enderecoResidencial;
    }

    // Getters e Setters
    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(String enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }
}
