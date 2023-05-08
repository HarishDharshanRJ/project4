package com.example.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.springdemo.entity.NewEntity;
import com.example.springdemo.repository.NewRepo;

@Service
public class NewEntityService {
	@Autowired                      
	NewRepo new;
	public NewEntity saveDetails(NewEntity tm)
	{
		return new.save(tm);
	}
	public List<NewEntity> getDetails()
	{
		return new.findAll();
	}
	public Optional<NewEntity> getDetailsById(int id)
	{
		return new.findById(id);
	}
	public String updateDetails(NewEntity lp_model)
	{
		new.save(lp_model);
		return "Updated!";
	}
	public String deleteByRequestParamId(int id)
	{
		new.deleteById(id);
		return "Deleted!";
	}
	public NewRepo getTre() {
		return new;
	}
	public void setTre(NewRepo tre) {
		this.new = new;
	}
    
	// sorting
	public List<NewEntity> sortAsc(String field) 
	{
		return new.findAll(Sort.by(field).ascending());
	}
	
	public List<NewEntity> sortDesc(String field)
	{
		return new.findAll(Sort.by(field).descending());
	}
	
	// Pagination
	public List<NewEntity> paginationData (int pageNo, int pageSize) 
	{
		Page<NewEntity> p = new.findAll(PageRequest.of(pageNo, pageSize));
		return p.getContent();
	}
	
	// PaginationAndSorting
	public List<NewEntity> paginationAndSorting(int pageNo, int pagesize,String field)
	{
		Page<NewEntity> p = new.findAll(PageRequest.of(pageNo, pagesize, Sort.by(field).ascending()));
		return p.getContent();
	}
}
