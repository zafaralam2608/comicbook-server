package com.project.comicbook.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogoService extends BaseFileService {

    /** The system directory to store logos. */
    @Value("${project.logo}")
    private String logoDirectory;

    @Override
    public final void postConstruct() {
        setDirectory(logoDirectory);
    }
}
