package com.example.UltraKostik_SpringBoot.service;
import com.example.UltraKostik_SpringBoot.model.User;
import com.example.UltraKostik_SpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void register(String login, String password){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userRepository.save(user);

    }
    public User authorization(String login, String password){
        Optional<User> userOptional = userRepository.findByLogin(login);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}