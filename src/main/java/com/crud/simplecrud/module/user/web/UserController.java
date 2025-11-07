package com.crud.simplecrud.module.user.web;

import com.crud.simplecrud.module.user.application.UserService;
import com.crud.simplecrud.module.user.dto.CreateUserDTO;
import com.crud.simplecrud.module.user.dto.UpdateUserDTO;
import com.crud.simplecrud.shared.domain.PostDTO;
import com.crud.simplecrud.shared.domain.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> findUser(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDTO> getByUserId(@PathVariable Long id){
        return this.userService.getPostsByUserId(id);
    }

    @PostMapping
    public UserDTO createUser(@Valid @RequestBody CreateUserDTO dto){
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDTO dto) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
