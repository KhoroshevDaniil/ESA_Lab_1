package com.example.repository;

import com.example.model.Participant;

import java.util.List;

public interface ParticipantRepository {
    Participant save(Participant participant);

    Participant getByName(String name);

    Participant getById(Long id);

    List<Participant> getAll();
}
