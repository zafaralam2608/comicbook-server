package com.project.comicbook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.comicbook.model.Profile;
import com.project.comicbook.resource.ProfileResource;

@Service
public class ProfileService extends BaseService<Profile, ProfileResource> {

    /**
     * @param repository the profile repository
     */
    public ProfileService(final JpaRepository<Profile, Long> repository) {
        super(repository);
    }

    @Override
    public final List<ProfileResource> createByNames(final List<String> names) {
        List<Profile> models = names.stream().map(Profile:: new)
                .collect(Collectors.toList());
        return convertModelsToResources(getRepository().saveAll(models));
    }

    @Override
    public final ProfileResource update(final Long id,
            final ProfileResource resource) {
        Profile model = convertResourceToModel(resource);
        model.setId(id);
        return convertModelToResource(getRepository().save(model));
    }

    @Override
    public final ProfileResource convertModelToResource(final Profile model) {
        return getModelMapper().map(model, ProfileResource.class);
    }

    @Override
    public final Profile convertResourceToModel(
            final ProfileResource resource) {
        return getModelMapper().map(resource, Profile.class);
    }

}
