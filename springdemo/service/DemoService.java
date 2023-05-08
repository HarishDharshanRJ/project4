
package com.example.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springdemo.entity.DemoEntity;
import com.example.springdemo.repository.DemoRepository;
import com.example.springdemo.repository.NewRepo;

@Service
public class DemoService {
	@Autowired
	DemoRepository ss_repo;
	@Autowired
	NewRepo ss_Mapping;
	public String addSS(DemoEntity ss_model)
	{
		ss_repo.save(ss_model);
		return "Added!";
	}
	public List<DemoEntity> getSS()
	{
		return ss_repo.findAll();
	}
	public Optional<DemoEntity> getSSById(int id)
	{
		return ss_repo.findById(id);
	}
	public String updateSS(DemoEntity ss_model)
	{
		ss_repo.save(ss_model);
		return "Updated!";
	}
	public String deleteByRequestParamId(int sign_no)
	{
		ss_repo.deleteById(sign_no);
		return "Deleted!";
	}
	public String checkLogin(String uname, String pwd){
		DemoEntity user = ss_repo.findByuname(uname);
		if(user == null) {
			return "no user found";
		}
		else {
			if(user.getPwd().equals(pwd)) {
				return"Login Succesfull";
			}
			else 
			{
				return "Login Failed";
			}
		}
	}
	public DemoEntity addUser(DemoEntity game) {
		return ss_repo.save(game);
	}
	public List<DemoEntity> getUser(){
		return ss_repo.findAll();
	}
	//sorting
	public List<DemoEntity>sort(String field)
	{
		return ss_repo.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	//pagination
	public List<DemoEntity>paging( int offset,int pagesize)
	{
		Page<DemoEntity> page=ss_repo.findAll(PageRequest.of(offset,  pagesize));
		return page.getContent();
	}

}
	


