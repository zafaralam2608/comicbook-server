package com.project.comicbook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.comicbook.model.Profile;
import com.project.comicbook.repository.ProfileRepository;
import com.project.comicbook.resource.ProfileResource;

@Service
public class ProfileService {

    /** The dependency for ModelMapper. */
    @Autowired
    private ModelMapper modelMapper;

    /** The repository dependency for profile. */
    @Autowired
    private ProfileRepository profileRepository;

    /**
     * Gets a profile by ID.
     *
     * @param id the ID of the requested profile
     * @return the profile
     */
    public ProfileResource get(final long id) {
        return convertModelToResource(profileRepository.findById(id).get());
    }

    /**
     * Gets all the profiles.
     *
     * @return the profiles
     */
    public List<ProfileResource> getAll() {
        return convertModelToResourceMultiple(profileRepository.findAll());
    }

    /**
     * Creates profiles from names.
     *
     * @param names the list of names
     * @return the profiles
     */
    public List<ProfileResource> saveProfiles(final List<String> names) {
        List<Profile> models = names.stream().map(Profile::new)
                .collect(Collectors.toList());
        return convertModelToResourceMultiple(
                profileRepository.saveAll(models));
    }

    /**
     * Update profile details by ID.
     *
     * @param id the ID of the requested profile
     * @param resource the resource body for a profile
     * @return the profile
     */
    public ProfileResource modifyProfile(final Long id,
            final ProfileResource resource) {
        Profile model = convertResourceToModel(resource);
        model.setId(id);
        return convertModelToResource(profileRepository.save(model));
    }

    /**
     * Delete profiles by IDs.
     *
     * @param ids the IDs of the requested profile
     */
    public void deleteProfiles(final List<Long> ids) {
        profileRepository.deleteAllById(ids);
    }

    /**
     * Convert a model to a resource.
     *
     * @param model the profile model
     * @return the profile resource
     */
    private ProfileResource convertModelToResource(final Profile model) {
        return modelMapper.map(model, ProfileResource.class);
    }

    /**
     * Convert a list of models to a list of resources.
     *
     * @param models the models
     * @return the list
     */
    private List<ProfileResource> convertModelToResourceMultiple(
            final List<Profile> models) {
        return models.stream().map(this::convertModelToResource)
                .collect(Collectors.toList());
    }

    /**
     * Convert a resource to a model.
     *
     * @param resource the profile resource
     * @return the profile model
     */
    private Profile convertResourceToModel(final ProfileResource resource) {
        return modelMapper.map(resource, Profile.class);
    }
}
