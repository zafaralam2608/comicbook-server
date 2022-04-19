package com.project.comicbook.service;

import java.util.List;
import java.util.UUID;
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
    public ProfileService(final JpaRepository<Profile, UUID> repository) {
        super(repository);
    }

    /**
     * Creates profiles from names.
     *
     * @param names the list of names
     * @return the profiles
     */
      public List<ProfileResource> saveProfiles(final List<String> names) {
          List<Profile> models = names.stream().map(name -> {
              Profile model = new Profile(name);
              model.setId(UUID.randomUUID());
              return model;
          })
                  .collect(Collectors.toList());
          return convertModelsToResources(getRepository().saveAll(models));
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
