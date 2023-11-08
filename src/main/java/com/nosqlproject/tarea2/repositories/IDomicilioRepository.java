package com.nosqlproject.tarea2.repositories;

import com.nosqlproject.tarea2.models.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDomicilioRepository extends MongoRepository<Domicilio, String> {
   Page<Domicilio> findByPersonaCedula (String cedula, PageRequest pageRequest);

}

