package com.project.comicbook.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Value("${project.photo}")
    private String photosDir;

    public byte[] getContent(long id) {
	try {
	    return Files.readAllBytes(Path.of(photosDir + id));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

    public void saveContent(long id, byte[] content) {
	try {
	    if (!Files.exists(Path.of(photosDir)))
		Files.createDirectory(Path.of(photosDir));
	    Files.write(Path.of(photosDir + id), content);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void deleteContent(Long id) {
	try {
	    Files.deleteIfExists(Path.of(photosDir + id));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
