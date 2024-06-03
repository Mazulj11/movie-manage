package com.puj_project.movie_manage.services;

import com.puj_project.movie_manage.models.User;
import com.puj_project.movie_manage.models.UserDetails;
import com.puj_project.movie_manage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.findByEmail(username);
        return new UserDetails(u);
    }
}