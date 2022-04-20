package com.project.comicbook.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.model.Profile;
import com.project.comicbook.resource.ProfileResource;
import com.project.comicbook.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController
        extends BaseController<Profile, ProfileResource> {

    /**
     * @param service dependency for profile
     */
    public ProfileController(final ProfileService service) {
        super(service);
    }

    /**
     * Creates profiles from names.
     *
     * @param names the list of names
     * @return the profiles
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfileResource> createProfiles(
            @RequestBody final List<String> names) {
        return getService().saveProfiles(names);
    }
}
