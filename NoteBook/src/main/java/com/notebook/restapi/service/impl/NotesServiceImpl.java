package com.notebook.restapi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.notebook.restapi.exception.ResourceNotFoundException;
import com.notebook.restapi.model.Notes;
import com.notebook.restapi.repository.NotesRepository;
import com.notebook.restapi.service.NotesService;
@Service
public class NotesServiceImpl implements NotesService {
 private NotesRepository notesRepository;
 
 
	public NotesServiceImpl(NotesRepository notesRepository) {
	super();
	this.notesRepository = notesRepository;
}


	@Override
	public Notes saveNotes(Notes notes) {
		// TODO Auto-generated method stub
		return notesRepository.save(notes);
	}


	@Override
	public List<Notes> getAllNotes() {
		// TODO Auto-generated method stub
		return notesRepository.findAll();
	}


	@Override
	public Notes getNotesByID(long id) {
		// TODO Auto-generated method stub
		
		
		return notesRepository.findById(id).orElseThrow(() -> 
		            new ResourceNotFoundException("Notes","id",id));
	}


	@Override
	public Notes updateNotes(Notes notes, long id) {
		// TODO Auto-generated method stub
		Notes existingNotes = notesRepository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Notes","id",id));
		//updating Body
		existingNotes.setBody(notes.getBody());
		//updating Title
		existingNotes.setTitle(notes.getTitle());
		//updating modifiedTimestamps
		existingNotes.setModifiedTimestamps(new Date());
		notesRepository.save(existingNotes);
		return existingNotes;
	}


	@Override
	public void deleteNotes(long id) {
		// TODO Auto-generated method stub
		notesRepository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Notes","id",id));
		notesRepository.deleteById(id);
		
	}

}
