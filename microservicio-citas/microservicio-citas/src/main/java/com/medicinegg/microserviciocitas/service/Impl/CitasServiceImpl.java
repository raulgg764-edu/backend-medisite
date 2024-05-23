package com.medicinegg.microserviciocitas.service.Impl;

import com.medicinegg.microserviciocitas.feignclient.MedicoFeignClient;
import com.medicinegg.microserviciocitas.model.CitaModel;
import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import com.medicinegg.microserviciocitas.model.MedicoModel;
import com.medicinegg.microserviciocitas.model.TurnoMedicoModel;
import com.medicinegg.microserviciocitas.repository.CitaRepository;
import com.medicinegg.microserviciocitas.repository.PacienteRepository;
import com.medicinegg.microserviciocitas.repository.entity.Cita;
import com.medicinegg.microserviciocitas.service.CitasService;
import com.medicinegg.microserviciocitas.utils.CitaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitasServiceImpl implements CitasService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    CitaRepository citaRepository;

    @Autowired
    MedicoFeignClient medicoFeignClient;

    @Override
    public CitaModel createCita(CreateCitaModel createCita) {
        Cita entity = new Cita();

        MedicoModel medico = medicoFeignClient.getMedicoById(createCita.getId_medico());

        if(pacienteRepository.existsById((long) createCita.getId_paciente()) && medico!=null){

            entity = CitaMapper.createCitaModelToCitaEntity(createCita,pacienteRepository);

            if(citaRepository.verifyAvailability(entity) && verifyTurnos(createCita.getId_medico(), createCita.getFecha(), createCita.getHoraInicio())){
                citaRepository.createCita(entity);
                return CitaMapper.citaEntityTocitaModel(entity,medicoFeignClient);
            }else {
                return null;
            }

        }

        return null;
    }

    @Override
    public List<CitaModel> getAllCitaByPaciente(Long id_paciente, String startDate, String endDate) {
        List<CitaModel> citaList = new ArrayList<>();

        if(pacienteRepository.existsById(id_paciente)){
            Date fechaStart = Date.valueOf(startDate);
            Date fechaEnd = Date.valueOf(endDate);

            for(Cita citaItem:citaRepository.getAllCitaByPaciente(id_paciente,fechaStart, fechaEnd )){

                citaList.add(CitaMapper.citaEntityTocitaModel(citaItem,medicoFeignClient));
            }
            return citaList;
        }
        return null;
    }

    @Override
    public CitaModel getCitaDetailsById(Long id) {
        CitaModel cita = new CitaModel();
        cita = CitaMapper.citaEntityTocitaModel(citaRepository.getCitaDetailsById(id),medicoFeignClient );

        if(cita!=null){
            return cita;
        }
        return null;
    }

    @Override
    public String cancelarCita(Long id) {

        return citaRepository.cancelarCita(id);
    }

    @Override
    public void updateCita(Long id, CreateCitaModel cita) {
        Cita entity = CitaMapper.createCitaModelToCitaEntity(cita,pacienteRepository);
        citaRepository.updateCita(id, entity);

        if(citaRepository.verifyAvailability(entity)){
            citaRepository.createCita(entity);
        }
    }

    public boolean verifyTurnos(int id_medico, String date, String hour){
        List<TurnoMedicoModel> availableTurn = medicoFeignClient.getTurnoByMedicoDateHour(id_medico, date, hour);
        if(availableTurn.isEmpty()){
            return false;
        }
        return true;
    }


}
