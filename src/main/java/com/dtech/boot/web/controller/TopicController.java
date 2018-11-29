package com.dtech.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Topic get(@PathVariable Long id) {
		return topicService.get(id);
	}
	
	@PostMapping("/topics")
	public Topic create(@RequestBody Topic topic) {
		System.out.println(topic);
		return topicService.create(topic);
	}
	
	@PutMapping("/topics")
	public Topic update(@RequestBody Topic topic) {
		return topicService.update(topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void delete(@PathVariable Long id) {
		topicService.delete(id);
	}
}
