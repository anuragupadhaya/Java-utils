package com.eanurag.web.scrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * Simple html+text scrapper from any website
 * 
 * @author anurag
 *
 */
public class GenericWebsiteTextScrapper {

	/**
	 * @param website
	 * @param userAgent
	 */
	public static void scrapWebsiteText(String website, String userAgent) {
		URL url;

		try {
			url = new URL(website);
			URLConnection connection = url.openConnection();

			Properties config = new Properties();
			config.load(GenericWebsiteTextScrapper.class.getClassLoader().getResourceAsStream("user-agent.properties"));

			if (null == userAgent || userAgent.isEmpty()) {
				userAgent = config.getProperty("google-chrome");
			}

			connection.setRequestProperty("User-Agent", userAgent);

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}

			reader.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
