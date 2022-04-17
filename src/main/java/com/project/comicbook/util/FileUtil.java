package com.project.comicbook.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import lombok.extern.log4j.Log4j2;

@Log4j2
public final class FileUtil {

    private FileUtil() { }

    /**
     * Gets a file content by path.
     *
     * @param path the path of the requested file
     * @return the file content
     */
    public static byte[] readFile(final String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            log.error("Error reading file at path {}", path, e);
        }
        return new byte[0];
    }

    /**
     * Save a file content by path.
     *
     * @param path the path of the requested file
     * @param content the file content
     */
    public static void writeFile(final String path, final byte[] content) {
        try {
            Files.write(Path.of(path), content);
        } catch (IOException e) {
            log.error("Error saving file at path {}", path, e);
        }
    }

    /**
     * Delete a file content by path.
     *
     * @param path the path of the requested file
     */
    public static void deleteFile(final String path) {
        try {
            Files.deleteIfExists(Path.of(path));
        } catch (IOException e) {
            log.error("Error deleting file at path {}", path, e);
        }
    }
}
