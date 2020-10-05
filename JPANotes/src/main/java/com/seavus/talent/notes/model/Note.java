package com.seavus.talent.notes.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Tag>tags;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note() {
    }

    public Note(String title, String content, User user, Set<Tag> tags) {
        this.title = title;
        this.content=content;
        this.user=user;
        this.tags=tags;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
