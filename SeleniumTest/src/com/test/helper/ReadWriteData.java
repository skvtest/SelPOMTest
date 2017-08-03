package com.test.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadWriteData {
	File file = null;
	FileInputStream fis = null;
	Properties prop = null;
	
	public void LoadFile(){
		file = new File("D:/swati/workspace/SeleniumTest/src/com/test/Files/DataFile.properites");
		
		try {
			fis = new FileInputStream(file);
		}catch(FileNotFoundException e){
			System.out.println(" File not found error thrown: ");
		}
		
		prop = new Properties();
		
		//Load Properties file:
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println(" File properties are not loaded: ");
		}
		
	}
	
	public String readURL(){
		return prop.getProperty("URL");
		
	}
	
	public String readBrowserName(){
		return prop.getProperty("browser");
		
	}
	
	public static void main(String[] args){
		ReadWriteData obj = new ReadWriteData();
		obj.LoadFile();
		System.out.println("Value: " +obj.readURL());
		//System.out.println("value from Data file:" +prop.getProperty("URL"));
	}
	
	
	
	
	

}
