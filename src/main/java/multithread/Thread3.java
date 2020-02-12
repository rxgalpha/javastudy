package multithread;

public class Thread3 implements Runnable {
    //两个线程操作同一个对象，共享成员变量
    //int i;
    @Override
    public void run() {
        //两个线程操作同一个对象，各自保存局部变量的拷贝
        int i = 0;
        while(i<10){
            System.out.println(i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
