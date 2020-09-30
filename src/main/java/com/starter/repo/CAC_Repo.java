package com.starter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.pojo.ResultCAC_db;

public interface CAC_Repo extends JpaRepository<ResultCAC_db, Integer>{ 
	List<ResultCAC_db> findTop5ByOrderByTransIdDesc() ;
		// TODO Auto-generated method stub
	
}