package com.project.comicbook.service;

import static com.project.comicbook.util.FileUtil.deleteFile;
import static com.project.comicbook.util.FileUtil.readFile;
import static com.project.comicbook.util.FileUtil.writeFile;
import static com.project.comicbook.util.FileUtil.checkCreateDirectory;

import javax.annotation.PostConstruct;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class BaseFileService {

    /** The system directory to store files. */
    private String directory;

    /**
     * Method to set values after object creation.
     */
    @PostConstruct
    protected abstract void postConstruct();

    /**
     * Gets a file content by ID.
     *
     * @param id the ID of the requested file
     * @return the content
     */
    public byte[] getContent(final long id) {
        checkCreateDirectory(directory);
        return readFile(directory + id);
    }

    /**
     * Save a file content by ID.
     *
     * @param id      the ID of the requested file
     * @param content the file in the form of byte stream
     */
    public void saveContent(final long id, final byte[] content) {
        checkCreateDirectory(directory);
        writeFile(directory + id, content);
    }

    /**
     * Delete a file content by ID.
     *
     * @param id the ID of the requested file
     */
    public void deleteContent(final Long id) {
        checkCreateDirectory(directory);
        deleteFile(directory + id);
    }
}
