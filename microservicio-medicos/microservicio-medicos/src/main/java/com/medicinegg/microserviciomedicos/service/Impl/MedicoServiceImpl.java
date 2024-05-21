package com.medicinegg.microserviciomedicos.service.Impl;

import com.medicinegg.microserviciomedicos.model.*;
import com.medicinegg.microserviciomedicos.repository.EspecialidadRepository;
import com.medicinegg.microserviciomedicos.repository.MedicoRepository;
import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;
import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;
import com.medicinegg.microserviciomedicos.service.MedicoService;
import com.medicinegg.microserviciomedicos.utils.ConsultorioMedicoMapper;
import com.medicinegg.microserviciomedicos.utils.EspecialidadMapper;
import com.medicinegg.microserviciomedicos.utils.MedicoMapper;
import com.medicinegg.microserviciomedicos.utils.TurnoHorarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public List<MedicoModel> getAllMedico() {
        List <MedicoModel> medicoList = new ArrayList<>();
        for(Medico medicoItem:medicoRepository.getMedicoList()){
            medicoList.add(MedicoMapper.medicoEntityToMedicoModel(medicoItem));
        }

        return medicoList;
    }

    @Override
    public MedicoDetailsModel getMedicoById(int id) {
        Medico medicoEntity = medicoRepository.getMedicoById((long) id);

        return MedicoMapper.createMedicoEntityToMedicoDetailsModel(medicoEntity);
    }

    @Override
    public void createMedico(CreateMedicoModel newMedico) {
        Medico entity = new Medico();
        if(especialidadRepository.existsById(newMedico.getId_especialidad())){
            entity.setCedulaProfesional(newMedico.getCedulaProfesional());
            entity.setNombres(newMedico.getNombres());
            entity.setApellidoP(newMedico.getApellidoP());
            entity.setApellidoM(newMedico.getApellidoM());
            entity.setFechaNacimiento(Date.valueOf(newMedico.getFechaNacimiento()));
            entity.setTelefono(newMedico.getTelefono());
            entity.setEspecialidad(especialidadRepository.findById(newMedico.getId_especialidad()).orElse(null));
        }
        medicoRepository.createMedico(entity);
    }

    @Override
    public void deleteMedico(int id) {
        if(getMedicoById(id)!=null){
            medicoRepository.deleteMedico((long)id);
        }else{
            return;
        }
    }

    @Override
    public void updateMedico(int id, CreateMedicoModel updatedMedico) {
        if(getMedicoById(id)!=null){
            Medico entity = new Medico();
            if(especialidadRepository.existsById(updatedMedico.getId_especialidad())){
                entity.setCedulaProfesional(updatedMedico.getCedulaProfesional());
                entity.setNombres(updatedMedico.getNombres());
                entity.setApellidoP(updatedMedico.getApellidoP());
                entity.setApellidoM(updatedMedico.getApellidoM());
                entity.setFechaNacimiento(Date.valueOf(updatedMedico.getFechaNacimiento()));
                entity.setTelefono(updatedMedico.getTelefono());
                entity.setEspecialidad(especialidadRepository.findById(updatedMedico.getId_especialidad()).orElse(null));
            }
            medicoRepository.updateMedico((long) id, entity);
        }
    }

    @Override
    public List<MedicoModel> getMedicoByEspecialidad(int id) {
        List<MedicoModel> medicoList = new ArrayList<>();
        if(especialidadRepository.existsById((long)id)){
            for(Medico medicoItem:medicoRepository.getMedicoByEspecialidad((long)id)){
                medicoList.add(MedicoMapper.medicoEntityToMedicoModel(medicoItem));
            }
        }
        return medicoList;
    }

    @Override
    public List<MedicoDetailsModel> searchMedico(String especialidad, String ciudad, Time startHour, Time endHour) {
        List<MedicoDetailsModel> medicoList = new ArrayList<>();
        for(Medico medicoItem:medicoRepository.searchMedico(especialidad, ciudad, startHour, endHour)){
            medicoList.add(MedicoMapper.createMedicoEntityToMedicoDetailsModel(medicoItem));
        }

        return medicoList;
    }

    @Override
    public List<MedicoDetailsModel> getMedicosDetails() {
        List<MedicoDetailsModel> medicoDetailsList = new ArrayList<>();
        for(Medico medicoItem:medicoRepository.getMedicoList()){
            /*MedicoDetailsModel detailsItem = new MedicoDetailsModel();
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
            detailsItem.setTurnoHorarios(turnoHorarioList);*/

            medicoDetailsList.add(MedicoMapper.createMedicoEntityToMedicoDetailsModel(medicoItem));
        }
        return medicoDetailsList;
    }


}
