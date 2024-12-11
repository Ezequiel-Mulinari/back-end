package com.api.app.dtos;

import com.api.app.enums.PedidoStatus;
import com.api.app.models.PedidoModel;

import java.util.UUID;

/**
 * DTO responsável por transportar informações de um pedido.
 * Inclui dados do pedido, do cliente associado e seu status.
 */
public class PedidoDTO {

    private UUID identificador;
    private UUID idDoCliente;
    private String nomeDoCliente;
    private String descricaoDetalhada;
    private Double valorPedido;
    private PedidoStatus statusAtual;
    private String nomeCompletoCliente; // Campo adicional para fornecer o nome do cliente.

    /**
     * Construtor que converte o modelo {@link PedidoModel} para o DTO.
     *
     * @param pedido Instância do modelo de pedido a ser convertida.
     */
    public PedidoDTO(PedidoModel pedido) {
        this.identificador = pedido.getId();
        this.idDoCliente = pedido.getCliente().getId();
        this.nomeDoCliente = pedido.getCliente().getNomeCliente();
        this.descricaoDetalhada = pedido.getDescricaoPedido();
        this.valorPedido = pedido.getValorTotal();
        this.statusAtual = pedido.getStatus();
        this.nomeCompletoCliente = (pedido.getCliente() != null) ? pedido.getCliente().getNomeCliente() : "N/D";
    }

    // Getters e Setters
    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public UUID getIdDoCliente() {
        return idDoCliente;
    }

    public void setIdDoCliente(UUID idDoCliente) {
        this.idDoCliente = idDoCliente;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public Double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(Double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public PedidoStatus getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(PedidoStatus statusAtual) {
        this.statusAtual = statusAtual;
    }

    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }
}
