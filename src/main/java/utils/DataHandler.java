package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataHandler {

	public static List<String> readPersInfFromFile(String iFilePath) throws IOException, URISyntaxException{
		String currentDirectory = System.getProperty("user.dir");
		Path path = Paths.get(currentDirectory + iFilePath);
		return Files.lines(path).collect(Collectors.toList());
	}
	
}
