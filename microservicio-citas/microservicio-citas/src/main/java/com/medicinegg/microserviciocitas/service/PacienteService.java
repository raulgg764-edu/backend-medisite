package com.medicinegg.microserviciocitas.service;

import com.medicinegg.microserviciocitas.model.PacienteModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PacienteService {
    List<PacienteModel> getAllPacientes();
    PacienteModel getPacienteById(int id);
    void createPaciente(PacienteModel newPaciente);
    void updatePaciente(int id, PacienteModel updatedPaciente);
    void deletePaciente(int id);
}
