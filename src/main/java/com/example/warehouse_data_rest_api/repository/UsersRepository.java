package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Users;
import com.example.warehouse_data_rest_api.projection.CustomUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "user", collectionResourceRel = "UsersList", excerptProjection = CustomUsers.class)
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @RestResource(path = "byName")
    public Page<Users> findAllByFirstName(@Param("firstName") String firstName, Pageable pageable);
}
