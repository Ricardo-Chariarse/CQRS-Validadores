package com.simulacion.proyecto.ecommerce.CQRSValidadores.usuario.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name= "usuario")

public class Usuario {
    @Id()
    private String usuarioId;
    private String dni;
    private String nombre;
    private String apellidos;
    private String codigoTarjeta;
}
