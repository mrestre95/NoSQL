package com.nosqlproject.tarea2.commons.mappers;

import com.nosqlproject.tarea2.commons.dtos.AltaDomicilioDto;
import com.nosqlproject.tarea2.models.Direccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DireccionMapper {
   @Mapping(source = "departamento", target = "departamento")
   @Mapping(source = "localidad", target = "localidad")
   @Mapping(source = "calle", target = "calle")
   @Mapping(source = "nroPuerta", target = "nroPuerta")
   @Mapping(source = "apartamento", target = "apartamento")
   @Mapping(source = "padron", target = "padron")
   @Mapping(source = "ruta", target = "ruta")
   @Mapping(source = "kilometro", target = "kilometro")
   @Mapping(source = "barrio", target = "barrio")
   Direccion toEntity(AltaDomicilioDto dto);
}
