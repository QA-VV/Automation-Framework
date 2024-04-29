package Project.seleniumframework;

 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class ConfigManager {
	
	private Properties properties = new Properties();	
	private static String configFileName;
	private Logger log = Logger.getLogger(ConfigManager.class);

	/**
	 * The default constructor initializes and reads the key values from sys.properties file
	 */
	public ConfigManager()
	{
		configFileName = "config";
	}
	
	/**
	 * Returns the value of given property from either sys.properties file  
	 * @param key - ConfigParamvalue that requires to be returned from Config.properties file
	 * @return - return ConfigValue
	 */
	public String getProperty(String key)
	{
		String value ="";
        if(key!="")
        {
			loadProperties();
			try
			{
				if(!properties.getProperty(key).trim().isEmpty())
					value = properties.getProperty(key).trim();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
        }
        else
        {
        }
        return value;
    }
	
	/**
	 * 
	 * This method is used to load properties file that has to be accessed
	 *
	 */
	private void loadProperties()
	{
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(getConfigFilePath(configFileName));
			properties.load(fis);
			fis.close();
		} 
		catch (FileNotFoundException e) 
		{
			Assert.fail("Cannot find configuration file - "+configFileName+".properties"+" at "+getConfigFilePath(configFileName));
		} 
		catch (IOException e) 
		{
			Assert.fail("Cannot read configuration file - "+" at "+getConfigFilePath(configFileName));
		}
	}


	
	/**
	 * 
	 * This method is used to get the path of specified properties file name
	 *
	 * @param File , Need to pass the name of properties file
	 * @return , returns the file path of the specified properties file
	 */
	public String getConfigFilePath(String file)
	{
		String configFilePath;
		configFilePath = getConfigFolderPath()+file+".properties";
		return configFilePath;	
	}
	
	/**
	 * 
	 * This method is used to get the location of 'ConfigFiles' folder
	 *
	 * @return, Returns the path of 'ConfigFiles' folder
	 */
	public String getConfigFolderPath()
	{
		return "/Users/vikasverma/eclipse-workspace/seleniumframework/src/main/java/Project/seleniumframework/resources/";
	}


}
