package com.api.app.services;

import com.api.app.enums.PedidoStatus;
import com.api.app.models.PedidoModel;
import com.api.app.repositories.PedidoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAllWithCliente();
    }

    public int countPedidosByClienteId(UUID clienteId) {
        return pedidoRepository.countByClienteId(clienteId);
    }

    public Optional<PedidoModel> buscarPorId(UUID id) {
        return pedidoRepository.findById(id);
    }

    public PedidoModel salvarPedido(PedidoModel pedido) {
        if (pedido.getStatus() == null) {
            throw new IllegalArgumentException("O status do pedido não pode ser nulo.");
        }
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void deletarPedido(UUID id) {
        try {
            if (!pedidoRepository.existsById(id)) {
                throw new RuntimeException("Pedido não encontrado para exclusão.");
            }

            // Exclui diretamente pelo ID
            pedidoRepository.deleteById(id);

            System.out.println("Pedido com ID " + id + " excluído com sucesso.");
        } catch (RuntimeException e) {
            System.err.println("Erro ao excluir pedido: " + e.getMessage());
            throw new RuntimeException("Erro ao excluir pedido: " + e.getMessage());
        }
    }


}
