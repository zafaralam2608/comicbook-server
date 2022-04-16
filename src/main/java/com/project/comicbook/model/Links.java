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

    /** The id. */
    @Id
    @SequenceGenerator(
            name = "LINKS_ID_GEN",
            //initialValue = 1000000,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "LINKS_ID_GEN")
    private Long id;

    /** The official. */
    private String official = "";

    /** The wikipedia. */
    private String wikipedia = "";

    /** The instagram. */
    private String instagram = "";

    /** The twitter. */
    private String twitter = "";

    /** The facebook. */
    private String facebook = "";
}
