package net.willeh.run;

import java.net.*;
import java.util.concurrent.Executors;
import java.io.*;

public class InRead {
	private String requestUrl;
	private String pageData;
	private boolean pageRead;
		public InRead(String requestUrl) {
	    	this.requestUrl = requestUrl;
	    	this.refreshPage();
	    }
	    public void refreshPage()
	    {
	    	pageRead = false;
	    	Executors.newCachedThreadPool().execute(new Runnable() {
			    @Override
			    public void run() {
			        dataLoad();
			    }
			});
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
			this.refreshPage();
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
		private void dataLoad()
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
		        this.pageData = webTemp;
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    		this.pageData = null;
		    	}
			this.pageRead = true;
		}
		/**
		 * @return the pageRead
		 */
		public boolean isPageRead() {
			return pageRead;
		}
		
		
	}

