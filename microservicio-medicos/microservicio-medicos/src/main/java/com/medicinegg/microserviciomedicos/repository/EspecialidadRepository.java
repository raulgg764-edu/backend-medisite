package com.medicinegg.microserviciomedicos.repository;

import com.medicinegg.microserviciomedicos.repository.entity.Especialidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends CrudRepository<Especialidad, Long> {
}
