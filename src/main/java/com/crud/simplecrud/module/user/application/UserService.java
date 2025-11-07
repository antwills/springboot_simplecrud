package com.crud.simplecrud.module.user.application;

import com.crud.simplecrud.module.post.api.PostApi;
import com.crud.simplecrud.module.user.api.UserApi;
import com.crud.simplecrud.module.user.persistence.UserModel;
import com.crud.simplecrud.module.user.persistence.UserRepository;
import com.crud.simplecrud.module.user.domain.User;
import com.crud.simplecrud.module.user.dto.CreateUserDTO;
import com.crud.simplecrud.module.user.dto.UpdateUserDTO;
import com.crud.simplecrud.module.user.util.UserMapper;
import com.crud.simplecrud.shared.domain.PostDTO;
import com.crud.simplecrud.shared.domain.UserDTO;
import com.crud.simplecrud.shared.exception.BusinessException;
import com.crud.simplecrud.shared.exception.ConflictException;
import com.crud.simplecrud.shared.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserApi {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PostApi postApi;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, PostApi postApi){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.postApi = postApi;
    }

    public List<UserDTO> getAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public Optional<UserDTO> getById(Long id){
        Optional<UserModel> userModel = userRepository.findById(id);

        return userModel.map(userMapper::toDto);
    }

    public List<PostDTO> getPostsByUserId(Long userId){
        return this.postApi.getByUserId(userId);
    }

    public UserDTO create(CreateUserDTO dto){
        Optional<UserModel> userExist = userRepository.findByEmail(dto.email());

        if(userExist.isPresent()) throw new ConflictException("Email already exists.");

        var userModel = userRepository.save(new UserModel(dto.name(), dto.email()));

        return userMapper.toDto(userModel);
    }

    public UserDTO update(Long id, UpdateUserDTO dto) {
        if (!id.equals(dto.id())) throw new BusinessException("The path ID is different from the body ID.");

        User user = userRepository.findById(id)
                .map(userMapper::toDomain)
                .orElseThrow(() -> new NotFoundException("User ID not found: " + id));

        dto.name().ifPresent(user::updateName);
        dto.email().ifPresent(user::updateEmail);

        UserModel model = userRepository.save(userMapper.toModel(user));

        return userMapper.toDto(model);
    }

    public void delete(Long id){
        UserModel user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User ID not found: " + id));

        userRepository.delete(user);
    }
}
