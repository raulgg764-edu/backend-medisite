package com.medicinegg.microserviciocitas.controller;

import com.medicinegg.microserviciocitas.model.PacienteModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/paciente")
public interface PacienteApiController {

    @GetMapping("/")
    public ResponseEntity<List<PacienteModel>> getAllPaciente();

}
