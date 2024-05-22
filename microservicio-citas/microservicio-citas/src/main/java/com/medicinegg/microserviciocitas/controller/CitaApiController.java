package com.medicinegg.microserviciocitas.controller;

import com.medicinegg.microserviciocitas.model.CitaModel;
import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Citas", description = "Operaciones relacionadas a la gestión de las citas médicas")
@RequestMapping("/cita")
public interface CitaApiController {

    @PostMapping("/")
    public ResponseEntity<CitaModel> createCita(@Valid @RequestBody CreateCitaModel newCita);

    @GetMapping("/")
    public ResponseEntity<List<CitaModel>> getAllCitaByPaciente(@RequestParam Long id_paciente, @RequestParam String startDate, @RequestParam String endDate );

    @GetMapping("/{id}")
    public ResponseEntity<CitaModel> getCitaDetailsById(@PathVariable Long id);

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelarCita(@PathVariable Long id);

    @PutMapping("/{id}")
    public ResponseEntity<CitaModel> updateCita(@PathVariable Long id, @Valid @RequestBody CreateCitaModel createCitaModel);
}
