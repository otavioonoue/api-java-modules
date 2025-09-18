package com.fb_challenge.api.user.presentation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fb_challenge.api.user.application.usecase.CreateUserUseCase;
import com.fb_challenge.api.user.application.usecase.GetAllUsersUseCase;
import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.presentation.dto.CreateUser;
import com.fb_challenge.api.user.presentation.dto.SafeUser;
import com.fb_challenge.api.user.presentation.mapper.PresentationMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final GetAllUsersUseCase getAllUsersUseCase;
    private final CreateUserUseCase createUserUseCase;

    public UserController(GetAllUsersUseCase getAllUsersUseCase, CreateUserUseCase createUserUseCase) {
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.createUserUseCase = createUserUseCase;
    }

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
}

