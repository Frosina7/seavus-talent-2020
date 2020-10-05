package com.seavus.talent.notes.service;

import com.seavus.talent.notes.model.Note;
import com.seavus.talent.notes.model.User;
import com.seavus.talent.notes.repository.NoteRepository;
import com.seavus.talent.notes.repository.UserRepository;
import com.seavus.talent.notes.security.SecurityService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    private UserRepository userRepository;
    
    private TagRepository tagRepository;

    private SecurityService securityService;



    public NoteService(NoteRepository noteRepository,UserRepository userRepository, SecurityService securityService,TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.userRepository=userRepository;
        this.securityService = securityService;
        this.tagRepository=tagRepository;
    }

    public Note createNote(String title, String content, Set<Long> tagsId) {
        User user = securityService.getAuthenticatedUser();
        Set<Tag> tags=tagRepository.findAllById(tagsId).stream().filter(tag->tag.getUser().equals(user)).collect(Collectors.toSet());
        Note note = new Note(title,content,user,tags);
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {

        return noteRepository.findById(id);
    }

    public List<Note> findNotes(User user) {

        return noteRepository.findByUser(user);
    }

    public List<Note> findNotesByTagId(Long id) {

          return noteRepository.findNotesByTagsId(id);
    }

    public void deleteNoteById(Long id) {

        noteRepository.deleteById(id);
    }


    public Note updateNote(Long id, Note note,Set<Long>tagsId) throws Exception{

        Note note1=noteRepository.findById(id).orElseThrow(()->new Exception());
        note1.setTitle(note.getTitle());
        note1.setContent(note.getContent());
        note1.setTags(note.getTags());
        return noteRepository.save(note1);
    }



}
