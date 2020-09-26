package com.seavus.talent.notes.service;

import com.seavus.talent.notes.model.User;
import com.seavus.talent.notes.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> findUsers()
    {
        return userRepository.findAll();
    }

}
