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

import com.project.comicbook.service.PhotoService;

@RestController
@RequestMapping("/photo/{id}")
public class PhotoController {

    /** The service dependency for photo. */
    @Autowired
    private PhotoService photoService;

    /**
     * Gets a photo content by ID.
     *
     * @param id the ID of the requested photo
     * @return the content
     */
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getContent(@PathVariable final Long id) {
        return photoService.getContent(id);
    }

    /**
     * Save a photo content by ID.
     *
     * @param id the ID of the requested photo
     * @param content the photo in the form of byte stream
     */
    @PostMapping(consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void saveContent(@PathVariable final Long id,
            @RequestBody final byte[] content) {
        photoService.saveContent(id, content);
    }

    /**
     * Delete a photo content by ID.
     *
     * @param id the ID of the requested photo
     */
    @DeleteMapping
    public void deleteContent(@PathVariable final Long id) {
        photoService.deleteContent(id);
    }
}
