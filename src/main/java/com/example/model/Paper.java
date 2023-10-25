package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "papers", schema = "public")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @ManyToOne(targetEntity = Participant.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "participant_id")
    private Participant author;
}
