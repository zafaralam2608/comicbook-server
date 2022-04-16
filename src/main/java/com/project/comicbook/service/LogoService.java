package com.project.comicbook.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogoService {

    /** The system directory to store logos. */
    @Value("${project.logo}")
    private String logoDir;

    /**
     * Gets a logo content by ID.
     *
     * @param id the ID of the requested logo
     * @return the content
     */
    public byte[] getContent(final long id) {
        try {
            return Files.readAllBytes(Path.of(logoDir + id));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Save a logo content by ID.
     *
     * @param id the ID of the requested logo
     * @param content the logo in the form of byte stream
     */
    public void saveContent(final long id, final byte[] content) {
        try {
            if (!Files.exists(Path.of(logoDir))) {
                Files.createDirectory(Path.of(logoDir));
            }
            Files.write(Path.of(logoDir + id), content);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Delete a logo content by ID.
     *
     * @param id the ID of the requested logo
     */
    public void deleteContent(final Long id) {
        try {
            Files.deleteIfExists(Path.of(logoDir + id));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
