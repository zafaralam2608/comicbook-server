package com.project.comicbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.comicbook.model.Links;
import com.project.comicbook.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p.links FROM Profile p where p.id = ?1")
    Links getLinksById(Long id);
}
