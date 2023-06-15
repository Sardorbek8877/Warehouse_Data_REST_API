package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
}
