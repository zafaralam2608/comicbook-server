package com.project.comicbook.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogoService {

    @Value("${project.logo}")
    private String logoDir;

    public byte[] getContent(long id) {
	try {
	    return Files.readAllBytes(Path.of(logoDir + id));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

    public void saveContent(long id, byte[] content) {
	try {
	    if (!Files.exists(Path.of(logoDir)))
		Files.createDirectory(Path.of(logoDir));
	    Files.write(Path.of(logoDir + id), content);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void deleteContent(Long id) {
	try {
	    Files.deleteIfExists(Path.of(logoDir + id));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
