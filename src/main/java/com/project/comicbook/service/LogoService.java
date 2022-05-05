package com.project.comicbook.service;

import static com.project.comicbook.util.FileUtil.checkCreateDirectory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogoService extends BaseFileService {

    /** The system directory to store logos. */
    @Value("${project.data.logo}")
    private String logoDirectory;

    @Override
    public final void postConstruct() {
        checkCreateDirectory(logoDirectory);
        setDirectory(logoDirectory);
    }
}
