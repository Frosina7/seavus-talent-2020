package com.seavus.talent.notes.service;


import com.seavus.talent.notes.model.Tag;
import com.seavus.talent.notes.model.User;
import com.seavus.talent.notes.repository.TagRepository;
import com.seavus.talent.notes.repository.UserRepository;
import com.seavus.talent.notes.security.SecurityService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepository tagRepository;

    private UserRepository userRepository;

    private SecurityService securityService;



    public TagService(TagRepository tagRepository, UserRepository userRepository,SecurityService securityService) {

        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
        this.securityService=securityService;
    }

    public Tag createTag(String name) {

        User user = securityService.getAuthenticatedUser();
        Tag tag = new Tag(name,user);
        return tagRepository.save(tag);

    }

    public void deleteTagById(Long id) {

        tagRepository.deleteById(id);
    }

    public Optional<Tag> findTag(Long id) {

        return tagRepository.findById(id);

    }
    public List<Tag> findTags(User user) {

        return tagRepository.findByUser(user);
    }




}
