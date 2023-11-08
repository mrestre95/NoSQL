package com.nosqlproject.tarea2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Domicilio {
   @MongoId
   private ObjectId id;
   private Persona persona;
   private Direccion direccion;

}
