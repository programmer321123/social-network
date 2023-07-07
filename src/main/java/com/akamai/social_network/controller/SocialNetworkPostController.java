package com.akamai.social_network.controller;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import com.akamai.social_network.exception.PostNotFountException;
import com.akamai.social_network.service.SocialNetworkPostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/social-network-post")
@ResponseStatus(value = HttpStatus.OK)
@AllArgsConstructor
public class SocialNetworkPostController {

    private SocialNetworkPostService socialNetworkPostService;

    @PostMapping(value = "")
    public SocialNetworkPostDto create(@RequestBody final SocialNetworkPostDto socialNetworkPostDto) {
        return socialNetworkPostService.create(socialNetworkPostDto);
    }

    @GetMapping(value = "/{id}")
    public SocialNetworkPostDto readById(@PathVariable long id) {
        return socialNetworkPostService.readById(id);
    }

    @GetMapping(value = "/all")
    public Page<SocialNetworkPostDto> readAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Pageable paging = PageRequest.of(page, size);
        return socialNetworkPostService.readAll(paging);
    }

    @PutMapping(value = "")
    public SocialNetworkPostDto update(@RequestBody final SocialNetworkPostDto socialNetworkPostDto) {
        return socialNetworkPostService.update(socialNetworkPostDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        socialNetworkPostService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/ten-mostly-viewed")
    public List<SocialNetworkPostDto> readTenMostlyViewed() {
        return socialNetworkPostService.readTenMostlyViewed();
    }

}
