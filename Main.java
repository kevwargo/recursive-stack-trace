public class Main {

    public static void main(String args[]) {
        final Object monitor = new Object();
        final MyThread t1 = new MyThread() {
                public void run() {
                    synchronized (monitor) {
                        printStackTraces(System.out);
                    }
                }
            };
        final MyThread t2 = new MyThread() {
                public void run() {
                    t1.start();
                    synchronized (monitor) {
                        printStackTraces(System.out);
                    }
                }
            };
        final MyThread t3 = new MyThread() {
                public void run() {
                    t2.start();
                    synchronized (monitor) {
                        printStackTraces(System.out);
                    }
                }
            };
        t3.start();
    }
    
}

