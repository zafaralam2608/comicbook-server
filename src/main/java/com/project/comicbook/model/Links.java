package com.project.comicbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
