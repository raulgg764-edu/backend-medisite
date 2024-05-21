package com.medicinegg.microserviciocitas.controller.Impl;

import com.medicinegg.microserviciocitas.controller.CitaApiController;
import com.medicinegg.microserviciocitas.model.CitaModel;
import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import com.medicinegg.microserviciocitas.service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
public class CitaApiControllerImpl implements CitaApiController {

    @Autowired
    CitasService citasService;

    @Override
    public ResponseEntity<CitaModel> createCita(CreateCitaModel newCita) {

        CitaModel model = new CitaModel();
        model = citasService.createCita(newCita);
        if(model==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(model);

    }

    @Override
    public ResponseEntity<List<CitaModel>> getAllCitaByPaciente(Long id_paciente, String startDate, String endDate) {
        List<CitaModel> citaList = citasService.getAllCitaByPaciente( id_paciente, startDate, endDate);
        if(citaList==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(citaList);
    }

    @Override
    public ResponseEntity<CitaModel> getCitaDetailsById(Long id) {
        CitaModel cita = citasService.getCitaDetailsById(id);
        if(cita==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(cita);
    }

    @Override
    public ResponseEntity<String> cancelarCita(Long id) {
        if(getCitaDetailsById(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(citasService.cancelarCita(id));
    }


}
