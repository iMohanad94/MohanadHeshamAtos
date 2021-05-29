package FileReader;


import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;

public class jsonfile {

  public static String[][] json_reader(int x,int y) {

		String [][]data = new String[x][y];

      try {

          JSONParser parser = new JSONParser();
          JSONArray jsonarr = (JSONArray) parser.parse(new FileReader("jsonfile.json"));
          
        for(int i = 0 , j = 3 ; i < x ; i++) {
        	  
          JSONObject jsonobject = (JSONObject)jsonarr.get(i);
          
         data[i][0] = (String) jsonobject.get("name");

          data[i][1] = (String) jsonobject.get("Phone");

          	}

      } catch(Exception e) {
    	  e.printStackTrace();
      }
      
      return data;
  }
}