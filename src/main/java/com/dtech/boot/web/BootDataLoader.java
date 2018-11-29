package com.dtech.boot.web;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hsqldb.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.dtech.boot.web.repository.TopicRepository;
import com.dtech.boot.web.resource.Topic;

@Configuration
public class BootDataLoader implements ApplicationRunner {

//	@Autowired
//	TopicService topicService;
	
	@Autowired
	TopicRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("~~~~~~~~~initializing data~~~~~~~~");

//		List<Topic> topicsList = new ArrayList<>();
//		IntStream.range(1, 10)
//		.forEach(i -> {
//			topicsList.add(new Topic(Long.valueOf(i), "name-"+i, "desc-"+i));
//		});
//		topicService.setTopicsList(topicsList);
		
		Resource resource = new ClassPathResource("data/data-init.xlsx");
		
		Path uri = Paths.get(resource.getURI());

	    Stream<String> lines = Files.lines(uri);
	    lines.forEach(System.out::println);
		
//		lines
//			.forEach(row -> {
//				String[] array = row.split(",");
//				System.out.println(Long.valueOf(array[0]) + array[1]+ array[2]);
//				repository.save(new Topic(Long.valueOf(array[0]), array[1], array[2]));
//			});
		
	    lines.close();
	    
		System.out.println("~~~~~~~~~data initialization complete~~~~~~~~");
	}

}
