package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEliminarEvento {
    private String usuarioId;
}
