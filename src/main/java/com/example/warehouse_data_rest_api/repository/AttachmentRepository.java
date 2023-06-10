package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Attachment;
import com.example.warehouse_data_rest_api.projection.CustomerAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "attachment", collectionResourceRel = "AttachmentList", excerptProjection = CustomerAttachment.class)
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
