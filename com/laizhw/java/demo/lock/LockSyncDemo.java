package demo.lock;


public class LockSyncDemo {

    final Object object = new Object();

    public void m1 (){
        synchronized (object) {
            System.out.println("--- hello synchronized code block");
        }
    }


    public static void main(String[] args) {


    }

}
