package com.dtech.boot.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.dtech.boot.web.aspect.LogTime;
import com.dtech.boot.web.repository.TopicRepository;
import com.dtech.boot.web.resource.Topic;

@Configuration
public class BootDataLoader implements ApplicationRunner {

//	@Autowired
//	TopicService topicService;
	
	@Autowired
	TopicRepository repository;
	
	@Autowired
	ResourceLoader resourceLoader;

	Predicate<? super String> allDataColumnsPresent = row -> row.split(",").length > 2;
	
	@Override
	@LogTime
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("\n~~~~~~~~~~~~~~~~~Initializing data~~~~~~~~~~~~~~");
		
		Resource resource = resourceLoader.getResource("classpath:data/small.csv");
		
		Path uri = Paths.get(resource.getURI());

	    Stream<String> lines = Files.lines(uri);

	    List<Topic> topics = new ArrayList<>();
		 
		lines
			.skip(1)							//skip the heading
			.filter(allDataColumnsPresent)		//check if three columns data present ID, Name, Description
			.forEach(row -> {
				String[] array = row.split(",");
				topics.add(new Topic(Long.valueOf(array[0]), array[1], array[2]));
			});
		
	    lines.close();
	    
	    repository.saveAll(topics);
	    
	    System.out.println("Populated DB with [" + repository.count() + "] entries");
	    
		System.out.println("~~~~~~~~~Data initialization complete~~~~~~~~\n");
	}

	public void staticData() {
//		List<Topic> topicsList = new ArrayList<>();
//		IntStream.range(1, 10)
//		.forEach(i -> {
//			topicsList.add(new Topic(Long.valueOf(i), "name-"+i, "desc-"+i));
//		});
//		topicService.setTopicsList(topicsList);
		
	}
}
