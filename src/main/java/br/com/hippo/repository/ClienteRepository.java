package br.com.hippo.repository;

import br.com.hippo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmailCliente(String emailCliente);
}
