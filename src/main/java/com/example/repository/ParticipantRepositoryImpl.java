package com.example.repository;

import com.example.model.Participant;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.Data;

import java.util.List;

@Data
@Stateless
public class ParticipantRepositoryImpl implements ParticipantRepository {

    private final EntityManager entityManager = EntityManagerCreator.entityManager;

    public Participant save(Participant participant) {
        entityManager.getTransaction().begin();
        entityManager.persist(participant);
        entityManager.getTransaction().commit();
        return participant;
    }

    public List<Participant> getAll() {
        return entityManager.createQuery("SELECT p FROM Participant p", Participant.class).getResultList();
    }

    public Participant getByName(String name) {
        try {
            Query q = entityManager.createQuery("SELECT p from Participant p where p.name = :p_name", Participant.class);
            q.setParameter("p_name", name);
            return (Participant) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Participant getById(Long id) {
        Query q = entityManager.createQuery("SELECT p from Participant p where p.id = :p_id", Participant.class);
        q.setParameter("p_id", id);
        return (Participant) q.getSingleResult();
    }
}
