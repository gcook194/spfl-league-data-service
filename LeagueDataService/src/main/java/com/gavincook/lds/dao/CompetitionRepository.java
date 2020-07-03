package com.gavincook.lds.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gavincook.lds.model.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

	List<Competition> findByResourceId(Long resourceId);

}
