package com.medicinegg.microserviciomedicos.repository.impl;

import com.medicinegg.microserviciomedicos.repository.MedicoRepository;
import com.medicinegg.microserviciomedicos.repository.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository{

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public List<Medico> getMedicoList() {
        return em.createQuery("SELECT m from Medico m", Medico.class).getResultList();
    }

    @Transactional
    @Override
    public void createMedico(Medico newMedico) {
        em.persist(newMedico);
    }

    @Override
    public Medico getMedicoById(Long id) {
        return em.find(Medico.class,id);
    }

    @Transactional
    @Override
    public void updateMedico(Long id, Medico updatedMedico) {
        updatedMedico.setMedicoID(id);
        em.merge(updatedMedico);
    }

    @Transactional
    @Override
    public void deleteMedico(Long id) {
        Medico deleteMedico = em.find(Medico.class,id);
        if(deleteMedico!=null){
            em.remove(deleteMedico);
        }
    }
}
