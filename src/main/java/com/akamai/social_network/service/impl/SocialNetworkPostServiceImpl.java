package com.akamai.social_network.service.impl;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import com.akamai.social_network.entity.SocialNetworkPostEntity;
import com.akamai.social_network.exception.PostNotFountException;
import com.akamai.social_network.mapper.SocialNetworkPostMapper;
import com.akamai.social_network.repository.SocialNetworkPostRepository;
import com.akamai.social_network.service.SocialNetworkPostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class SocialNetworkPostServiceImpl implements SocialNetworkPostService {
    private SocialNetworkPostRepository socialNetworkPostRepository;

    @Override
    public SocialNetworkPostDto create(SocialNetworkPostDto socialNetworkPostDto) {
        SocialNetworkPostEntity post = SocialNetworkPostMapper.INSTANCE.dtoToEntity(socialNetworkPostDto);
        post.setId(0l);
        post = socialNetworkPostRepository.save(post);
        return SocialNetworkPostMapper.INSTANCE.entityToDto(post);
    }

    @Override
    public SocialNetworkPostDto readById(long id) {
        SocialNetworkPostEntity post = socialNetworkPostRepository.findOneById(id).orElseThrow(PostNotFountException::new);
        return SocialNetworkPostMapper.INSTANCE.entityToDto(post);
    }

    @Override
    public Page<SocialNetworkPostDto> readAll(Pageable paging) {
        return socialNetworkPostRepository.findAll(paging).map(SocialNetworkPostMapper.INSTANCE::entityToDto);
    }

    @Override
    public SocialNetworkPostDto update(SocialNetworkPostDto socialNetworkPostDto) {
        if(!socialNetworkPostRepository.existsById(socialNetworkPostDto.getId()))
            throw new PostNotFountException();
        SocialNetworkPostEntity post = SocialNetworkPostMapper.INSTANCE.dtoToEntity(socialNetworkPostDto);
        post = socialNetworkPostRepository.save(post);
        return SocialNetworkPostMapper.INSTANCE.entityToDto(post);
    }

    @Override
    public void delete(long id) {
        if(!socialNetworkPostRepository.existsById(id))
            throw new PostNotFountException();
        socialNetworkPostRepository.deleteById(id);
    }

    @Override
    public List<SocialNetworkPostDto> readTenMostlyViewed() {
        return SocialNetworkPostMapper.INSTANCE.entitiesToDtos(socialNetworkPostRepository.findTenMostlyViewed());
    }
}
