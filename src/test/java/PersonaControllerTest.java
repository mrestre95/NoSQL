package com.nosqlproject.tarea2.tests;
import com.nosqlproject.tarea2.controllers.PersonaController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosqlproject.tarea2.models.Persona;
import com.nosqlproject.tarea2.services.PersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PersonaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PersonaService personaService;

    @InjectMocks
    private PersonaController personaController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(personaController).build();
    }

    @Test
    public void testAltaPersonaSuccess() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("John");
        persona.setApellido("Doe");
        persona.setCedula("5223534");
        persona.setEdad(24);

       // when(personaController.altaPersona(any(Persona.class)));

        mockMvc.perform(post("/api/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(persona)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Persona ingresada correctamente"));

        verify(personaService, times(1)).agregarPersona(any(Persona.class));
        verifyNoMoreInteractions(personaService);
    }

    @Test
    public void testAltaPersonaFailure() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("John");
        persona.setApellido("Doe");
        persona.setCedula("5223534");
        persona.setEdad(24);

        when(personaController.altaPersona(any(Persona.class))).thenThrow(new RuntimeException("Error"));

        mockMvc.perform(post("/api/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(persona)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message").value("Error"));

        verify(personaService, times(1)).agregarPersona(any(Persona.class));
        verifyNoMoreInteractions(personaService);
    }
}