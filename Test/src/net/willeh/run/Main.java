package net.willeh.run;

public class Main {

	public static void main(String[] args) {
		InRead reader = new InRead("https://www.google.com/");
		try {
			Thread.sleep(800);
			if(reader.isPageRead())
				System.out.println(reader.getPageData());
			else
				System.out.println("Nope");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
