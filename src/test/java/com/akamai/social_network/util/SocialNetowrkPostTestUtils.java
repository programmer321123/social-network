package com.akamai.social_network.util;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import com.akamai.social_network.entity.SocialNetworkPostEntity;

import java.time.Instant;

public class SocialNetowrkPostTestUtils {

    public static SocialNetworkPostEntity socialNetworkPostEntity(){
        return SocialNetworkPostEntity.builder()
                .id(1l)
                .postDate(Instant.now())
                .author("author")
                .content("content")
                .viewCount(123)
                .build();
    }

    public static SocialNetworkPostDto socialNetworkPostDto(){
        return SocialNetworkPostDto.builder()
                .id(1l)
                .postDate(Instant.now())
                .author("author")
                .content("content")
                .viewCount(123)
                .build();
    }
}
