package com.medicinegg.microserviciocitas.service.Impl;

import com.medicinegg.microserviciocitas.feignclient.MedicoFeignClient;
import com.medicinegg.microserviciocitas.model.CitaModel;
import com.medicinegg.microserviciocitas.model.CreateCitaModel;
import com.medicinegg.microserviciocitas.model.MedicoModel;
import com.medicinegg.microserviciocitas.repository.CitaRepository;
import com.medicinegg.microserviciocitas.repository.PacienteRepository;
import com.medicinegg.microserviciocitas.repository.entity.Cita;
import com.medicinegg.microserviciocitas.service.CitasService;
import com.medicinegg.microserviciocitas.utils.CitaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Date fecha = Date.valueOf(createCita.getFecha());

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            Time horaInicio = null;
            try {
                horaInicio = new Time(sdf.parse(createCita.getHoraInicio()).getTime());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Time horaFin = null;
            try {
                horaFin = new Time(sdf.parse(createCita.getHoraInicio()).getTime());
                horaFin = Time.valueOf(horaFin.toLocalTime().plusHours(1));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            entity.setFecha(fecha);
            entity.setHoraInicio(horaInicio);
            entity.setHoraFin(horaFin);
            entity.setId_medico(createCita.getId_medico());
            entity.setPaciente(pacienteRepository.findById((long)createCita.getId_paciente()).orElse(null));
            entity.setEstado("reservada");

            if(citaRepository.verifyAvailability(entity)){
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


}
