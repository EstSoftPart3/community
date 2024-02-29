package com.community.fo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.community.fo.jpa.entity.BoardJpaEntity;

@Repository
public interface BoardJpaRepository extends JpaRepository<BoardJpaEntity, Integer> {

}