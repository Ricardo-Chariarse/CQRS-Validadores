package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,String> {
}
