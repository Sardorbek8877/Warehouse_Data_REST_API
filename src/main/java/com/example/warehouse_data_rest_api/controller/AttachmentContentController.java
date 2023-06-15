package com.example.warehouse_data_rest_api.controller;

import com.example.warehouse_data_rest_api.entity.AttachmentContent;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.AttachmentContentDto;
import com.example.warehouse_data_rest_api.service.AttachmentContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/attachmentContent")
public class AttachmentContentController {

    @Autowired
    AttachmentContentService attachmentContentService;

    /**
     * GET AttachmentContents
     * @return List<AttachmentContent>
     */
    @GetMapping
    public ResponseEntity<List<AttachmentContent>> getAttachmentContents(){
        List<AttachmentContent> attachmentContent = attachmentContentService.getAttachmentContent();
        return ResponseEntity.ok(attachmentContent);
    }

    /**
     * GET AttachmentContentById
     * @param id
     * @return AttachmentContent
     */
    @GetMapping("/{id}")
    public ResponseEntity<AttachmentContent> getAttachmentContentById(@PathVariable Integer id){
        AttachmentContent attachmentContentById = attachmentContentService.getAttachmentContentById(id);
        return ResponseEntity.ok(attachmentContentById);
    }

    /**
     * ADD AttachmentContent
     * @param attachmentContentDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addAttachmentContent(@RequestBody AttachmentContentDto attachmentContentDto){
        ApiResponse apiResponse = attachmentContentService.addAttachmentContent(attachmentContentDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT AttachmentContent
     * @param attachmentContentDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editAttachmentContent(@RequestBody AttachmentContentDto attachmentContentDto, Integer id){
        ApiResponse apiResponse = attachmentContentService.editAttachmentContent(attachmentContentDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE AttachmentContent
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAttachmentContent(@PathVariable Integer id){
        ApiResponse apiResponse = attachmentContentService.deleteAttachmentContent(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
