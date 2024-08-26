package properity;

public class FileReaderManager {
	
	private FileReaderManager() {
		
	}
	
	private static FileReaderManager fr;
	
	public static FileReaderManager getInstanceFileReaderManager() {
		
		if(fr == null) {
			fr = new FileReaderManager();
		}
		return fr;
		
		
	}

	public ConfigReader getInstanceConfigurationReader() {
		ConfigReader cf = new ConfigReader();
		return cf;
	}
}
