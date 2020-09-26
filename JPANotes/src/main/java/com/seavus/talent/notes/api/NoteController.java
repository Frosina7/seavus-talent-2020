package com.seavus.talent.notes.api;

import com.seavus.talent.notes.model.Note;
import com.seavus.talent.notes.model.User;
import com.seavus.talent.notes.security.SecurityService;
import com.seavus.talent.notes.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class NoteController {

    private NoteService noteService;

    private SecurityService securityService;


    public NoteController(NoteService noteService, SecurityService securityService) {

        this.noteService = noteService;
        this.securityService = securityService;
    }

    @PostMapping("/api/notes")
    public Note createNote(@RequestBody CreateNoteRequest request) {

        return noteService.createNote(request.title,request.content);
    }

    public static class CreateNoteRequest {

        public String content;
        public String title;
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id) {

        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/notes")
    public List<Note> findNotes() {

        User user = securityService.getAuthenticatedUser();
        return noteService.findNotes(user);
    }

    @GetMapping("/api/tags/{id}/notes")
    public List<Note> findNotesByTagId(@PathVariable Long id){

        return noteService.findNotesByTagId(id);
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNoteById(@PathVariable Long id) {

        noteService.deleteNoteById(id);

    }

    @PutMapping("/api/notes/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) throws Exception {

        return noteService.updateNote(id, note);

    }

}