package com.project.comicbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.service.LogoService;

@RestController
@RequestMapping("/logo")
public class LogoController extends BaseFileController {

    /**
     * @param service dependency for photo
     */
    public LogoController(final LogoService service) {
        super(service);
    }
}
