package com.medicinegg.microserviciomedicos.controller;

import com.medicinegg.microserviciomedicos.model.EspecialidadModel;
import com.medicinegg.microserviciomedicos.model.MedicoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/especialidad")
public interface EspecialidadApiController {
    @GetMapping("/")
    public ResponseEntity<List<EspecialidadModel>> getAllEspecialidades();

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadModel> getMedicoById(@PathVariable int id);
}
