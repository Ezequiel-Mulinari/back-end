package com.api.app.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Entidade que representa um cliente no sistema.
 * Mantém informações pessoais e seus pedidos associados.
 */
@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nomeCliente;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefoneCelular;

    @Column
    private String enderecoCompleto;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference // Mantém a referência gerenciada para serialização do lado do cliente
    private List<PedidoModel> pedidos = new ArrayList<>();
}
