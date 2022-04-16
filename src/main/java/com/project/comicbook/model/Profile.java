package com.project.comicbook.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Profile {

    /** The id. */
    @Id
    @SequenceGenerator(
            name = "PROFILE_ID_GEN",
           // initialValue = 10000,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
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

    /** The links. */
    @OneToOne(cascade = CascadeType.ALL)
    private Links links;

    /** The created. */
    @CreationTimestamp
    private Date created;

    /** The updated. */
    @UpdateTimestamp
    private Date updated;

}
