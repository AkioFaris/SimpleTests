package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataHandler {

	private static String currentDirectory = System.getProperty("user.dir");
	public static List<String> readPersInfFromFile(String iFilePath) throws IOException, URISyntaxException{
		Path path = Paths.get(currentDirectory + iFilePath);
		return Files.lines(path).collect(Collectors.toList());
	}
	
	public static void executeScript(String scriptLocalPath) throws IOException {
//		Runtime.getRuntime().exec(currentDirectory + scriptLocalPath);
		Runtime.getRuntime().exec("E:\\Projects\\Automated_testing\\work\\SimpleTests\\src\\test\\resources\\load_pic.exe");

	}
	
}
