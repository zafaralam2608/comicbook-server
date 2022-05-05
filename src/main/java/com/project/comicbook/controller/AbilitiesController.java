package com.project.comicbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.service.AbilitiesService;

@RestController
@RequestMapping("/abilities")
public class AbilitiesController extends BaseFileTextController {

    /**
     * @param service dependency for photo
     */
    public AbilitiesController(final AbilitiesService service) {
        super(service);
    }

}
