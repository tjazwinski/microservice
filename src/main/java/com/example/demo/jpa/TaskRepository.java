package com.example.demo.jpa;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUserId(Long userId);

	@Query("update Task t set t.done = 1 where t.id = :id")
	int setDone(@Param("id") Long id);
}
