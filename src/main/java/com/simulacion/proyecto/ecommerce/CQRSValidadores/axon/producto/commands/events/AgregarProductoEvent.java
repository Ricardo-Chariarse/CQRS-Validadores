package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgregarProductoEvent {
    private String productoId;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
}
