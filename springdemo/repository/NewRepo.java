package com.example.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.NewEntity;

import jakarta.transaction.Transactional;

@Repository
public interface NewRepo extends JpaRepository< NewEntity, Integer>{
	@Query(value="select * from NewEntity",nativeQuery = true)	
	public List<NewEntity> getAllData();	

	@Query(value="select * from NewEntity where NewEntityid=:id",nativeQuery=true)
	public List<NewEntity> byOwnerName(@Param("id") int gid);

	@Query(value="select * from NewEntity where NewEntityid between :start and :end",nativeQuery=true)
	public List<NewEntity> startEnd(@Param("start") int start,@Param("end") int end);

	@Modifying
	@Transactional
	@Query(value="delete from NewEntity where NewEntityid=?1 and owner_name=?2",nativeQuery = true)
	Integer deleteDet(@Param("id")int gid,@Param("name") String oname);

	//JPQL uses Model Names
	@Query(value="select c from NewEntity c")
	List<NewEntity> getAll();

	@Query(value="select c from NewEntity c where c.NewEntityId=?1")
	public List<NewEntity> jpql(@Param("id") int gid);


	}


