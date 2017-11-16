package net.willeh.run;

import java.net.*;
import java.io.*;

public class InRead {
	private String requestUrl;
	private String pageData;
	    
		public InRead(String requestUrl) {
	    	this.requestUrl = requestUrl;
	    	this.pageData = this.refreshPage();
	    }
	    public String refreshPage()
	    {
	    	try {
	    	int x = 0;
	    	String webTemp = "";
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
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		return null;
	    	}
	    }
		/**
		 * @return the requestUrl
		 */
		public String getRequestUrl() {
			return requestUrl;
		}
		/**
		 * @param requestUrl the url to read
		 */
		public void newRequest(String requestUrl) {
			this.requestUrl = requestUrl;
			this.pageData = this.refreshPage();
		}
		/**
		 * @return the pageData
		 */
		public String getPageData() {
			return pageData;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "InRead [pageData=" + pageData + "]";
		}
		
	}

