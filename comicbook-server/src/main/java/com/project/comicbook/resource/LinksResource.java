package com.project.comicbook.resource;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LinksResource {

    private Long id;

    private String official;

    private String wikipedia;

    private String instagram;

    private String twitter;

    private String facebook;
}
