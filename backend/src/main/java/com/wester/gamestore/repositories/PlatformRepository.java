package com.wester.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wester.gamestore.entities.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
