package parsing.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.containsString;

import static org.hamcrest.core.IsCollectionContaining.hasItem;



import pojo.DocumentsInfo;

public class JsonParsingTest {

	DocumentsInfo docInfo;

	@BeforeMethod
	public void setUp() throws JsonSyntaxException, JsonIOException, IOException {
		String fileName = "\\src\\test\\resources\\json_examples\\documents_info.json";
        String jsonPath = System.getProperty("user.dir") + fileName;
		Gson gson = new Gson();
		BufferedReader jsonReader = Files.newBufferedReader(Paths.get(jsonPath));
		docInfo = gson.fromJson(jsonReader, DocumentsInfo.class);
	}

	@Test
	public void checkDocumentsCount() {
		Integer nuberOfFiles = new Integer(100);
		assertThat(docInfo.addedDocumentCount, greaterThanOrEqualTo(nuberOfFiles));
	}
	
	@Test
	public void checkDocumentPresence(){
		String documentNamePart = "r-00002-c6d98c10";
		assertThat(docInfo.documentFiles, hasItem(containsString(documentNamePart)));
	}

}
