package com.example.warehouse_data_rest_api.controller;

import com.example.warehouse_data_rest_api.entity.Output;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.OutputDto;
import com.example.warehouse_data_rest_api.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/output")
public class OutputController {

    @Autowired
    OutputService outputService;

    /**
     * Get Outputs
     * @return List<Output>
     */
    @GetMapping
    public ResponseEntity<List<Output>> getOutputs(){
        List<Output> outputs = outputService.getOutputs();
        return ResponseEntity.ok(outputs);
    }

    /**
     * GET Output BY iD
     * @param id
     * @return Output
     */
    @GetMapping("/{id}")
    public ResponseEntity<Output> getOutput(@PathVariable Integer id){
        Output output = outputService.getOutput(id);
        return ResponseEntity.ok(output);
    }

    /**
     * ADD Output
     * @param outputDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addOutput(@RequestBody OutputDto outputDto){
        ApiResponse apiResponse = outputService.addOutput(outputDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT Output
     * @param outputDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editOutput(@RequestBody OutputDto outputDto, @PathVariable Integer id){
        ApiResponse apiResponse = outputService.editOutput(outputDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE Output
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOutput(@PathVariable Integer id){
        ApiResponse apiResponse = outputService.deleteOutput(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
