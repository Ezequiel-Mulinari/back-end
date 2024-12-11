package com.api.app.controllers;

import com.api.app.dtos.PedidoDTO;
import com.api.app.models.PedidoModel;
import com.api.app.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Controlador responsável pela gestão dos pedidos.
 * Oferece endpoints para criação, atualização, exclusão e consulta de pedidos.
 */
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Lista todos os pedidos cadastrados, retornando-os na forma de DTO.
     *
     * @return Lista de {@link PedidoDTO}.
     */
    @GetMapping("/listOrders")
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<PedidoDTO> pedidos = pedidoService.listarPedidos().stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidos);
    }

    /**
     * Busca um pedido por seu identificador único.
     *
     * @param id Identificador do pedido.
     * @return O pedido encontrado, caso exista.
     */
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable UUID id) {
        Optional<PedidoModel> pedido = pedidoService.buscarPorId(id);
        return pedido.map(value -> ResponseEntity.ok(new PedidoDTO(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo pedido.
     *
     * @param pedido Dados do pedido a serem criados.
     * @return O pedido criado.
     */
    @PostMapping("/createOrder")
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedido) {
        PedidoModel novoPedido = pedidoService.salvarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    /**
     * Atualiza um pedido existente.
     *
     * @param id               Identificador do pedido a ser atualizado.
     * @param pedidoAtualizado Dados atualizados do pedido.
     * @return O pedido atualizado, caso exista.
     */
    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<PedidoModel> atualizarPedido(@PathVariable UUID id, @RequestBody PedidoModel pedidoAtualizado) {
        Optional<PedidoModel> pedidoExistente = pedidoService.buscarPorId(id);

        if (pedidoExistente.isPresent()) {
            PedidoModel pedido = pedidoExistente.get();

            // Ajustando os campos conforme as mudanças nos models:
            pedido.setDescricaoPedido(pedidoAtualizado.getDescricaoPedido());
            pedido.setValorTotal(pedidoAtualizado.getValorTotal());
            pedido.setStatus(pedidoAtualizado.getStatus());

            PedidoModel pedidoAtualizadoResult = pedidoService.salvarPedido(pedido);
            return ResponseEntity.ok(pedidoAtualizadoResult);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deleta um pedido pelo seu identificador único.
     *
     * @param id Identificador do pedido a ser deletado.
     * @return Status 204 (NO CONTENT) em caso de sucesso ou 400 (BAD REQUEST) em caso de erro.
     */
    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable UUID id) {
        try {
            System.out.println("Recebida requisição para deletar pedido com ID: " + id);
            pedidoService.deletarPedido(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            System.err.println("Erro ao excluir pedido: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}