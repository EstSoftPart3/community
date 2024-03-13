package com.community.fo.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.community.fo.jpa.entity.SampleEntity;
@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long>{
	List<SampleEntity> findAll(Sort sort);

}
