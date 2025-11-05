package com.crud.simplecrud.module.user.api;

import com.crud.simplecrud.module.user.application.UserService;
import com.crud.simplecrud.module.user.util.UserMapper;
import com.crud.simplecrud.shared.domain.UserDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserApi {
    public Optional<UserDTO> getById(Long id);
}
