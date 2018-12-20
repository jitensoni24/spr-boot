package com.dtech.boot.web.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;


/**
	create helm deployments<br>
	territory = gb, it, de<br>
	env = auto-test, manual-test, dev-edge, dev-stable, integration, ethan-lab, ref-lab
*/
public class CreateHelmResources {

	public static void main(String[] args) throws IOException {
		
		ClassPathResource classPathResource = new ClassPathResource("template.yaml");
		String file = IOUtils.toString(classPathResource.getInputStream(), Charset.forName("UTF-8"));
		
		Stream.of("gb","it", "de")
		.forEach(territory -> {
            try {
                Path path = Files.createDirectories(Paths.get(System.getProperty("user.home") + "/Desktop/resource-dirs/"));
                
                Stream.of("auto-test", "manual-test", "dev", "integration", "ethan-lab", "ref-lab")
                	.forEach(env -> {
                		try {
                			
                			if(territory.equals("gb") && (env.equals("ethan-lab") || env.equals("ethan-lab"))) {
                				return; //only skip this iteration
                			}
                			
							Path filePath = Files.createFile(Paths.get(path + "/" + territory + "-" + env + ".yaml"));
							
							String content = file.replace("{ENV}", env).replace("{TERRITORY}", territory);
							
							Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE);

							System.out.println(filePath);
							
						} catch (IOException e) {
							e.printStackTrace();
						}
                });
                
            } catch (IOException e) {}
        });
	}
	
}
