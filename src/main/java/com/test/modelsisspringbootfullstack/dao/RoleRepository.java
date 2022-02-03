package com.test.modelsisspringbootfullstack.dao;
import com.test.modelsisspringbootfullstack.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByRoleName(String roleName);
}
