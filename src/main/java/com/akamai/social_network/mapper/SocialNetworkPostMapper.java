package com.akamai.social_network.mapper;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import com.akamai.social_network.entity.SocialNetworkPostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SocialNetworkPostMapper {
    SocialNetworkPostMapper INSTANCE = Mappers.getMapper(SocialNetworkPostMapper.class);

    SocialNetworkPostDto entityToDto(SocialNetworkPostEntity post);
    SocialNetworkPostEntity dtoToEntity(SocialNetworkPostDto post);
    List<SocialNetworkPostDto> entitiesToDtos(List<SocialNetworkPostEntity> post);
}
