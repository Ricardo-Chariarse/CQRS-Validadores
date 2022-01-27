package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.querys.viewmodels;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ComprasResponseModel {
    private String compraId;
    private String usuarioId;
    private String productoId;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
}
