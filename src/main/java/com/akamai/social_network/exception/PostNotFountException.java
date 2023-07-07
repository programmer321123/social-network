package com.akamai.social_network.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PostNotFountException extends ResponseStatusException {

    public PostNotFountException() {
        super(HttpStatus.NOT_FOUND, "SocialNetworkPost not found");
    }
}
