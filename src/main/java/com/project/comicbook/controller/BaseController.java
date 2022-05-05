package com.project.comicbook.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.comicbook.model.BaseModel;
import com.project.comicbook.resource.BaseResource;
import com.project.comicbook.service.BaseService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseController<M extends BaseModel,
    R extends BaseResource> {

    /** The service dependency. */
    private final BaseService<M, R> service;

    /**
     * Gets all the resources.
     *
     * @return the list of resources
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<R> fetchAll() {
        return service.getAll();
    }

    /**
     * Gets a resource by ID.
     *
     * @param id the ID of the requested resource
     * @return the resources
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public R fetchById(@PathVariable final Long id) {
        return service.get(id);
    }

    /**
     * Update resources details by ID.
     *
     * @param id       the ID of the requested resource
     * @param resource the request body for a resource
     * @return the resources
     */
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public R updateById(@PathVariable final Long id,
            @RequestBody final R resource) {
        return service.update(id, resource);
    }

    /**
     * Delete resources by IDs.
     *
     * @param ids the IDs of the requested resources
     */
    @DeleteMapping
    public void deleteByIds(@RequestBody final List<Long> ids) {
        service.delete(ids);
    }
}
