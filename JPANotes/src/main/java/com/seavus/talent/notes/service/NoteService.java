package com.seavus.talent.notes.service;

import com.seavus.talent.notes.model.Note;
import com.seavus.talent.notes.model.Tag;
import com.seavus.talent.notes.model.User;
import com.seavus.talent.notes.repository.NoteRepository;
import com.seavus.talent.notes.repository.TagRepository;
import com.seavus.talent.notes.repository.UserRepository;
import com.seavus.talent.notes.security.SecurityService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

     public Note createNote(String title, String content, List<Long> tagsId) {
        User user = securityService.getAuthenticatedUser();
        List<Tag> tags=tagRepository.findAllById(tagsId).stream().filter(tag -> tag.getUser().equals(user)).collect(Collectors.toList());
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


     public Note updateNote(String title,String content,Long id,List<Long>tagsId) throws Exception{

        User user=securityService.getAuthenticatedUser();
        Note note1=noteRepository.findById(id).orElseThrow(()->new Exception());
        List<Tag> tags=tagRepository.findAllById(tagsId).stream().filter(tag -> tag.getUser().equals(user)).collect(Collectors.toList());
        note1.setTitle(title);
        note1.setContent(content);
        note1.setTags(tags);
        return noteRepository.save(note1);
    }



}
