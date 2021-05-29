package FileReader;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesFileReader {
	
	public static String[] propertiesFileReader(String[] Honda) {//protoType takes the keys[] and returns the values[]
		
		String data[] = new String[Honda.length];//length is taken from the given array in code


		Properties prop = new Properties();
		
		 try {
				InputStream input = new FileInputStream("configuration.properties");//reads the configuration file and adds to input file
			
					prop.load(input);
				}
				catch (IOException e) { 
					e.printStackTrace();
					// TODO Auto-generated catch block
					
				}
		 
		  
	
		 
		 for(int j = 0 ; j < Honda.length ; j++) {
			 
		 data[j] = prop.getProperty(Honda[j]);
		
		}
		 
		 
		 
		return data;
		
	}
		
	
}
