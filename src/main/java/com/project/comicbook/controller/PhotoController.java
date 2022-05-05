package com.project.comicbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.service.PhotoService;

@RestController
@RequestMapping("/photo")
public class PhotoController extends BaseFileController {

    /**
     * @param service dependency for photo
     */
    public PhotoController(final PhotoService service) {
        super(service);
    }

}
