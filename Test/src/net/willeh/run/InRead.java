package net.willeh.run;

import java.net.*;
import java.io.*;

public class InRead {


	    public static String main(String requestUrl) throws Exception {
	    	int x = 0;
	    	String webTemp = null;
	        URL url = new URL(requestUrl);
	        URLConnection report = url.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(report.getInputStream()));
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) {
	        	if(x == 0){
	        		webTemp = inputLine;
	        		x++;
	        	}else{
	        		webTemp = webTemp + inputLine;
	        		x++;
	        		}
	        }
	            
	        in.close();
	        return webTemp;
	    }
	}

