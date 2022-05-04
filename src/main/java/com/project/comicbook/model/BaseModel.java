package com.project.comicbook.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    /** The created. */
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date created;

    /** The updated. */
    @UpdateTimestamp
    private Date updated;
}
