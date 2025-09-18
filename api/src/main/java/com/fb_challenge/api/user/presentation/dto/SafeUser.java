package com.fb_challenge.api.user.presentation.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SafeUser {
    private UUID id;
    private String name;
    private String email;
}
