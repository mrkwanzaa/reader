package net.willeh.run;

public class Main {

	public static void main(String[] args) {
		download.start();
		try
		{
			download.join();
		}
		catch (InterruptedException e) 
		{
		
			e.printStackTrace();
		}
	
	}
	static Thread download = new Thread(){
		public void run(){
			try {
				InRead reader = new InRead("https://www.google.com/");
				System.out.println(reader.getPageData());
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	};

}
