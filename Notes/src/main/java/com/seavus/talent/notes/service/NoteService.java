package com.seavus.talent.notes.service;

import com.seavus.talent.notes.model.Note;
import com.seavus.talent.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    private ArrayList<Note> notes = new ArrayList<>();

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void createNote(String title) {
        Note note = new Note(title);
        noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findNotes() {
        return noteRepository.findAll();
    }

    public void deleteNote(Long id) {
        notes.stream().forEach(note -> {
            if (note.getId() == id) {
                notes.remove(note);
            }
        });
    }

    public Note updateNote(Long id, Note note) {

        notes.stream()
                .forEach(note1 -> {
                    if (note1.getId() == id) {
                        note1.setTitle(note.getTitle());
                        note1.setContent(note.getContent());
                    }

                });
        return notes.stream().filter(note1 -> note1.getId() == id).findFirst().get();
    }


}
