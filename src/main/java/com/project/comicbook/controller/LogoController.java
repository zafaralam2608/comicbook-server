package com.project.comicbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.service.LogoService;

@RestController
@RequestMapping("/logo/{id}")
public class LogoController {

    /** The service dependency for logo. */
    @Autowired
    private LogoService logoService;

    /**
     * Gets a logo content by ID.
     *
     * @param id the ID of the requested logo
     * @return the content
     */
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getContent(@PathVariable final Long id) {
        return logoService.getContent(id);
    }

    /**
     * Save a logo content by ID.
     *
     * @param id the ID of the requested logo
     * @param content the logo in the form of byte stream
     */
    @PostMapping(consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void saveContent(@PathVariable final Long id,
            @RequestBody final byte[] content) {
        logoService.saveContent(id, content);
    }

    /**
     * Delete a logo content by ID.
     *
     * @param id the ID of the requested logo
     */
    @DeleteMapping
    public void deleteContent(@PathVariable final Long id) {
        logoService.deleteContent(id);
    }
}
