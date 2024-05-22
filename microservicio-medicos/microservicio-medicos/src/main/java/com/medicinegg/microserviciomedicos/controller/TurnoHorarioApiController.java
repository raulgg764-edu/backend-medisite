package com.medicinegg.microserviciomedicos.controller;

import com.medicinegg.microserviciomedicos.model.CreateTurnoModel;
import com.medicinegg.microserviciomedicos.model.TurnoHorarioModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Turnos", description = "Operaciones relacionadas a los turnos de los médicos")
@RequestMapping("/turnos")
public interface TurnoHorarioApiController {

    @GetMapping("/")
    ResponseEntity<List<TurnoMedicoModel>> getAllTurnos();

    @GetMapping("/{id}")
    ResponseEntity<TurnoMedicoModel> getTurnoById(@PathVariable int id);

    @PostMapping("/")
    ResponseEntity<CreateTurnoModel> createTurno(@RequestBody CreateTurnoModel createTurno);

    @PutMapping("/{id}")
    ResponseEntity<CreateTurnoModel> updateTurno(@PathVariable int id, @RequestBody CreateTurnoModel updateTurno);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTurno(@PathVariable int id);

    @GetMapping("/details/")
    ResponseEntity<List<TurnoMedicoModel>> getTurnoByMedicoDateHour(@RequestParam int id_medico,@RequestParam String date,@RequestParam String hour);
}
