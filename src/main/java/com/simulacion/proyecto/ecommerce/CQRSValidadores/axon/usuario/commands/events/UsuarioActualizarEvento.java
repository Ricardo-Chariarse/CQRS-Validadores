package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioActualizarEvento {
    private String usuarioId;
    private String dni;
    private String nombre;
    private String apellidos;
    private String codigoTarjeta;
}
