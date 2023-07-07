package com.akamai.social_network.mapper;

import com.akamai.social_network.dto.SocialNetworkPostDto;
import com.akamai.social_network.entity.SocialNetworkPostEntity;
import org.junit.jupiter.api.Test;

import static com.akamai.social_network.util.SocialNetowrkPostTestUtils.socialNetworkPostDto;
import static com.akamai.social_network.util.SocialNetowrkPostTestUtils.socialNetworkPostEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class SocialNetworkPostMapperTest {

    @Test
    public void testEntityToDto(){
        SocialNetworkPostEntity entity = socialNetworkPostEntity();
        SocialNetworkPostDto result = SocialNetworkPostMapper.INSTANCE.entityToDto(entity);
        assertAll(
                ()->assertEquals(1l,result.getId()),
                ()->assertNotNull(result.getPostDate()),
                ()->assertEquals("author",result.getAuthor()),
                ()->assertEquals("content",result.getContent()),
                ()->assertEquals(123,result.getViewCount())
        );
    }

    @Test
    public void testDtoToEntity(){
        SocialNetworkPostDto dto = socialNetworkPostDto();
        SocialNetworkPostEntity result = SocialNetworkPostMapper.INSTANCE.dtoToEntity(dto);
        assertAll(
                ()->assertEquals(1l,result.getId()),
                ()->assertNotNull(result.getPostDate()),
                ()->assertEquals("author",result.getAuthor()),
                ()->assertEquals("content",result.getContent()),
                ()->assertEquals(123,result.getViewCount())
        );

    }

    @Test
    public void testEntitiesToDtos(){
        List<SocialNetworkPostEntity> entities = List.of(socialNetworkPostEntity());
        SocialNetworkPostDto result = SocialNetworkPostMapper.INSTANCE.entitiesToDtos(entities).get(0);
        assertAll(
                ()->assertEquals(1l,result.getId()),
                ()->assertNotNull(result.getPostDate()),
                ()->assertEquals("author",result.getAuthor()),
                ()->assertEquals("content",result.getContent()),
                ()->assertEquals(123,result.getViewCount())
        );
    }
}
