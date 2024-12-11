package com.api.app.services;

import com.api.app.models.ClienteModel;
import com.api.app.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(UUID id) {
        clienteRepository.deleteById(id);
    }

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    public Optional<ClienteModel> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}
