package com.starter.repo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.starter.pojo.Result_fx_db;

public interface ForexRepo extends CrudRepository<Result_fx_db, Integer>{
	List<Result_fx_db> findAll();
	List<Result_fx_db> findTop5ByOrderByTransIdDesc();

}




