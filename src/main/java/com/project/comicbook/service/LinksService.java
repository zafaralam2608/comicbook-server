package com.project.comicbook.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.comicbook.model.Links;
import com.project.comicbook.resource.LinksResource;

@Service
public class LinksService extends BaseService<Links, LinksResource> {

    /**
     * @param repository the links repository
     */
    public LinksService(final JpaRepository<Links, Long> repository) {
        super(repository);
    }

    @Override
    public final List<LinksResource> createByNames(final List<String> names) {
        return null;
    }

    @Override
    public final LinksResource update(final Long id,
            final LinksResource resource) {
        Links model = convertResourceToModel(resource);
        model.setId(id);
        return convertModelToResource(getRepository().save(model));
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
