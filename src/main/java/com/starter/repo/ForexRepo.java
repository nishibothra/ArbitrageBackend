package com.starter.repo;
import java.awt.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.starter.pojo.Result_fx_db;

public interface ForexRepo extends CrudRepository<Result_fx_db, Integer>{
	Iterable<Result_fx_db> findAll();
}




