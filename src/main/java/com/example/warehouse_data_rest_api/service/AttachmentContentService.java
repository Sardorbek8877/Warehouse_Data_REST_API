package com.example.warehouse_data_rest_api.service;

import com.example.warehouse_data_rest_api.entity.Attachment;
import com.example.warehouse_data_rest_api.entity.AttachmentContent;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.AttachmentContentDto;
import com.example.warehouse_data_rest_api.repository.AttachmentContentRepository;
import com.example.warehouse_data_rest_api.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentContentService {

    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    /**
     * GET AttachmentContents
     * @return List<AttachmentContent>
     */
    public List<AttachmentContent> getAttachmentContent(){
        return attachmentContentRepository.findAll();
    }

    /**
     * GET AttachmentContentById
     * @param id
     * @return AttachmentContent
     */
    public AttachmentContent getAttachmentContentById(Integer id){
        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);
        return optionalAttachmentContent.orElse(null);
    }

    /**
     * ADD AttachmentContent
     * @param attachmentContentDto
     * @return ApiResponse
     */
    public ApiResponse addAttachmentContent(AttachmentContentDto attachmentContentDto){

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(attachmentContentDto.getAttachmentId());
        if (optionalAttachment.isEmpty())
            return new ApiResponse("Attachment not found", false);
        Attachment attachment = optionalAttachment.get();

        AttachmentContent attachmentContent = new AttachmentContent();

        attachmentContent.setBytes(attachmentContentDto.getBytes());
        attachmentContent.setAttachment(attachment);
        attachmentContentRepository.save(attachmentContent);
        return new ApiResponse("Attachment Content added", true);
    }

    /**
     * EDIT AttachmentContent
     * @param attachmentContentDto
     * @param id
     * @return ApiResponse
     */
    public ApiResponse editAttachmentContent(AttachmentContentDto attachmentContentDto, Integer id){
        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);
        if (optionalAttachmentContent.isEmpty())
            return new ApiResponse("Attachment Content not found", false);
        AttachmentContent attachmentContent = optionalAttachmentContent.get();

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(attachmentContentDto.getAttachmentId());
        if (optionalAttachment.isEmpty())
            return new ApiResponse("Attachment not found", false);
        Attachment attachment = optionalAttachment.get();

        attachmentContent.setAttachment(attachment);
        attachmentContent.setBytes(attachmentContentDto.getBytes());
        attachmentContentRepository.save(attachmentContent);
        return new ApiResponse("Attachment Content edited", true);
    }

    /**
     * DELETE AttachmentContent
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteAttachmentContent(Integer id){
        try {
            attachmentContentRepository.deleteById(id);
            return new ApiResponse("Attachment Content deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("AttachmentContent", false);
        }
    }
}
