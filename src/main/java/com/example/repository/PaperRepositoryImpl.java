package com.example.repository;

import com.example.model.Paper;
import com.example.model.Participant;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.Data;

import java.util.List;

@Data
@Stateless
public class PaperRepositoryImpl implements PaperRepository {

    private final EntityManager entityManager = EntityManagerCreator.entityManager;

    public Paper save(Paper paper) {
        entityManager.getTransaction().begin();
        entityManager.persist(paper);
        entityManager.getTransaction().commit();
        return paper;
    }

    public Paper getByTitle(String title) {
        Query q = entityManager.createQuery("SELECT p from Paper p where p.title = :p_title", Paper.class);
        q.setParameter("p_title", title);
        return (Paper) q.getSingleResult();
    }

    public Paper getById(Long id) {
        Query q = entityManager.createQuery("SELECT p from Paper p where p.id = :p_id", Paper.class);
        q.setParameter("p_id", id);
        return (Paper) q.getSingleResult();
    }

    public List<Paper> getAll() {
        return entityManager.createQuery("SELECT p FROM Paper p", Paper.class).getResultList();
    }

    public List<Paper> getByAuthor(Participant author) {
        Query q = entityManager.createQuery("SELECT p from Paper p where p.participant_id = :p_id", Paper.class);
        q.setParameter("p_id", author.getId());
        return q.getResultList();
    }
}
