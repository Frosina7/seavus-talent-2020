package com.seavus.talent.notes.api;

import com.seavus.talent.notes.model.Note;
import com.seavus.talent.notes.repository.NoteRepository;
import com.seavus.talent.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/api/notes")
    public void createNote(@RequestBody CreateNoteRequest request) {
        noteService.createNote(request.title);
    }

    public static class CreateNoteRequest {


        public String title;
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/notes")
    public List<Note> findNotes() {
        return noteService.findNotes();
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id) {

        noteService.deleteNote(id);

    }

    @PutMapping("/api/notes/{id}")
    public Note updateNote(@PathVariable("id") Long id, @RequestBody Note note) {

        return noteService.updateNote(id, note);

    }

}