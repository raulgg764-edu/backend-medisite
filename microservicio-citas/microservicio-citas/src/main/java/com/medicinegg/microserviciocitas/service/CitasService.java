package com.medicinegg.microserviciocitas.service;

import com.medicinegg.microserviciocitas.model.CitaModel;
import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import com.medicinegg.microserviciocitas.repository.entity.Cita;

import java.sql.Date;
import java.util.List;

public interface CitasService {

    CitaModel createCita(CreateCitaModel createCita);

    List<CitaModel> getAllCitaByPaciente(Long id_paciente, String startDate, String endDate);

    CitaModel getCitaDetailsById(Long id);

    String cancelarCita(Long id);

    void updateCita(Long id, CreateCitaModel cita);
}
