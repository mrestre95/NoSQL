package com.nosqlproject.tarea2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Direccion {

   private String departamento;
   private String localidad;
   private String Calle;
   private Integer nroPuerta;
   private Integer apartamento;
   private Integer padron;
   private String ruta;
   private Integer kilometro;
   private String barrio;
}
