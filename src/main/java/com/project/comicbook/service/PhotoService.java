package com.project.comicbook.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    /** The system directory to store photos. */
    @Value("${project.photo}")
    private String photosDir;

    /**
     * Gets a photo content by ID.
     *
     * @param id the ID of the requested photo
     * @return the content
     */
    public byte[] getContent(final long id) {
        try {
            return Files.readAllBytes(Path.of(photosDir + id));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Save a photo content by ID.
     *
     * @param id the ID of the requested photo
     * @param content the photo in the form of byte stream
     */
    public void saveContent(final long id, final byte[] content) {
        try {
            if (!Files.exists(Path.of(photosDir))) {
                Files.createDirectory(Path.of(photosDir));
            }
            Files.write(Path.of(photosDir + id), content);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Delete a photo content by ID.
     *
     * @param id the ID of the requested photo
     */
    public void deleteContent(final Long id) {
        try {
            Files.deleteIfExists(Path.of(photosDir + id));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
