package net.willeh.run;

public class Main {

	public static void main(String[] args) {
	download.start();
	try {
		download.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("first");
	}
	static Thread download = new Thread(){
		public void run(){
			try {
				System.out.println(InRead.main("https://www.google.com/"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	};

}
