package multithread;

public class Test2 {

	public static void main(String[] args) {
        new Thread(new Thread2("C")).start();  
        new Thread(new Thread2("D")).start();  
	}
}
