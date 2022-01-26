package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, String> {

}
