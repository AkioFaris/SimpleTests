package utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataHandler {

	public static final String currentDirectory = System.getProperty("user.dir");

	public static List<String> readPersInfFromFile(String iFilePath) throws IOException, URISyntaxException {
		Path path = Paths.get(currentDirectory + iFilePath);
		return Files.lines(path).collect(Collectors.toList());
	}

	public static void executeScriptWithParam(String scriptPath, String param)
			throws IOException, InterruptedException {
		File autoIt = new File(scriptPath);
		Process p = Runtime.getRuntime().exec(autoIt.getAbsolutePath() + " " + param);
		p.waitFor();
	}

}
