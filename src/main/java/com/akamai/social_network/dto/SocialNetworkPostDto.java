package com.akamai.social_network.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialNetworkPostDto {
    private Long id;
    private Instant postDate;
    private String author;
    private String content;
    private int viewCount;
}
