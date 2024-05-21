package com.medicinegg.microserviciocitas.repository;

import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import com.medicinegg.microserviciocitas.repository.entity.Cita;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CitaRepository {

    void createCita(Cita cita);
    Cita getCitaDetailsById(Long id);

    boolean verifyAvailability(Cita cita);

    List<Cita> getAllCitaByPaciente(Long id_paciente, Date startDate, Date endDate);

    String cancelarCita(Long id);

}
