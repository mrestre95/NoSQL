package com.nosqlproject.tarea2.repositories;

import com.nosqlproject.tarea2.models.Direccion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDireccionRepository extends MongoRepository<Direccion, String> {
}
