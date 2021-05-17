package com.flamexander.spring.security.cookbook.dao.repositories;

import com.flamexander.spring.security.cookbook.dao.enities.Permission;
//import com.flamexander.spring.security.cookbook.dao.enities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {
}
