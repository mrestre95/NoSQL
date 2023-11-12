package com.nosqlproject.tarea2.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosqlproject.tarea2.commons.dtos.AltaDomicilioDto;
import com.nosqlproject.tarea2.controllers.DomicilioController;
import com.nosqlproject.tarea2.models.Direccion;
import com.nosqlproject.tarea2.models.Domicilio;
import com.nosqlproject.tarea2.models.Persona;
import com.nosqlproject.tarea2.services.DomicilioService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DomicilioControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DomicilioService domicilioService;

    @InjectMocks
    private DomicilioController domicilioController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(domicilioController).build();
    }

    @Test
    public void testAltaDomicilioSuccess() throws Exception {
        AltaDomicilioDto altaDomicilioDto = new AltaDomicilioDto("123456789", "Departamento 1", "Localidad 1", "Calle 1", 123, null, null, null, null, "Barrio 1");
        Persona persona = new Persona("123456789", "John", "Doe", 25);
        Direccion direccion = new Direccion("Departamento 1", "Localidad 1", "Calle 1", 123, null, null, null, null, null);

        Domicilio domicilio = new Domicilio(new ObjectId(), persona, direccion);

        //when(domicilioService.agregarDomicilio(any(AltaDomicilioDto.class))).thenReturn(domicilio);

        mockMvc.perform(post("/api/domicilios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(altaDomicilioDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Domicilio ingresado correctamente"));

        verify(domicilioService, times(1)).agregarDomicilio(any(AltaDomicilioDto.class));
        verifyNoMoreInteractions(domicilioService);
    }

    @Test
    public void testConsultarDomicilioSuccess() throws Exception {
      //  when(domicilioService.conusltarDomicilio(anyString(), anyInt(), anyInt())).thenReturn("Domicilio consultado correctamente");

        mockMvc.perform(get("/api/domicilios")
                        .param("cedula", "123456789")
                        .param("page", "1")
                        .param("size", "10"))
                .andExpect(status().isOk());

        verify(domicilioService, times(1)).conusltarDomicilio(anyString(), anyInt(), anyInt());
        verifyNoMoreInteractions(domicilioService);
    }

    @Test
    public void testConsultarDomicilioFailure() throws Exception {
        when(domicilioService.conusltarDomicilio(anyString(), anyInt(), anyInt())).thenThrow(new RuntimeException("Error al consultar domicilio"));

        mockMvc.perform(get("/api/domicilios")
                        .param("cedula", "123456789")
                        .param("page", "1")
                        .param("size", "10"))
                .andExpect(status().isPaymentRequired())
                .andExpect(jsonPath("$.message").value("Error al consultar domicilio"));

        verify(domicilioService, times(1)).conusltarDomicilio(anyString(), anyInt(), anyInt());
        verifyNoMoreInteractions(domicilioService);
    }

    @Test
    public void testConsultarDomicilioPorCriterioSuccess() throws Exception {
      //  when(domicilioService.obtenerDomicilioPorCriterio(anyString(), anyString(), anyString())).thenReturn("Domicilio consultado por criterio correctamente");

        mockMvc.perform(get("/api/domicilios/criterio")
                        .param("barrio", "Barrio 1")
                        .param("localidad", "Localidad 1")
                        .param("departamento", "Departamento 1"))
                .andExpect(status().isOk());


        verify(domicilioService, times(1)).obtenerDomicilioPorCriterio(anyString(), anyString(), anyString());
        verifyNoMoreInteractions(domicilioService);
    }

    @Test
    public void testConsultarDomicilioPorCriterioFailure() throws Exception {
        when(domicilioService.obtenerDomicilioPorCriterio(anyString(), anyString(), anyString())).thenThrow(new RuntimeException("Error al consultar domicilio por criterio"));

        mockMvc.perform(get("/api/domicilios/criterio")
                        .param("barrio", "Barrio 1")
                        .param("localidad", "Localidad 1")
                        .param("departamento", "Departamento 1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Error al consultar domicilio por criterio"));

        verify(domicilioService, times(1)).obtenerDomicilioPorCriterio(anyString(), anyString(), anyString());
        verifyNoMoreInteractions(domicilioService);
    }
}