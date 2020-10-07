package com.seavus.talent.notes.api;

import com.seavus.talent.notes.model.Tag;
import com.seavus.talent.notes.model.User;
import com.seavus.talent.notes.security.SecurityService;
import com.seavus.talent.notes.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TagController {

    private TagService tagService;

    private SecurityService securityService;



    public TagController(TagService tagService,SecurityService securityService) {
        this.tagService = tagService;
        this.securityService=securityService;
    }

    @PostMapping("/api/tags")
    public Tag createTag(@RequestBody CreateNoteRequest request) {

       return tagService.createTag(request.name);
    }

    public static class CreateNoteRequest {

        public String name;
    }

    @GetMapping("/api/tags/{id}")
    public Tag findTag(@PathVariable Long id) {

        return tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/tags")
    public List<Tag> findTagsByUserId() {

        return tagService.findByUser(securityService.getAuthenticatedUser().getId());
    }

    @DeleteMapping("/api/tags/{id}")
    public void deleteTagById(@PathVariable Long id) {

        tagService.deleteTagById(id);

    }

}
