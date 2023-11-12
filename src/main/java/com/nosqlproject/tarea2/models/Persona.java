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

   public String getCedula() {
      return cedula;
   }

   public void setCedula(String cedula) {
      this.cedula = cedula;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public Integer getEdad() {
      return edad;
   }

   public void setEdad(Integer edad) {
      this.edad = edad;
   }
}
