package com.project.comicbook.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.comicbook.service.BaseFileService;

public abstract class BaseFileTextController extends BaseFileController {

    /**
     * @param service dependency for text file
     */
    protected BaseFileTextController(final BaseFileService service) {
        super(service);
    }

    /**
     * Gets a file content by ID.
     *
     * @param id the ID of the requested file
     * @return the content
     */
    @GetMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public byte[] getContent(@PathVariable final Long id) {
        return getService().getContent(id);
    }

    /**
     * Save a file content by ID.
     *
     * @param id      the ID of the requested file
     * @param content the file in the form of byte stream
     */
    @PostMapping(value = "/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void saveContent(@PathVariable final Long id,
        @RequestBody final byte[] content) {
        getService().saveContent(id, content);
    }
}
