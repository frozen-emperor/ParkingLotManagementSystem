package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.SlotEntity;

@Repository
public interface SlotRepository extends JpaRepository<SlotEntity, Integer>{

}
