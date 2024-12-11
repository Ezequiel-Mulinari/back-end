package com.api.app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeração que representa os diferentes status que um pedido pode assumir.
 * Cada status possui uma descrição em português para melhor entendimento.
 */
public enum PedidoStatus {

    PROCESSAMENTO("Processamento"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private final String descricao;

    PedidoStatus(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição do status.
     *
     * @return descrição do status.
     */
    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    /**
     * Converte a string recebida em um valor correspondente ao enum {@link PedidoStatus}.
     *
     * @param descricao Texto que representa o status do pedido.
     * @return O {@link PedidoStatus} correspondente à descrição fornecida.
     * @throws IllegalArgumentException Caso a descrição não corresponda a nenhum status válido.
     */
    @JsonCreator
    public static PedidoStatus fromValue(String descricao) {
        for (PedidoStatus status : PedidoStatus.values()) {
            if (status.descricao.equalsIgnoreCase(descricao)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido para o pedido: " + descricao);
    }
}
