package com.project.comicbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Profile extends BaseModel {

    /** The id. */
    @Transient
    private static final int FIRST_ID = 10000;

    /** The id. */
    @Id
    @SequenceGenerator(name = "PROFILE_ID_GEN",
        initialValue = FIRST_ID, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "PROFILE_ID_GEN")
    private Long id;

    /** The name. */
    @NonNull
    private String name;

    /** The alias. */
    private String alias;

    /** The base. */
    private String base;

    /** The debut in. */
    private String debutIn;

    /** The debut on. */
    private String debutOn;

}
