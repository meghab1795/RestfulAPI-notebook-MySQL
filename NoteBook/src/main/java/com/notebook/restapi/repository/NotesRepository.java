package com.notebook.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notebook.restapi.model.Notes;

public interface NotesRepository extends JpaRepository<Notes,Long> {

}
