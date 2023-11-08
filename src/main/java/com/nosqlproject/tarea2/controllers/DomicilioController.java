package com.nosqlproject.tarea2.controllers;

import com.nosqlproject.tarea2.commons.dtos.AltaDomicilioDto;
import com.nosqlproject.tarea2.commons.utils.ApiResponse;
import com.nosqlproject.tarea2.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class DomicilioController {

   // Dependencias
   @Autowired
   DomicilioService domicilioService;

   // Métodos
   @PostMapping("/domicilios")
   public ResponseEntity<?> altaDomicilio(@RequestBody AltaDomicilioDto altaDomicilioDto) {
      try {
         domicilioService.agregarDomicilio(altaDomicilioDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Domicilio ingresado correctamente"));
      }
      catch (RuntimeException exc) {
         return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(new ApiResponse(exc.getMessage()));

      }
   }

   @GetMapping("/domicilios")
   public ResponseEntity<?> consultarDomicilio(
           @RequestParam String cedula,
           @RequestParam int page,
           @RequestParam int size)
   {
      try {
         return ResponseEntity.status(HttpStatus.OK).body(domicilioService.conusltarDomicilio(cedula, page, size));
      }
      catch (RuntimeException exc) {
         return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(new ApiResponse(exc.getMessage()));
      }
   }

   @GetMapping("/domicilios/criterio")
   public ResponseEntity<?> consultarDomicilioPorCriterio(
           @RequestParam(required = false) String barrio,
           @RequestParam(required = false) String localidad,
           @RequestParam(required = false) String departamento)
   {
      try {
         return ResponseEntity.status(HttpStatus.OK).body(domicilioService.obtenerDomicilioPorCriterio(barrio, localidad, departamento));
      }
      catch (RuntimeException exc) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(exc.getMessage()));
      }
   }
}
