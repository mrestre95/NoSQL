package com.nosqlproject.tarea2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Persona {
   @MongoId
   private String cedula;
   private String nombre;
   private String apellido;
   private Integer edad;
}
