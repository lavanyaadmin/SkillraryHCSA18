package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtility {

	private Properties Property;
	public void PropertiesInitialization(String filepath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Property=new Properties();
		try
		{
			Property.load(fis);
		}
		catch(IOException e){
		
			e.printStackTrace();
		}
	}
		public String fetchProperty(String key) {
			return Property.getProperty(key);
			
		}
		
		
		

	

}
