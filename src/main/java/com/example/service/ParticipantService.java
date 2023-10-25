package com.example.service;

import com.example.model.Participant;
import com.example.repository.ParticipantRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lombok.Data;

import java.util.List;

@Data
@Stateless
public class ParticipantService {
    @EJB
    private ParticipantRepository participantRepository;

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant getByName(String name) {
        return participantRepository.getByName(name);
    }

    public List<Participant> getAll() {
        return participantRepository.getAll();
    }
}
