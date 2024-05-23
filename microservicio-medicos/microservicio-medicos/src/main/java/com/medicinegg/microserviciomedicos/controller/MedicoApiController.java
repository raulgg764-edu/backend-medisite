package com.medicinegg.microserviciomedicos.controller;


import com.medicinegg.microserviciomedicos.model.CreateMedicoModel;
import com.medicinegg.microserviciomedicos.model.MedicoDetailsModel;
import com.medicinegg.microserviciomedicos.model.MedicoModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RequestMapping("/medico")
@Tag(name = "Medicos", description = "Operaciones relacionadas a los medicos")
public interface MedicoApiController {
    @GetMapping("/")
    public ResponseEntity<List<MedicoModel>> getAllMedico();

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDetailsModel> getMedicoById(@PathVariable int id);

    @PostMapping("/")
    public ResponseEntity<MedicoModel> createMedico(@Valid @RequestBody CreateMedicoModel newMedico, BindingResult result);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable int id);

    @PutMapping("/{id}")
    public ResponseEntity<MedicoModel> updateMedico(@PathVariable int id, @Valid @RequestBody CreateMedicoModel updatedMedico, BindingResult result);

    @GetMapping("/especialidad/{id}")
    public ResponseEntity<List<MedicoModel>> getMedicoByEspecialidad(@PathVariable int id);

    @GetMapping("/search/")
    public ResponseEntity<List<MedicoDetailsModel>> searchMedico(@RequestParam(required = false) String especialidad,@RequestParam(required = false) String ciudad,@RequestParam(required = false) String startHour,@RequestParam(required = false) String endHour);

    @GetMapping("/details/")
    public ResponseEntity<List<MedicoDetailsModel>> getMedicosDetail();
}
