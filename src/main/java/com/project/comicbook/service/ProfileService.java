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

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProfileRepository profileRepository;

    // @Autowired
    // private LinksRepository linksRepository;

    public ProfileResource get(long id) {
	return convertModelToResource(profileRepository.findById(id).get());
    }

    public List<ProfileResource> getAll() {
	return convertModelToResourceMultiple(profileRepository.findAll());
    }

    public List<ProfileResource> saveProfiles(List<String> names) {
	List<Profile> models = names.stream().map(name -> new Profile(name)).collect(Collectors.toList());
	return convertModelToResourceMultiple(profileRepository.saveAll(models));
    }

    public ProfileResource modifyProfile(Long id, ProfileResource resource) {
	Profile model = modelMapper.map(resource, Profile.class);
	model.setId(id);
	return convertModelToResource(profileRepository.save(model));
    }

    /*
     * public ProfileResource saveModifyProfileLinks(long id, LinksResource
     * linksResource) { Links linksModel = modelMapper.map(linksResource,
     * Links.class); Links profileLinks = profileRepository.getLinksById(id); if
     * (profileLinks == null) { Profile model =
     * profileRepository.findById(id).get(); model.setLinks(linksModel);
     * profileRepository.save(model); } else { Long linksId = profileLinks.getId();
     * linksModel.setId(linksId); linksRepository.save(linksModel); } return
     * convertModelToResource(profileRepository.findById(id).get()); }
     */

    public void deleteProfiles(List<Long> ids) {
	profileRepository.deleteAllById(ids);
    }

    private ProfileResource convertModelToResource(Profile model) {
	return modelMapper.map(model, ProfileResource.class);
    }

    private List<ProfileResource> convertModelToResourceMultiple(List<Profile> models) {
	return models.stream().map(this::convertModelToResource).collect(Collectors.toList());
    }

    private Profile convertResourceToModel(ProfileResource resource) {
	return modelMapper.map(resource, Profile.class);
    }
}
