package com.medicinegg.microserviciocitas.controller.Impl;

import com.medicinegg.microserviciocitas.controller.PacienteApiController;
import com.medicinegg.microserviciocitas.model.PacienteModel;
import com.medicinegg.microserviciocitas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PacienteApiControllerImpl implements PacienteApiController {

    @Autowired
    PacienteService pacienteService;

    @Override
    public ResponseEntity<List<PacienteModel>> getAllPaciente() {

        return ResponseEntity.ok().body(pacienteService.getAllPacientes());
    }

    @Override
    public ResponseEntity<PacienteModel> getPacienteById(int id) {

        PacienteModel paciente = pacienteService.getPacienteById(id);
        if(paciente==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().body(paciente);
    }

    @Override
    public ResponseEntity<PacienteModel> createPaciente(PacienteModel createPaciente, BindingResult result) {

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            pacienteService.createPaciente(createPaciente);
        }

        return ResponseEntity.ok().body(createPaciente);
    }

    @Override
    public ResponseEntity<PacienteModel> updatePaciente(int id, PacienteModel updatedPaciente, BindingResult result) {
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            pacienteService.updatePaciente(id, updatedPaciente);
        }

        return ResponseEntity.ok().body(updatedPaciente);
    }

    @Override
    public ResponseEntity<String> deletePaciente(int id) {

        pacienteService.deletePaciente(id);

        return ResponseEntity.ok().body("El paciente ha sido eliminado");
    }


}
