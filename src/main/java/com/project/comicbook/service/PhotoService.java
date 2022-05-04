package com.project.comicbook.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Service
@Getter
@NoArgsConstructor
public class PhotoService extends BaseFileService {

    /** The system directory to store photos. */
    @Value("${project.photo}")
    private String photoDirectory;

    @Override
    public final void postConstruct() {
        setDirectory(photoDirectory);
    }

}
