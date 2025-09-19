package com.fb_challenge.api.user.presentation.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fb_challenge.api.user.application.usecase.CreateUserUseCase;
import com.fb_challenge.api.user.application.usecase.DeleteUserUseCase;
import com.fb_challenge.api.user.application.usecase.FindUserByIdUseCase;
import com.fb_challenge.api.user.application.usecase.GetAllUsersUseCase;
import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.presentation.dto.CreateUser;
import com.fb_challenge.api.user.presentation.dto.SafeUser;
import com.fb_challenge.api.user.presentation.mapper.PresentationMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private GetAllUsersUseCase getAllUsersUseCase;
    
    @Autowired
    private CreateUserUseCase createUserUseCase;
    
    @Autowired
    private FindUserByIdUseCase findUserByIdUseCase;
    
    @Autowired
    private DeleteUserUseCase deleteUserUseCase;

    @GetMapping
    public List<SafeUser> getAll() {
        return this.getAllUsersUseCase.execute(null).stream()
            .map(PresentationMapper::toSafe)
            .collect(Collectors.toList());
    }

    @PostMapping
    public SafeUser create(@RequestBody @Valid CreateUser createUser) {
        User user = this.createUserUseCase.execute(PresentationMapper.toDomain(createUser));
        return PresentationMapper.toSafe(user);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SafeUser> getById(@PathVariable UUID id) {
        return this.findUserByIdUseCase.execute(id)
            .map(PresentationMapper::toSafe)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.deleteUserUseCase.execute(id);
    }
}
