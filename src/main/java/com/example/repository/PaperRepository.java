package com.example.repository;

import com.example.model.Paper;
import com.example.model.Participant;

import java.util.List;

public interface PaperRepository {
    Paper save(Paper paper);

    Paper getByTitle(String title);

    Paper getById(Long id);

    List<Paper> getAll();

    List<Paper> getByAuthor(Participant author);
}
