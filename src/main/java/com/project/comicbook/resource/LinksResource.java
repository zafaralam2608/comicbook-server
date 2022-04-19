package com.project.comicbook.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinksResource extends BaseResource {

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
