package com.medicinegg.microserviciomedicos.utils;

import com.medicinegg.microserviciomedicos.model.*;
import com.medicinegg.microserviciomedicos.repository.EspecialidadRepository;
import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;
import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;
import com.medicinegg.microserviciomedicos.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MedicoMapper {

    public static MedicoModel medicoEntityToMedicoModel(Medico medicoEntity){
        MedicoModel model = new MedicoModel();
        model.setCedulaProfesional(medicoEntity.getCedulaProfesional());
        model.setNombres(medicoEntity.getNombres());
        model.setApellidoP(medicoEntity.getApellidoP());
        model.setApellidoM(medicoEntity.getApellidoM());
        model.setFechaNacimiento(medicoEntity.getFechaNacimiento());
        model.setTelefono(medicoEntity.getTelefono());
        model.setEspecialidad(EspecialidadMapper.especialidadEntityToEspecialidadModel(medicoEntity.getEspecialidad()));

        return model;
    }

    public static Medico medicoModelToMedicoEntity(MedicoModel medicoModel){
        Medico entity = new Medico();
        entity.setCedulaProfesional(medicoModel.getCedulaProfesional());
        entity.setNombres(medicoModel.getNombres());
        entity.setApellidoP(medicoModel.getApellidoP());
        entity.setApellidoM(medicoModel.getApellidoM());
        entity.setFechaNacimiento((Date) medicoModel.getFechaNacimiento());
        entity.setTelefono(medicoModel.getTelefono());
        //entity.setEspecialidad(medicoModel.getEspecialidad());


        return entity;
    }

    public static MedicoModel createMedicoModelToMedicoModel(CreateMedicoModel createModel, EspecialidadService especialidadService){
        MedicoModel model = new MedicoModel();
        model.setCedulaProfesional(createModel.getCedulaProfesional());
        model.setNombres(createModel.getNombres());
        model.setApellidoP(createModel.getApellidoP());
        model.setApellidoM(createModel.getApellidoM());
        model.setFechaNacimiento(Date.valueOf(createModel.getFechaNacimiento()));
        model.setTelefono(createModel.getTelefono());
        model.setEspecialidad(especialidadService.getEspecialidadById(createModel.getId_especialidad()));

        return model;
    }

    public static Medico createMedicoModelToMedicoEntity(CreateMedicoModel createModel, EspecialidadService especialidadService){
        Medico entity = new Medico();
        entity.setCedulaProfesional(createModel.getCedulaProfesional());
        entity.setNombres(createModel.getNombres());
        entity.setApellidoP(createModel.getApellidoP());
        entity.setApellidoM(createModel.getApellidoM());
        entity.setFechaNacimiento(Date.valueOf(createModel.getFechaNacimiento()));
        entity.setTelefono(createModel.getTelefono());
        entity.setEspecialidad(EspecialidadMapper.especialidadModelToEspecialidadEntity(especialidadService.getEspecialidadById(createModel.getId_especialidad())));

        return entity;
    }

    public static MedicoDetailsModel createMedicoEntityToMedicoDetailsModel(Medico medicoItem){
        MedicoDetailsModel detailsItem = new MedicoDetailsModel();
        detailsItem.setMedicoID(medicoItem.getMedicoID());
        detailsItem.setCedulaProfesional(medicoItem.getCedulaProfesional());
        detailsItem.setNombres(medicoItem.getNombres());
        detailsItem.setApellidoP(medicoItem.getApellidoP());
        detailsItem.setApellidoM(medicoItem.getApellidoM());
        detailsItem.setFechaNacimiento(medicoItem.getFechaNacimiento());
        detailsItem.setTelefono(medicoItem.getTelefono());
        detailsItem.setEspecialidad(EspecialidadMapper.especialidadEntityToEspecialidadModel(medicoItem.getEspecialidad()));

        List<ConsultorioMedicoModel> consultorioList = new ArrayList<>();
        for(ConsultorioMedico consultorioItem:medicoItem.getConsultoriosMedicos()){
            consultorioList.add(ConsultorioMedicoMapper.consultorioMedicoEntityToConsultorioMedicoModel(consultorioItem));
        }
        detailsItem.setConsultoriosMedicos(consultorioList);

        List<TurnoHorarioModel> turnoHorarioList = new ArrayList<>();
        for(TurnoHorario turnoHorarioItem:medicoItem.getTurnoHorarios()){
            turnoHorarioList.add(TurnoHorarioMapper.turnoHorarioEntityToTurnoHorarioModel(turnoHorarioItem));
        }
        detailsItem.setTurnoHorarios(turnoHorarioList);

        return detailsItem;
    }
}
