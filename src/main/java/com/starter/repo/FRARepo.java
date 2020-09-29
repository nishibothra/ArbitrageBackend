package com.starter.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.starter.pojo.FRADataDb;


public interface FRARepo extends CrudRepository<FRADataDb, Timestamp>{
	List<FRADataDb> findAll();
	List<FRADataDb> findTop5ByOrderByTransIdDesc();

}
