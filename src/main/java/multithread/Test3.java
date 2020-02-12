package multithread;

public class Test3 {

	public static void main(String[] args) {
	    Thread3 myThread = new Thread3();
	    //下面两个线程对同一个对象(Runnable的实现类对象)进行操作
	    Thread thread = new Thread(myThread);
	    Thread thread2 = new Thread(myThread);
	    //各自保存局部变量的拷贝，互不影响，输出200个数字
	    System.out.println(thread.getState());//NEW
	    thread.start();
	    thread2.start(); 
	    System.out.println(thread.getState());//RUNNABLE
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(thread.getState());//TIMED_WAITING
	}
}
