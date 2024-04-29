package Project.seleniumframework;

public interface TimeOuts {
	
	ConfigManager config = new ConfigManager();
	
	public static final int VERYSHORTWAIT = Integer.parseInt(config.getProperty("VERYSHORTWAIT"));
	public static final int SHORTWAIT = Integer.parseInt(config.getProperty("SHORTWAIT"));
	public static final int LONGWAIT = Integer.parseInt(config.getProperty("LONGWAIT"));
	public static final int VERYLONGWAIT = Integer.parseInt(config.getProperty("VERYLONGWAIT"));
	
	public static void implicitWait(int timeInSeconds) {
		
	}
	
	public static void explicitWait(int timeInSeconds) {
		
	}
	
}
