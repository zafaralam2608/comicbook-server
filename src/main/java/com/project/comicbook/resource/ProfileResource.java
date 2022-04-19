package com.project.comicbook.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResource extends BaseResource {

    /** The name. */
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
