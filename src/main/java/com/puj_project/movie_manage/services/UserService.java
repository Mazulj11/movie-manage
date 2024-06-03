package com.puj_project.movie_manage.services;

import com.puj_project.movie_manage.models.User;
import com.puj_project.movie_manage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(User user) throws Exception {
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        user.setConfirmPassword(passwordEncoded);
        userRepo.save(user);
    }

    public boolean authenticateUser(String email, String password) {
        User existingUser = userRepo.findByEmail(email);
        return existingUser != null && passwordEncoder.matches(password, existingUser.getPassword());
    }
}
