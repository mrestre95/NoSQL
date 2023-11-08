package com.nosqlproject.tarea2.repositories;

import com.nosqlproject.tarea2.models.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPersonaRepository extends MongoRepository<Persona, String> {}
