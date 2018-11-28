package com.dtech.boot.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.dtech.boot.web.controller.TopicController;
import com.dtech.boot.web.resource.Topic;

@Configuration
public class BootDataLoader implements ApplicationRunner {

	@Autowired
	TopicController topicController;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("~~~~~~~~~initializing data~~~~~~~~");

		List<Topic> topicsList = new ArrayList<>();

		IntStream.range(1, 10)
		.forEach(i -> {
			topicsList.add(new Topic("id-"+i, "name-"+i, "desc-"+i));
		});
		
		topicController.setTopicsList(topicsList);

		System.out.println("~~~~~~~~~data initialization complete~~~~~~~~");
	}

}
