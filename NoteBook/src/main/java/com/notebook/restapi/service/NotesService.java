package com.notebook.restapi.service;

import java.util.List;

import com.notebook.restapi.model.Notes;

public interface NotesService {
	
	Notes saveNotes(Notes notes);
	List<Notes> getAllNotes();
	Notes getNotesByID(long id);
	Notes updateNotes(Notes notes, long id);
	void deleteNotes(long id);

}
