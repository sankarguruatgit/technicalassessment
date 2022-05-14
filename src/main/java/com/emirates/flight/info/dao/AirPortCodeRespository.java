package com.emirates.flight.info.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emirates.flight.info.model.AirportCodeEntity;

@Repository
@Transactional
public interface AirPortCodeRespository extends 
JpaRepository<AirportCodeEntity, Long>{

}
