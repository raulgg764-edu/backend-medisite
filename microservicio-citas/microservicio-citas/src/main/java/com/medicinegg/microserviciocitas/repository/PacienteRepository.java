package com.medicinegg.microserviciocitas.repository;

import com.medicinegg.microserviciocitas.repository.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends CrudRepository<Paciente,Long> {

}
