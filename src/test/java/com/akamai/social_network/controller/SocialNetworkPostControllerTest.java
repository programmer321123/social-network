package com.akamai.social_network.controller;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import com.akamai.social_network.service.SocialNetworkPostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static com.akamai.social_network.util.SocialNetowrkPostTestUtils.socialNetworkPostDto;

@ExtendWith(MockitoExtension.class)
public class SocialNetworkPostControllerTest {

    @Mock
    private SocialNetworkPostService socialNetworkPostService;

    @InjectMocks
    private SocialNetworkPostController socialNetworkPostController;

    @Test
    public void testCreate() {
        SocialNetworkPostDto request = socialNetworkPostDto();
        socialNetworkPostController.create(request);
        Mockito.verify(socialNetworkPostService).create(request);
    }

    @Test
    public void testReadById() {
        socialNetworkPostController.readById(1);
        Mockito.verify(socialNetworkPostService).readById(1);
    }

    @Test
    public void testReadAll() {
        socialNetworkPostController.readAll(3,5);
        Pageable paging = PageRequest.of(3, 5);
        Mockito.verify(socialNetworkPostService).readAll(paging);
    }

    @Test
    public void testUpdate() {
        SocialNetworkPostDto request = socialNetworkPostDto();
        socialNetworkPostController.update(request);
        Mockito.verify(socialNetworkPostService).update(request);
    }

    @Test
    public void testDelete() {
        socialNetworkPostController.delete(1);
        Mockito.verify(socialNetworkPostService).delete(1);
    }

    @Test
    public void testReadTenMostlyViewed() {
        socialNetworkPostController.readTenMostlyViewed();
        Mockito.verify(socialNetworkPostService).readTenMostlyViewed();
    }
}
