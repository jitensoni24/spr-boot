package com.dtech.boot.web.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Class for generating profile directories for new PIQ platform.
 * 
 * Run the class with java command 
 * <pre>
 * {@code
 * java CreateProfileDirs
 * }
 * </pre>
 * 
 * This will create directories in home -> <<user>> -> Desktop -> profile-dirs -> .. <br><br>
 * 
 */
public class CreateProfileDirs {

    public static void main(String[] args) throws IOException {
        
    	
    	createDirs();
        
    	
    }

    /**
     * 
       local, dev-gb, manual-test-gb, auto-test-gb
       integration, stage, production
       gb, it, de
       
     */
	private static void createDirs() {
		Stream.of("local","dev-gb", "manual-test-b", "auto-test-gb")
        .forEach(dir -> {
            try {
                Path path = Files.createDirectories(Paths.get(System.getProperty("user.home") + "/Desktop/profile-dirs/" + dir));
                
                System.out.println(path);
                
                Files.createFile(Paths.get(path + "/" + "persistence.properties"));
                Files.createFile(Paths.get(path + "/" + "application.properties"));
            } catch (IOException e) {}
        });
        
        Stream.of("integration", "stage", "production")
           .forEach(env -> {
               Stream.of("gb", "it", "de")
                   .forEach(territory -> {
                       try {
                           Path path = Files.createDirectories(Paths.get(System.getProperty("user.home") + "/Desktop/profile-dirs/" + env + "-" + territory));
                           
                           System.out.println(path);

                           Files.createFile(Paths.get(path + "/" + "persistence.properties"));
                           Files.createFile(Paths.get(path + "/" + "application.properties"));
                           
                       } catch (IOException e) {}
                   });
           });
	}
}
