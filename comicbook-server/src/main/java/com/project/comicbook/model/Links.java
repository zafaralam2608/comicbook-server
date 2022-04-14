package com.project.comicbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Links {

    @Id
    @SequenceGenerator(name = "LINKS_ID_GEN", initialValue = 1000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LINKS_ID_GEN")
    private Long id;

    private String official = "";

    private String wikipedia = "";

    private String instagram = "";

    private String twitter = "";

    private String facebook = "";
}
