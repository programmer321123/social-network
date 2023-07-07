package com.akamai.social_network.service;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import com.akamai.social_network.entity.SocialNetworkPostEntity;
import com.akamai.social_network.exception.PostNotFountException;
import com.akamai.social_network.repository.SocialNetworkPostRepository;
import com.akamai.social_network.service.impl.SocialNetworkPostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.akamai.social_network.util.SocialNetowrkPostTestUtils.socialNetworkPostDto;
import static com.akamai.social_network.util.SocialNetowrkPostTestUtils.socialNetworkPostEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class SocialNetworkPostServiceImplTest {

    @Mock
    private SocialNetworkPostRepository socialNetworkPostRepository;

    @InjectMocks
    private SocialNetworkPostServiceImpl socialNetworkPostService;

    @Test
    public void testCreate(){
        SocialNetworkPostEntity entity = socialNetworkPostEntity();
        Mockito.when(socialNetworkPostRepository.save(any(SocialNetworkPostEntity.class))).thenReturn(entity);
        SocialNetworkPostDto request = socialNetworkPostDto();
        SocialNetworkPostDto result = socialNetworkPostService.create(request);
        assertAll(
                ()->assertEquals(1l,result.getId()),
                ()->assertNotNull(result.getPostDate()),
                ()->assertEquals("author",result.getAuthor()),
                ()->assertEquals("content",result.getContent()),
                ()->assertEquals(123,result.getViewCount())
        );
    }

    @Test
    public void testUpdate(){
        SocialNetworkPostEntity entity = socialNetworkPostEntity();
        Mockito.when(socialNetworkPostRepository.existsById(1l)).thenReturn(true);
        Mockito.when(socialNetworkPostRepository.save(any(SocialNetworkPostEntity.class))).thenReturn(entity);
        SocialNetworkPostDto request = socialNetworkPostDto();
        SocialNetworkPostDto result = socialNetworkPostService.update(request);
        assertAll(
                ()->assertEquals(1l,result.getId()),
                ()->assertNotNull(result.getPostDate()),
                ()->assertEquals("author",result.getAuthor()),
                ()->assertEquals("content",result.getContent()),
                ()->assertEquals(123,result.getViewCount())
        );
    }

    @Test
    public void testUpdateShouldThrowExceptionWhenIdNotExists(){
        Mockito.when(socialNetworkPostRepository.existsById(1l)).thenReturn(false);
        PostNotFountException exception = assertThrows(PostNotFountException.class, () -> {
            socialNetworkPostService.update(socialNetworkPostDto());
        });
        assertAll(
                ()->assertEquals(HttpStatus.NOT_FOUND,exception.getStatus()),
                ()->assertEquals("SocialNetworkPost not found",exception.getReason())
        );
    }

    @Test
    public void shouldReadPostByIdWhenIdExists(){
        Mockito.when(socialNetworkPostRepository.findOneById(1l)).thenReturn(Optional.of(socialNetworkPostEntity()));
        SocialNetworkPostDto result = socialNetworkPostService.readById(1l);
        assertAll(
            ()->assertEquals(1l,result.getId()),
            ()->assertNotNull(result.getPostDate()),
            ()->assertEquals("author",result.getAuthor()),
            ()->assertEquals("content",result.getContent()),
            ()->assertEquals(123,result.getViewCount())
        );
    }

    @Test
    public void testReadPostByIdShouldThrowPostNotFoundExceptionWhenIdNotExists(){
        Mockito.when(socialNetworkPostRepository.findOneById(1l)).thenReturn(Optional.empty());
        PostNotFountException exception = assertThrows(PostNotFountException.class, () -> {
            socialNetworkPostService.readById(1l);
        });
        assertAll(
                ()->assertEquals(HttpStatus.NOT_FOUND,exception.getStatus()),
                ()->assertEquals("SocialNetworkPost not found",exception.getReason())
        );
    }

    @Test
    public void testDeletePostById(){
      Mockito.when(socialNetworkPostRepository.existsById(1l)).thenReturn(true);
      socialNetworkPostService.delete(1l);
      Mockito.verify(socialNetworkPostRepository).deleteById(1l);
    }

    @Test
    public void testDeletePostByIdShouldThrowPostNotFoundExceptionWhenIdNotExists(){
        PostNotFountException exception = assertThrows(PostNotFountException.class, () -> {
            socialNetworkPostService.delete(1l);
        });
        assertAll(
                ()->assertEquals(HttpStatus.NOT_FOUND,exception.getStatus()),
                ()->assertEquals("SocialNetworkPost not found",exception.getReason())
        );
    }

    @Test
    public void testReadAll(){
        Pageable paging = PageRequest.of(0, 3);
        Mockito.when(socialNetworkPostRepository.findAll(paging)).thenReturn(new PageImpl<>(List.of(socialNetworkPostEntity()), paging, 1));
        SocialNetworkPostDto result = socialNetworkPostService.readAll(paging).get().collect(Collectors.toList()).get(0);
        assertAll(
                ()->assertEquals(1l,result.getId()),
                ()->assertNotNull(result.getPostDate()),
                ()->assertEquals("author",result.getAuthor()),
                ()->assertEquals("content",result.getContent()),
                ()->assertEquals(123,result.getViewCount())
        );
    }

    @Test
    public void testTenMostlyViewed(){
        Mockito.when(socialNetworkPostRepository.findTenMostlyViewed()).thenReturn(List.of(socialNetworkPostEntity()));
        SocialNetworkPostDto result = socialNetworkPostService.readTenMostlyViewed().get(0);
        assertAll(
                ()->assertEquals(1l,result.getId()),
                ()->assertNotNull(result.getPostDate()),
                ()->assertEquals("author",result.getAuthor()),
                ()->assertEquals("content",result.getContent()),
                ()->assertEquals(123,result.getViewCount())
        );
    }


}
