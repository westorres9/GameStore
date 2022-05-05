package com.wester.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wester.gamestore.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
