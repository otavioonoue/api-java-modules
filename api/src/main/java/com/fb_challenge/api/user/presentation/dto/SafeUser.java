package com.fb_challenge.api.user.presentation.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SafeUser {
    private final UUID id;
    private final String name;
    private final String email;
}
