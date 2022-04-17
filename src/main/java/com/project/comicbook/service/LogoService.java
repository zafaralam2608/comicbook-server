package com.project.comicbook.service;

import static com.project.comicbook.util.FileUtil.deleteFile;
import static com.project.comicbook.util.FileUtil.readFile;
import static com.project.comicbook.util.FileUtil.writeFile;

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
        return readFile(logoDir + id);
    }

    /**
     * Save a logo content by ID.
     *
     * @param id the ID of the requested logo
     * @param content the logo in the form of byte stream
     */
    public void saveContent(final long id, final byte[] content) {
        writeFile(logoDir + id, content);
    }

    /**
     * Delete a logo content by ID.
     *
     * @param id the ID of the requested logo
     */
    public void deleteContent(final Long id) {
        deleteFile(logoDir + id);
    }
}
