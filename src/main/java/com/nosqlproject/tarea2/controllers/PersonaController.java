package com.nosqlproject.tarea2.controllers;

import com.nosqlproject.tarea2.commons.utils.ApiResponse;
import com.nosqlproject.tarea2.models.Persona;
import com.nosqlproject.tarea2.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class PersonaController {

   // Dependencias
   @Autowired
   PersonaService personaService;

   // Métodos
   @PostMapping("/personas")
   public ResponseEntity<?> altaPersona(@RequestBody Persona persona) {
      try {
         personaService.agregarPersona(persona);
         return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Persona ingresada correctamente"));
      }
      catch (RuntimeException exc) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(exc.getMessage()));

      }
   }
}
