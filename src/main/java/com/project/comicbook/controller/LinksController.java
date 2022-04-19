package com.project.comicbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.model.Links;
import com.project.comicbook.resource.LinksResource;
import com.project.comicbook.service.BaseService;

@RestController
@RequestMapping("/links")
public class LinksController extends BaseController<Links, LinksResource> {

    /**
     * @param service the service dependency for links
     */
    public LinksController(final BaseService<Links, LinksResource> service) {
        super(service);
    }
}
