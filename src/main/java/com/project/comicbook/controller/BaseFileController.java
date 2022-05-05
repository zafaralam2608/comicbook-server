package com.project.comicbook.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.comicbook.service.BaseFileService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseFileController {

    /** The service dependency. */
    private final BaseFileService service;

    protected abstract byte[] getContent(Long id);

    protected abstract void saveContent(Long id, byte[] content);

    /**
     * Delete a file content by ID.
     *
     * @param id the ID of the requested file
     */
    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable final Long id) {
        service.deleteContent(id);
    }
}
