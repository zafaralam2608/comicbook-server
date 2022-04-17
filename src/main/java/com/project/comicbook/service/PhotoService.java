package com.project.comicbook.service;

import static com.project.comicbook.util.FileUtil.deleteFile;
import static com.project.comicbook.util.FileUtil.readFile;
import static com.project.comicbook.util.FileUtil.writeFile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    /** The system directory to store photos. */
    @Value("${project.photo}")
    private String photoDir;

    /**
     * Gets a photo content by ID.
     *
     * @param id the ID of the requested photo
     * @return the content
     */
    public byte[] getContent(final long id) {
        return readFile(photoDir + id);
    }

    /**
     * Save a photo content by ID.
     *
     * @param id the ID of the requested photo
     * @param content the photo in the form of byte stream
     */
    public void saveContent(final long id, final byte[] content) {
        writeFile(photoDir + id, content);
    }

    /**
     * Delete a photo content by ID.
     *
     * @param id the ID of the requested photo
     */
    public void deleteContent(final Long id) {
        deleteFile(photoDir + id);
    }
}
