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

    @Autowired
    private ProfileService profileService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfileResource> getProfiles() {
	return profileService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProfileResource getProfile(@PathVariable Long id) {
	return profileService.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfileResource> createProfiles(@RequestBody List<String> names) {
	return profileService.saveProfiles(names);
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfileResource updateProfile(@PathVariable Long id, @RequestBody ProfileResource resource) {
	return profileService.modifyProfile(id, resource);
    }

    @DeleteMapping
    public void deleteProfiles(@RequestBody List<Long> ids) {
	profileService.deleteProfiles(ids);
    }

    // @PostMapping(value = "/{id}/links", consumes =
    // MediaType.APPLICATION_JSON_VALUE)
    /*
     * public ProfileResource createLinks(@PathVariable Long id, @RequestBody
     * LinksResource resource) { return profileService.saveModifyProfileLinks(id,
     * resource); }
     */
}
