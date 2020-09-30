package com.starter.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.pojo.Result_fx_db;

public interface ForexRepo extends JpaRepository<Result_fx_db, Integer>{
	List<Result_fx_db> findTop7ByOrderByTransIdDesc();

}




