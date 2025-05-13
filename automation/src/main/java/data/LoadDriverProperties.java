package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadDriverProperties {
	static public String filePath = System.getProperty("user.dir")+ "\\src\\main\\java\\Properties\\driverData.properties";
	static public Properties driverData = loadProperties(filePath);
	
	private static Properties loadProperties(String filePath) {
		Properties pro = new Properties();
		try {
			FileInputStream stream = new FileInputStream(filePath);
			pro.load(stream);
		}catch(IOException e) {
				System.out.println("Error Occupied " + e.getMessage());
		}
		return pro;
	}

}
