package com.demo.service;

import com.demo.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();
}
