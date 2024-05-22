package com.medicinegg.microserviciomedicos.service.Impl;


import com.medicinegg.microserviciomedicos.model.CreateMedicoModel;
import com.medicinegg.microserviciomedicos.model.CreateTurnoModel;
import com.medicinegg.microserviciomedicos.model.TurnoMedicoModel;
import com.medicinegg.microserviciomedicos.repository.MedicoRepository;
import com.medicinegg.microserviciomedicos.repository.TurnoHorarioRepository;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;
import com.medicinegg.microserviciomedicos.service.TurnoHorarioService;
import com.medicinegg.microserviciomedicos.utils.TurnoHorarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.medicinegg.microserviciomedicos.model.TurnoHorarioModel.obtenerTextoDia;

@Service
public class TurnoHorarioServiceImpl implements TurnoHorarioService {

    @Autowired
    TurnoHorarioRepository turnoHorarioRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public List<TurnoMedicoModel> getAllTurnos() {
        List<TurnoMedicoModel> list = new ArrayList<>();

        for(TurnoHorario turnoItem:turnoHorarioRepository.findAll()){
            list.add(TurnoHorarioMapper.turnoHorarioEntityToTurnoMedicoModel(turnoItem));
        }

        return list;
    }

    @Override
    public List<TurnoMedicoModel> getTurnoByMedicoDateHour(int id_medico, String date, String hour) {

        List<TurnoMedicoModel> list = new ArrayList<>();

        String day = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).getDayOfWeek().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long msStart = 0;
        try {
            msStart = sdf.parse(hour).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Time timeHour = new Time(msStart);

        for(TurnoHorario turnoItem:turnoHorarioRepository.getTurnoByMedicoDateHour((long) id_medico, timeHour)){

            List<String> daysList = obtenerTextoDia(turnoItem.getDiasTurno());
            if(daysList.contains(day)){
                list.add(TurnoHorarioMapper.turnoHorarioEntityToTurnoMedicoModel(turnoItem));
            }
        }
        return list;
    }

    @Override
    public TurnoMedicoModel getTurnoById(Long id) {

        TurnoMedicoModel turno = new TurnoMedicoModel();
        try {
            turno = TurnoHorarioMapper.turnoHorarioEntityToTurnoMedicoModel(turnoHorarioRepository.getTurnoById(id));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return turno;
    }

    @Override
    public void createTurno(CreateTurnoModel newTurno) {
        try {
            turnoHorarioRepository.createTurno(TurnoHorarioMapper.createTurnoToTurnoHorarioEntity(newTurno, medicoRepository));
        }catch (Exception e){
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void deleteTurno(int id) {
        try {
            turnoHorarioRepository.deleteTurno((long) id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void updateturno(int id, CreateTurnoModel updatedTurno) {
        try {
            turnoHorarioRepository.updateTurno((long) id, TurnoHorarioMapper.createTurnoToTurnoHorarioEntity(updatedTurno, medicoRepository));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
