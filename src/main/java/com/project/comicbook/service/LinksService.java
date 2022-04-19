package com.project.comicbook.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.comicbook.model.Links;
import com.project.comicbook.resource.LinksResource;

@Service
public class LinksService extends BaseService<Links, LinksResource> {

    /**
     * @param repository the links repository
     */
    public LinksService(final JpaRepository<Links, UUID> repository) {
        super(repository);
    }

    @Override
    public final List<LinksResource> saveProfiles(final List<String> names) {
        return null;
    }

    @Override
    public final LinksResource convertModelToResource(final Links model) {
        return getModelMapper().map(model, LinksResource.class);
    }

    @Override
    public final Links convertResourceToModel(final LinksResource resource) {
        return getModelMapper().map(resource, Links.class);
    }
}
