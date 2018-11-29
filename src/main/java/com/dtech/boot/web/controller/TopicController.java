package com.dtech.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.boot.web.resource.Topic;
import com.dtech.boot.web.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> all() {
		return topicService.all();
	}
	
	@GetMapping("/topics/{id}")
	public Topic get(String id) {
		return topicService.get(id);
	}
	
	@PostMapping("/topics")
	public Topic create(Topic topic) {
		return topicService.create(topic);
	}
	
	@PutMapping("/topics")
	public Topic update(Topic topic) {
		return topicService.update(topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void delete(String id) {
		topicService.delete(id);
	}
}
