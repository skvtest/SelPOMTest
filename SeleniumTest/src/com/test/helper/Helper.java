package com.test.helper;

public class Helper {

	public void readDataFromPropertiesFile(){
		ReadWriteData data = new ReadWriteData();
		data.LoadFile();
		String browserName = data.readBrowserName();
		String URL = data.readURL();
	}
}
