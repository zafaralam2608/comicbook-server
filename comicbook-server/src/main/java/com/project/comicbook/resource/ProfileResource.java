package com.project.comicbook.resource;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProfileResource {

    private Long id;

    private String name;

    private String alias;

    private String base;

    private String debutIn;

    private String debutOn;

    private LinksResource links;

}