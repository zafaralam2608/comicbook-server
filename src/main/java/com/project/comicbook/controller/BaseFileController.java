package com.project.comicbook.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.comicbook.service.BaseFileService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@RequestMapping("/{id}")
public class BaseFileController {

    /** The service dependency. */
    private final BaseFileService service;

    /**
     * Gets a file content by ID.
     *
     * @param id the ID of the requested file
     * @return the content
     */
    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getContent(@PathVariable final Long id) {
        return service.getContent(id);
    }

    /**
     * Save a file content by ID.
     *
     * @param id the ID of the requested file
     * @param content the file in the form of byte stream
     */
    @PostMapping(consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void saveContent(@PathVariable final Long id,
        @RequestBody final byte[] content) {
        service.saveContent(id, content);
    }

    /**
     * Delete a file content by ID.
     *
     * @param id the ID of the requested file
     */
    @DeleteMapping
    public void deleteContent(@PathVariable final Long id) {
        service.deleteContent(id);
    }
}
