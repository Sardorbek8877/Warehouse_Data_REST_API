package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Category;
import com.example.warehouse_data_rest_api.projection.CustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category", collectionResourceRel = "CategoryList", excerptProjection = CustomerCategory.class)
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
