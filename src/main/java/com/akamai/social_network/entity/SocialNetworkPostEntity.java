package com.akamai.social_network.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "social_network_post")
public class SocialNetworkPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "post_date")
    private Instant postDate;
    @Column(name = "author")
    private String author;
    @Column(name = "content")
    private String content;
    @Column(name = "view_count")
    private int viewCount;
}
