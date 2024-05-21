package com.medicinegg.microserviciocitas.service;

import com.medicinegg.microserviciocitas.model.PacienteModel;
import com.medicinegg.microserviciocitas.repository.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteService {
    public List<PacienteModel> getAllPacientes();
}
