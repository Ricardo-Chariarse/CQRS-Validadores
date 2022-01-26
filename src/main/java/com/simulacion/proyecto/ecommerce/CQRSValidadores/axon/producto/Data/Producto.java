package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.Data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="producto")
public class Producto {
    @Id()
    private String productoId;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
}
