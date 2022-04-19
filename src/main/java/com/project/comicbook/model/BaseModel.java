package com.project.comicbook.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    /** The id. */
    @Id
    private UUID id;

    /** The created. */
    @CreationTimestamp
    private Date created;

    /** The updated. */
    @UpdateTimestamp
    private Date updated;
}
