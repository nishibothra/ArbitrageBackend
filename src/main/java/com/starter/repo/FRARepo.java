package com.starter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starter.pojo.FRADataDb;


public interface FRARepo extends JpaRepository<FRADataDb, Integer>{
	List<FRADataDb> findTop7ByOrderByTransIdDesc();

}
