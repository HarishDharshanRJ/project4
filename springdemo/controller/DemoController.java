package com.example.springdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.entity.DemoEntity;
import com.example.springdemo.service.DemoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;

@RestController
public class DemoController {
	@Autowired
	DemoService ss_service;

	@Operation(summary = "Creates a new data")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = " Created Successfully!"), @ApiResponse(responseCode = "400", description = "Employee is Invalid"), @ApiResponse(responseCode = "401", description = "Invalid Credentials")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(value = "/post", produces = "application/json", consumes = "application/json")
	public String create(@RequestBody DemoEntity ss_model)
	{
		return ss_service.addSS(ss_model);
	}
	@Operation(summary = "Creates a new data")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = " Created Successfully!"), @ApiResponse(responseCode = "400", description = "Employee is Invalid"), @ApiResponse(responseCode = "401", description = "Invalid Credentials")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@GetMapping(value = "/get", produces = "application/json", consumes = "application/json")
	public List<DemoEntity> read()
	{
		return ss_service.getSS();
	}
	@Operation(summary = "Creates a new data")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created Successfully!"), @ApiResponse(responseCode = "400", description = "Employee is Invalid"), @ApiResponse(responseCode = "401", description = "Invalid Credentials")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public Optional<DemoEntity> readById(@PathVariable int id)
	{
		return ss_service.getSSById(id);
	}
	@Operation(summary = "Creates a new data")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = " Created Successfully!"), @ApiResponse(responseCode = "400", description = "Employee is Invalid"), @ApiResponse(responseCode = "401", description = "Invalid Credentials")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PutMapping(value = "/update_ss")
	public String update(@RequestBody DemoEntity ss_model) 
	{
		return ss_service.updateSS(ss_model);
	}
	@Operation(summary = "Creates a new data")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created Successfully!"), @ApiResponse(responseCode = "400", description = "Employee is Invalid"), @ApiResponse(responseCode = "401", description = "Invalid Credentials")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@DeleteMapping(value = "/delete")
	public String delete(@RequestParam ("num") int id)
	{
		return ss_service.deleteByRequestParamId(id);
	}
	
	
	

}
	

 
