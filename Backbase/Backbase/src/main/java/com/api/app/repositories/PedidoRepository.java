
package com.api.app.repositories;

import com.api.app.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {

    @Query("SELECT p FROM PedidoModel p JOIN FETCH p.cliente")
    List<PedidoModel> findAllWithCliente();

    @Query("SELECT COUNT(p) FROM PedidoModel p WHERE p.cliente.id = :clienteId")
    int countByClienteId(@Param("clienteId") UUID clienteId);

}