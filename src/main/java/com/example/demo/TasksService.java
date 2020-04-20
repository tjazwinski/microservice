package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Task;
import com.example.demo.jpa.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TasksService {

	Logger logger = Logger.getLogger(TasksService.class.getCanonicalName());

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/list/{userId}")
	public List<Task> getTasks(@PathVariable Long userId) {
		logger.info("Pobieram liste taskow : " + userId);		
		return taskRepository.findByUserId(userId);
	}

	@GetMapping("/task/{id}")
	public Task getTask(@PathVariable Long id) {
		return taskRepository.findById(id).get();
	}

	@PostMapping("/task")
	public List<Task> addTask(Task task) {
		taskRepository.save(task);
		return getTasks(task.getUserId());
	}

	@PutMapping("/task")
	public void setDone(Long id) {
		taskRepository.setDone(id);
	}
}
