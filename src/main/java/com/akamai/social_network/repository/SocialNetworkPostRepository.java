package com.akamai.social_network.repository;

import com.akamai.social_network.entity.SocialNetworkPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPostEntity, Long>, JpaSpecificationExecutor<SocialNetworkPostEntity> {
    Optional<SocialNetworkPostEntity> findOneById(Long id);
    void deleteById(Long id);
    @Query(value = "select * from social_network.social_network_post order by view_count desc limit 10", nativeQuery = true)
    List<SocialNetworkPostEntity> findTenMostlyViewed();
}
