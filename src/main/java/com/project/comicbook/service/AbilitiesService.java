package com.project.comicbook.service;

import static com.project.comicbook.util.FileUtil.checkCreateDirectory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Service
@Getter
@NoArgsConstructor
public class AbilitiesService extends BaseFileService {

    /** The system directory to store abilities. */
    @Value("${project.data.abilities}")
    private String abilitiesDirectory;

    @Override
    public final void postConstruct() {
        checkCreateDirectory(abilitiesDirectory);
        setDirectory(abilitiesDirectory);
    }

}
