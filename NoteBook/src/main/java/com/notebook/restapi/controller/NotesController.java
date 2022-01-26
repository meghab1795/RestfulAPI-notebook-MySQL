package com.notebook.restapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.restapi.model.Notes;
import com.notebook.restapi.service.NotesService;
@RestController
@RequestMapping("/api/notes")
public class NotesController {
	
	private NotesService notesService;

	public NotesController(NotesService notesService) {
		super();
		this.notesService = notesService;
	}
	
	//create Notes
	@PostMapping
	public ResponseEntity<Notes> saveNotes(@RequestBody Notes notes){
		
		notes.setCreatedTimestamps(new Date());
		notes.setModifiedTimestamps(new Date());
		return new ResponseEntity<Notes>(notesService.saveNotes(notes), HttpStatus.CREATED);
		
	}
	
	//get All notes
	@GetMapping
	public List<Notes> getAllNotes(){
		return notesService.getAllNotes();
	}
     
	//get notes by ID
	@GetMapping("{id}")
	public ResponseEntity<Notes> getNotesByID(@PathVariable("id") long id){
		return new ResponseEntity<Notes>(notesService.getNotesByID(id),HttpStatus.OK);
		
	}
	
	//update notes
	@PutMapping("{id}")
	public ResponseEntity<Notes> updateNotes(@PathVariable("id") long id,
			                                  @RequestBody Notes notes)
   {
 return new ResponseEntity<Notes>(notesService.updateNotes(notes, id),HttpStatus.OK)	;

   }
	
	//delete notes
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteNotes(@PathVariable("id") long id){
		notesService.deleteNotes(id);
		return new ResponseEntity<String>("Note deleted successfully!",HttpStatus.OK );
		
	}
}
