package com.medicinegg.microserviciomedicos.repository.impl;

import com.medicinegg.microserviciomedicos.repository.ConsultorioRepository;
import com.medicinegg.microserviciomedicos.repository.entity.ConsultorioMedico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultorioRepositoryImpl implements ConsultorioRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public List<ConsultorioMedico> getAllConsultorios() {
        return em.createQuery("SELECT c FROM ConsultorioMedico c", ConsultorioMedico.class).getResultList();
    }

    @Transactional
    @Override
    public List<ConsultorioMedico> getConsultoriosByCiudad(String ciudad) {
        return em.createQuery("SELECT c FROM ConsultorioMedico c WHERE c.ciudad LIKE :ciudad", ConsultorioMedico.class)
                .setParameter("ciudad","%"+ciudad+"%")
                .getResultList();
    }
}
