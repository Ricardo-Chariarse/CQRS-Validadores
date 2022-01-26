package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="Compra")
public class Compra {
    @Id
    private String compraId;
    private String usuarioId;
    private String productoId;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;

}
