package com.medicinegg.microserviciocitas.controller.Impl;

import com.medicinegg.microserviciocitas.controller.PacienteApiController;
import com.medicinegg.microserviciocitas.model.PacienteModel;
import com.medicinegg.microserviciocitas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteApiControllerImpl implements PacienteApiController {

    @Autowired
    PacienteService pacienteService;

    @Override
    public ResponseEntity<List<PacienteModel>> getAllPaciente() {

        return ResponseEntity.ok().body(pacienteService.getAllPacientes());
    }
}
