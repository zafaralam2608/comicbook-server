package com.project.comicbook.resource;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LinksResource {

    /** The id. */
    private Long id;

    /** The official. */
    private String official;

    /** The wikipedia. */
    private String wikipedia;

    /** The instagram. */
    private String instagram;

    /** The twitter. */
    private String twitter;

    /** The facebook. */
    private String facebook;
}
