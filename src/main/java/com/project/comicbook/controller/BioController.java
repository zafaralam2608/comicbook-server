package com.project.comicbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.service.BioService;

@RestController
@RequestMapping("/bio")
public class BioController extends BaseFileTextController {

    /**
     * @param service dependency for bio
     */
    public BioController(final BioService service) {
        super(service);
    }

}
