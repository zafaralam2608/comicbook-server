package com.project.comicbook.model;

import javax.persistence.Entity;

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
