package com.wester.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wester.gamestore.entities.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
