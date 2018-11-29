package com.dtech.boot.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.dtech.boot.web.resource.Topic;
import com.dtech.boot.web.service.TopicService;

@Configuration
public class BootDataLoader implements ApplicationRunner {

	@Autowired
	TopicService topicService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("~~~~~~~~~initializing data~~~~~~~~");

		List<Topic> topicsList = new ArrayList<>();

		IntStream.range(1, 10)
		.forEach(i -> {
			topicsList.add(new Topic(Long.valueOf(i), "name-"+i, "desc-"+i));
		});
		
		topicService.setTopicsList(topicsList);

		System.out.println("~~~~~~~~~data initialization complete~~~~~~~~");
	}

}
