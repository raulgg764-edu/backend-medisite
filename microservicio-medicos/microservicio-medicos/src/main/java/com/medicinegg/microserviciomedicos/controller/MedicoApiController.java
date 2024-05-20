package com.medicinegg.microserviciomedicos.controller;


import com.medicinegg.microserviciomedicos.model.CreateMedicoModel;
import com.medicinegg.microserviciomedicos.model.MedicoModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medico")
public interface MedicoApiController {
    @GetMapping("/")
    public ResponseEntity<List<MedicoModel>> getAllMedico();

    @GetMapping("/{id}")
    public ResponseEntity<MedicoModel> getMedicoById(@PathVariable int id);

    @PostMapping("/")
    public ResponseEntity<MedicoModel> createMedico(@Valid @RequestBody CreateMedicoModel newMedico, BindingResult result);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable int id);

    @PutMapping("/{id}")
    public ResponseEntity<MedicoModel> updateMedico(@PathVariable int id, @Valid @RequestBody CreateMedicoModel updatedMedico, BindingResult result);


}
