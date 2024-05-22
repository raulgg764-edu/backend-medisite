package com.medicinegg.microserviciomedicos.repository;

import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface TurnoHorarioRepository  {
    List<TurnoHorario> findAll();

    List<TurnoHorario> getTurnoByMedicoDateHour(Long id_medico, Time hour);

    TurnoHorario getTurnoById(Long id);

    void updateTurno(Long id, TurnoHorario updatedTurno);

    void deleteTurno(Long id);

    void createTurno(TurnoHorario turnoHorario);

}
