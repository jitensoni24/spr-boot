package com.dtech.boot.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.boot.web.model.Topic;

@RestController
public class TopicsController {

	List<Topic> topicsList;
	
	public void setTopicsList(List<Topic> topics) {
		this.topicsList = topics;
	}
	
	@GetMapping("/topics")
	public List<Topic> all() {
		return topicsList;
	}
}
