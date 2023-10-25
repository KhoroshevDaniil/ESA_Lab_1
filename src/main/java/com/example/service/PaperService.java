package com.example.service;

import com.example.model.Paper;
import com.example.model.Participant;
import com.example.repository.PaperRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lombok.Data;

import java.util.List;

@Data
@Stateless
public class PaperService {
    @EJB
    private PaperRepository paperRepository;

    public Paper save(Paper paper) {
        return paperRepository.save(paper);
    }

    public List<Paper> getAll() {
        return paperRepository.getAll();
    }

    public List<Paper> getByAuthor(Participant author) {
        return paperRepository.getByAuthor(author);
    }
}
