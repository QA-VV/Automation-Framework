package Project.seleniumframework;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	
	
	public static void configReader() throws IOException {
	
	FileReader fr = new FileReader("/Users/vikasverma/eclipse-workspace/seleniumframework/src/main/java/Project/seleniumframework/resources/config.properties");
	
	Properties config = new Properties();
	config.load(fr);
	
	}
	

}
