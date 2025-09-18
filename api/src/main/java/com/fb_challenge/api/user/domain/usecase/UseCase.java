package com.fb_challenge.api.user.domain.usecase;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
