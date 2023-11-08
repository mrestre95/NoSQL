package com.nosqlproject.tarea2.services;

import com.nosqlproject.tarea2.models.Persona;
import com.nosqlproject.tarea2.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {

   @Autowired
   IPersonaRepository repo;

   public void agregarPersona(Persona persona){
      Optional<Persona> existePersona = repo.findById(persona.getCedula());
      if(existePersona.isEmpty())
         repo.insert(persona);
      else
         throw new RuntimeException("La persona ya existe");
   }
}
