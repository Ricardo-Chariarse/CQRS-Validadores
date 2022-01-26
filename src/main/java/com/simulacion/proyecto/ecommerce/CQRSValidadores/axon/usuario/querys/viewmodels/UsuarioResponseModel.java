package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.viewmodels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseModel {
    private String usuarioId;
    private String dni;
    private String nombre;
    private String apellidos;
    private String codigoTarjeta;
}
