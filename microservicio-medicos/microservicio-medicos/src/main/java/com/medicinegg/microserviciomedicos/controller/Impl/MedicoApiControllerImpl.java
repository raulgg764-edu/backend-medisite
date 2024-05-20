package com.medicinegg.microserviciomedicos.controller.Impl;

import com.medicinegg.microserviciomedicos.controller.MedicoApiController;
import com.medicinegg.microserviciomedicos.model.CreateMedicoModel;
import com.medicinegg.microserviciomedicos.model.MedicoModel;
import com.medicinegg.microserviciomedicos.service.EspecialidadService;
import com.medicinegg.microserviciomedicos.service.MedicoService;
import com.medicinegg.microserviciomedicos.utils.MedicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class MedicoApiControllerImpl implements MedicoApiController {


    @Autowired
    private MedicoService medicoService;
    @Autowired
    private EspecialidadService especialidadService;

    @Override
    public ResponseEntity<List<MedicoModel>> getAllMedico() {
        return ResponseEntity.ok().body(medicoService.getAllMedico());
    }

    @Override
    public ResponseEntity<MedicoModel> getMedicoById(int id) {
        return ResponseEntity.ok().body(medicoService.getMedicoById(id));
    }

    @Override
    public ResponseEntity<MedicoModel> createMedico(CreateMedicoModel newMedico, BindingResult result) {

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            medicoService.createMedico(newMedico);
        }

        return ResponseEntity.ok().body(MedicoMapper.createMedicoModelToMedicoModel(newMedico,especialidadService ));
    }

    @Override
    public ResponseEntity<String> deleteMedico(int id) {
        try {
            medicoService.deleteMedico(id);
            return ResponseEntity.ok("Medico eliminado");
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<MedicoModel> updateMedico(int id, CreateMedicoModel updatedMedico, BindingResult result) {
        try {
            if(result.hasErrors()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else{
                medicoService.updateMedico(id, updatedMedico);
                return ResponseEntity.ok().body(MedicoMapper.createMedicoModelToMedicoModel(updatedMedico,especialidadService));
            }
        }
        catch (Exception e){
            if(e instanceof ResponseStatusException){
                throw e;
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
    }

    @Override
    public ResponseEntity<List<MedicoModel>> getMedicoByEspecialidad(int id) {
        return ResponseEntity.ok().body(medicoService.getMedicoByEspecialidad(id));
    }

    @Override
    public ResponseEntity<List<MedicoModel>> searchMedico(String especialidad, String ciudad, String startHour, String endHour) {

        Time timeStartHour = null;
        Time timeEndHour = null;

        if(startHour!=null&endHour!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            long msStart = 0;
            try {
                msStart = sdf.parse(startHour).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            long msEnd = 0;
            try {
                msEnd = sdf.parse(endHour).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            timeStartHour = new Time(msStart);
            timeEndHour = new Time(msEnd);
        }

        return ResponseEntity.ok().body(medicoService.searchMedico(especialidad, ciudad, timeStartHour, timeEndHour));
    }
}
