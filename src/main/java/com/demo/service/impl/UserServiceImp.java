package com.demo.service.impl;

import com.demo.UserRepository;
import com.demo.dto.UserDTO;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userToSave = mapper.convertToEntity(userDTO);
        userToSave.setPassword(encoder.encode(userToSave.getPassword()));
        User savedUser = repository.save(userToSave);
        return mapper.convertToDto(savedUser);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }
}











