package com.seavus.talent.notes.repository;

import com.seavus.talent.notes.model.Tag;
import com.seavus.talent.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface TagRepository  extends JpaRepository<Tag,Long> {

    List<Tag> findByUserId(Long id);

    @Transactional
    void deleteById(Long id);
}
