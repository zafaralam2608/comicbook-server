package com.project.comicbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.comicbook.model.Links;

@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {

}
