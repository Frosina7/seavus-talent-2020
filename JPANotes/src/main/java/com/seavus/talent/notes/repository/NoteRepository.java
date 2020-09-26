package com.seavus.talent.notes.repository;

import com.seavus.talent.notes.model.Note;
import com.seavus.talent.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findNotesByTagsId(Long id);

    List<Note> findByUser(User user);

    @Transactional
    void deleteById(Long id);



}