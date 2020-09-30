package com.starter.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.starter.pojo.FRADataDb;


public interface FRARepo extends JpaRepository<FRADataDb, Timestamp>{
	List<FRADataDb> findTop5ByOrderByTransIdDesc();

}
