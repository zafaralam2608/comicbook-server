package com.project.comicbook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.comicbook.model.BaseModel;
import com.project.comicbook.resource.BaseResource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseService<M extends BaseModel, R extends BaseResource> {

    /** The dependency for ModelMapper. */
    @Autowired
    private ModelMapper modelMapper;

    /** The repository dependency. */
    private final JpaRepository<M, Long> repository;

    /**
     * Gets a resource by ID.
     *
     * @param id the ID of the requested resource
     * @return the resource
     */
    public R get(final Long id) {
        return convertModelToResource(repository.findById(id).get());
    }

    /**
     * Gets all the resources.
     *
     * @return the resources
     */
    public List<R> getAll() {
        return convertModelsToResources(repository.findAll());
    }

    /**
     * Update model details by ID.
     *
     * @param id       the ID of the requested model
     * @param resource the resource body for a model
     * @return the resource
     */
    public abstract R update(Long id, R resource);

    /**
     * Delete models by IDs.
     *
     * @param ids the IDs of the requested model
     */
    public void delete(final List<Long> ids) {
        repository.deleteAllById(ids);
    }

    /**
     * Creates models from names.
     *
     * @param names the list of names
     * @return the resources
     */
    public abstract List<R> createByNames(List<String> names);

    /**
     * Convert a model to a resource.
     *
     * @param model the model
     * @return the resource
     */
    protected abstract R convertModelToResource(M model);

    /**
     * Convert a list of models to a list of resources.
     *
     * @param models the list of models
     * @return the list of resources
     */
    protected List<R> convertModelsToResources(
            final List<M> models) {
        return models.stream().map(this::convertModelToResource)
                .collect(Collectors.toList());
    }

    /**
     * Convert a resource to a model.
     *
     * @param resource the resource
     * @return the model
     */
    protected abstract M convertResourceToModel(R resource);
}
