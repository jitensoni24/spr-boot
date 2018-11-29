package com.dtech.boot.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtech.boot.web.repository.TopicRepository;
import com.dtech.boot.web.resource.Topic;

@Service
public class TopicService {

	List<Topic> topicsList;
	
	public void setTopicsList(List<Topic> topics) {
		this.topicsList = topics;
	}
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> all() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic get(Long id) {
		return topicRepository.findById(id).orElse(null);
	}

	public Topic create(Topic topic) {
		
		Topic save = topicRepository.save(topic);
		
		return save;
	}

	public Topic update(Topic topic) {
		return topicRepository.save(topic);
	}

	public void delete(Long id) {
		topicRepository.delete(get(id));
	}
}
