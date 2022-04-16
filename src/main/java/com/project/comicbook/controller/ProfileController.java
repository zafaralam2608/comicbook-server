package com.project.comicbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comicbook.resource.ProfileResource;
import com.project.comicbook.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    /** The service dependency for profile. */
    @Autowired
    private ProfileService profileService;

    /**
     * Gets all the profiles.
     *
     * @return the profiles
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfileResource> getProfiles() {
        return profileService.getAll();
    }

    /**
     * Gets a profile by ID.
     *
     * @param id the ID of the requested profile
     * @return the profile
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProfileResource getProfile(@PathVariable final Long id) {
        return profileService.get(id);
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
        return profileService.saveProfiles(names);
    }

    /**
     * Update profile details by ID.
     *
     * @param id the ID of the requested profile
     * @param resource the resource body for a profile
     * @return the profile
     */
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfileResource updateProfile(@PathVariable final Long id,
            @RequestBody final ProfileResource resource) {
        return profileService.modifyProfile(id, resource);
    }

    /**
     * Delete profiles by IDs.
     *
     * @param ids the IDs of the requested profile
     */
    @DeleteMapping
    public void deleteProfiles(@RequestBody final List<Long> ids) {
        profileService.deleteProfiles(ids);
    }

    // @PostMapping(value = "/{id}/links", consumes =
    // MediaType.APPLICATION_JSON_VALUE)
    /*
     * public ProfileResource createLinks(@PathVariable Long id, @RequestBody
     * LinksResource resource) { return
     * profileService.saveModifyProfileLinks(id, resource); }
     */
}
