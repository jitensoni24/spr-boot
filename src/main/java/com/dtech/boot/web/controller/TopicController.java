package com.dtech.boot.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.boot.web.resource.Topic;

@RestController
public class TopicController {

	List<Topic> topicsList;
	
	public void setTopicsList(List<Topic> topics) {
		this.topicsList = topics;
	}
	
	@GetMapping("/topics")
	public List<Topic> all() {
		return topicsList;
	}
	
	@GetMapping("/topics/{id}")
	public Topic get(String id) {
		return topicsList.get(0);
	}
	
	@PostMapping("/topics")
	public Topic create(Topic topic) {
		return topicsList.get(0);
	}
	
	@PostMapping("/topics")
	public Topic update(Topic topic) {
		return topicsList.get(0);
	}
	
	@DeleteMapping("/topics/{id}")
	public void delete(String id) {
		
	}
}
