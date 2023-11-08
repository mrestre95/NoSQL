package com.nosqlproject.tarea2.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AltaDomicilioDto {
   private String cedula;
   private String departamento;
   private String localidad;
   private String calle;
   private Integer nroPuerta;
   private Integer apartamento;
   private Integer padron;
   private String ruta;
   private Integer kilometro;
   private String barrio;
}
