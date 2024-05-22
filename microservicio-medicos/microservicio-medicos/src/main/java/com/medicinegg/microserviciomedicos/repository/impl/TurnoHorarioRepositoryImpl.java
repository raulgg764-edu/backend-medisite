package com.medicinegg.microserviciomedicos.repository.impl;

import com.medicinegg.microserviciomedicos.repository.TurnoHorarioRepository;
import com.medicinegg.microserviciomedicos.repository.entity.TurnoHorario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public class TurnoHorarioRepositoryImpl implements TurnoHorarioRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public List<TurnoHorario> findAll() {
        return em.createQuery("SELECT t from TurnoHorario t",TurnoHorario.class).getResultList();
    }

    @Transactional
    @Override
    public List<TurnoHorario> getTurnoByMedicoDateHour(Long id_medico, Time hour) {
        return em.createQuery("SELECT t from TurnoHorario t WHERE t.medico.medicoID = :id_medico AND :hour BETWEEN t.inicioTurno AND t.finTurno",TurnoHorario.class)
                .setParameter("id_medico",id_medico)
                .setParameter("hour",hour)
                .getResultList();
    }
}
