package com.sbuddy.dbrepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {
	public static Properties getDBProperties() {
		try {
			FileReader fr=new FileReader("resources/db.properties");
			Properties prop=new Properties();
			prop.load(fr);
			return prop;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
