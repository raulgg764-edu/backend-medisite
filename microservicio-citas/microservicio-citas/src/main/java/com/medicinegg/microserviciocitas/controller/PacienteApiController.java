package com.medicinegg.microserviciocitas.controller;

import com.medicinegg.microserviciocitas.model.PacienteModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Paciente", description = "Operaciones relacionadas con los datos de los pacientes")
@RequestMapping("/paciente")
public interface PacienteApiController {

    @GetMapping("/")
    public ResponseEntity<List<PacienteModel>> getAllPaciente();

    @GetMapping("/{id}")
    public ResponseEntity<PacienteModel> getPacienteById(@PathVariable int id);

    @PostMapping("/")
    public ResponseEntity<PacienteModel> createPaciente(@Valid @RequestBody PacienteModel createPaciente, BindingResult result);

    @PutMapping("/{id}")
    public ResponseEntity<PacienteModel> updatePaciente(@PathVariable int id, @Valid @RequestBody PacienteModel updatedPaciente, BindingResult result);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable int id);

}
