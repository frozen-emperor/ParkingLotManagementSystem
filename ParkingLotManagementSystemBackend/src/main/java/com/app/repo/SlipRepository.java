package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.SlipEntity;

@Repository
public interface SlipRepository extends JpaRepository<SlipEntity, Integer>{

}
