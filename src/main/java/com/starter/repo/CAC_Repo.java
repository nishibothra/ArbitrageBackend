package com.starter.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.starter.pojo.ResultCAC_db;

public interface CAC_Repo extends CrudRepository<ResultCAC_db, Integer>{ 

	List<ResultCAC_db> findAll();
	List<ResultCAC_db> findTop5ByOrderByTransIdDesc();
}