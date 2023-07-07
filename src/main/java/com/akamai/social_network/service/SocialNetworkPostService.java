package com.akamai.social_network.service;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SocialNetworkPostService {

    SocialNetworkPostDto create(final SocialNetworkPostDto socialNetworkPostDto);

    SocialNetworkPostDto readById(long id);

    Page<SocialNetworkPostDto> readAll(Pageable paging);

    SocialNetworkPostDto update(final SocialNetworkPostDto socialNetworkPostDto);

    void delete(long id);

    List<SocialNetworkPostDto> readTenMostlyViewed();
}
