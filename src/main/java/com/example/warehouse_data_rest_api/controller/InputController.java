package com.example.warehouse_data_rest_api.controller;

import com.example.warehouse_data_rest_api.entity.Input;
import com.example.warehouse_data_rest_api.entity.Output;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.InputDto;
import com.example.warehouse_data_rest_api.payload.OutputDto;
import com.example.warehouse_data_rest_api.service.InputService;
import com.example.warehouse_data_rest_api.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/input")
public class InputController {

    @Autowired
    InputService inputService;

    /**
     * Get Inputs
     * @return List<Input>
     */
    @GetMapping
    public ResponseEntity<List<Input>> getInputs(){
        List<Input> inputs = inputService.getInputs();
        return ResponseEntity.ok(inputs);
    }

    /**
     * GET Input BY iD
     * @param id
     * @return Input
     */
    @GetMapping("/{id}")
    public ResponseEntity<Input> getInput(@PathVariable Integer id){
        Input input = inputService.getInput(id);
        return ResponseEntity.ok(input);
    }

    /**
     * ADD Input
     * @param inputDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addInput(@RequestBody InputDto inputDto){
        ApiResponse apiResponse = inputService.addInput(inputDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT Input
     * @param inputDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editInput(@RequestBody InputDto inputDto, @PathVariable Integer id){
        ApiResponse apiResponse = inputService.editInput(inputDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE Input
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteInput(@PathVariable Integer id){
        ApiResponse apiResponse = inputService.deleteInput(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
