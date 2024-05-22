package com.medicinegg.microserviciomedicos.repository;

import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;

import java.util.List;

public interface ConsultorioRepository {
    List<ConsultorioMedico> getAllConsultorios();

    List<ConsultorioMedico> getConsultoriosByCiudad(String ciudad);
}
