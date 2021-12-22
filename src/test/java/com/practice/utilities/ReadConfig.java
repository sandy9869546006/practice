package com.practice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("URL");
		return url;
	}

	public String getusername() {
		String userName = pro.getProperty("username");
		return userName;
	}

	public String getpwd() {
		String pwd = pro.getProperty("pwd");
		return pwd;
	}

	public String getChromePath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}

	public String getFireFoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
}