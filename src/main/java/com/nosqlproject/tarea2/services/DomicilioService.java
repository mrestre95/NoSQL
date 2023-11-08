package com.nosqlproject.tarea2.services;

import com.nosqlproject.tarea2.commons.dtos.AltaDomicilioDto;
import com.nosqlproject.tarea2.commons.dtos.DireccionDto;
import com.nosqlproject.tarea2.commons.mappers.DireccionMapper;
import com.nosqlproject.tarea2.models.Direccion;
import com.nosqlproject.tarea2.models.Domicilio;
import com.nosqlproject.tarea2.models.Persona;
import com.nosqlproject.tarea2.repositories.IDomicilioRepository;
import com.nosqlproject.tarea2.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

   @Autowired
   IDomicilioRepository repoDomicilio;
   @Autowired
   IPersonaRepository repoPersona;
   @Autowired
   DireccionMapper mapper;
   @Autowired
   private MongoTemplate mongoTemplate;

   public void agregarDomicilio(AltaDomicilioDto altaDomicilioDto) {
      Optional<Persona> persona = repoPersona.findById(
              altaDomicilioDto.getCedula()
      );
      if (persona.isEmpty())
         throw new RuntimeException("No existe una persona con la cedula aportada como parametro");
      else {
         Direccion direccion = mapper.toEntity(altaDomicilioDto);

         Domicilio domicilio = new Domicilio();
         domicilio.setPersona(persona.get());
         domicilio.setDireccion(direccion);
         repoDomicilio.save(domicilio);
      }
   }

   public Page<DireccionDto> conusltarDomicilio(String cedula, int page, int size) {
      Optional<Persona> persona = repoPersona.findById(cedula);
      if (persona.isEmpty())
         throw new RuntimeException("No existe una persona con la cedula aportada como parametro");
      else {
         PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "_id"));
         Page<Domicilio> domicilios = repoDomicilio.findByPersonaCedula(cedula, pageRequest);

         // Mapear los domicilios a DireccionDTO
         Page<DireccionDto> direccionDTOs = domicilios.map(domicilio -> {
            Direccion direccion = domicilio.getDireccion();
            DireccionDto direccionDTO = new DireccionDto();
            direccionDTO.setDepartamento(direccion.getDepartamento());
            direccionDTO.setLocalidad(direccion.getLocalidad());
            direccionDTO.setNroPuerta(direccion.getNroPuerta());
            direccionDTO.setApartamento(direccion.getApartamento());
            direccionDTO.setPadron(direccion.getPadron());
            direccionDTO.setRuta(direccion.getRuta());
            direccionDTO.setKilometro(direccion.getKilometro());
            direccionDTO.setBarrio(direccion.getBarrio());
            direccionDTO.setCalle(direccion.getCalle());
            return direccionDTO;
         });

         return direccionDTOs;
      }
   }

   public List<Domicilio> obtenerDomicilioPorCriterio(String barrio, String localidad, String departamento) {
      // Ejemplo de consulta condicional en Spring Data:
      Query query = new Query();

      if (barrio != null && !barrio.isEmpty()) {
         query.addCriteria(Criteria.where("direccion.barrio").is(barrio));
      }

      if (localidad != null && !localidad.isEmpty()) {
         query.addCriteria(Criteria.where("direccion.localidad").is(localidad));
      }

      if (departamento != null && !departamento.isEmpty()) {
         query.addCriteria(Criteria.where("direccion.departamento").is(departamento));
      }
      return mongoTemplate.find(query, Domicilio.class);
   }
}

