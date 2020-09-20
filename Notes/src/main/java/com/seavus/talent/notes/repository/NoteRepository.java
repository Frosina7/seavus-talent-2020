package com.seavus.talent.notes.repository;

import com.seavus.talent.notes.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {

    private long nextId = 101;

    private ArrayList<Note> notes = new ArrayList<>();

    public void save(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public List<Note> findAll() {
        return notes;
    }


}