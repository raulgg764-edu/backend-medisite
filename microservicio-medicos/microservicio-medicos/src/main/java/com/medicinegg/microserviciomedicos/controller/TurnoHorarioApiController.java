package com.medicinegg.microserviciomedicos.controller;

import com.medicinegg.microserviciomedicos.model.TurnoHorarioModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/turnos")
public interface TurnoHorarioApiController {

    @GetMapping("/")
    ResponseEntity<List<TurnoMedicoModel>> getAllTurnos();

    @GetMapping("/details/")
    ResponseEntity<List<TurnoMedicoModel>> getTurnoByMedicoDateHour(@RequestParam int id_medico,@RequestParam String date,@RequestParam String hour);
}
