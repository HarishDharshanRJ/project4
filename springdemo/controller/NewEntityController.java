package com.example.springdemo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.entity.NewEntity;
import com.example.springdemo.repository.NewRepo;
import com.example.springdemo.service.DemoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Runboat")
public class NewEntityController {
	
	@Autowired
	public DemoService dser;
	@PostMapping(" ")
	public NewEntity addDetails(@RequestBody NewEntity Ne)
	{
		return dser.saveDetails(Ne);
	}
	@GetMapping(" ")
	public List<NewEntity> read()
	{
		return dser.getDetails();
	}
	@GetMapping("/{treeid}")
	public Optional<NewEntity> readById(@PathVariable int id)
	{
		return dser.getDetailsById(id);
	}
	@PutMapping("/Update")
	public String update(@RequestBody NewEntity lp_model)
	{
		return dser.updateDetails(lp_model);
	}
	@DeleteMapping("/Delete")
	public String delete(@RequestParam ("tid") int id)
	{
		return dser.deleteByRequestParamId(id);
	}
	
	@GetMapping("/sortAsc/{gender}")
	public List<NewEntity> sortAscend(@PathVariable("gender") String id)
	{
		return dser.sortAsc(gender);
	}
	@GetMapping("/sortDesc/{gender}")
	public List<NewEntity> sortDesc(@PathVariable("gender") String gender)
	{
		return dser.sortDesc(gender);
	}
	
	@GetMapping("/pagination/{pageNo}/{pageSize}")
	public List<NewEntity> paginationData(@PathVariable("pageNo")int pnu,@PathVariable("pageSize") int psize)
	{
		return dser.paginationData(pnu,psize);
	}
	
	@GetMapping("/pagiantionAndSorting/{pageNo}/{pageSize}/{treename}")
	public List<NewEntity> paginationAndSorting(@PathVariable("pageNo") int pnu,@PathVariable("pageSize") int psize,@PathVariable("treename") String treename)
	{
		return dser.paginationAndSorting(pnu, psize, gender);
	}
	
	@Autowired
	public NewRepo tre; 
	
	@GetMapping("getG")
	public List<NewEntity> getD()
	{
		return tre.getALLData();
	}
	
	@GetMapping("byOwnerName/{id}")
	public List<NewEntity> getName(@PathVariable("id") int gid)	{
		return tre.byOwnerName(gid);
	}
	
	@GetMapping("startend/{start}/{end}")
	public List<NewEntity> startEnd(@PathVariable("start") int start,@PathVariable("end") int end)	{
		return tre.startEnd(start,end);
	}
	
	@DeleteMapping("delete/{id}/{name}")
	public String deleteGarage(@PathVariable("id") int id,@PathVariable("name") String oname)
	{
		tre.deleteDet(id, oname);
		return "Deleted";
	}
	
	@GetMapping("jpql")
	public List<NewEntity> getJp()
	{
		return tre.getAll();
	}
	
	@GetMapping("jp/{id}")
	public List<NewEntity> getjpql(@PathVariable("id")int gid)
	{
		return tre.jpql(gid);
	}
}