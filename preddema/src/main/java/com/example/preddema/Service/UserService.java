package com.example.preddema.Service;

import com.example.preddema.Dto.UserDto;
import com.example.preddema.Model.Role;
import com.example.preddema.Model.Statements;
import com.example.preddema.Model.User;
import com.example.preddema.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static com.example.preddema.Config.SecurityConfig.passwordEncoder;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public void signUp(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder().encode(userDto.getPassword()));
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setSurname(userDto.getSurname());
        user.setPhoneNum(userDto.getPhoneNum());
        user.setEmail(userDto.getEmail());
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
    }
    public User getUser(String username){
        return userRepo.findByUsername(username);
    }
}
