public class Threadabc {
    static String str = "A";

    public static void main(String[] args) {
        Object lock = new Object();

        class Task implements Runnable {
            private String b;
            private String nextb;

            public Task(String b, String nextb) {
                this.b = b;
                this.nextb = nextb;
            }

            @Override
            public void run() {
                for (int i = 0; i<5; i++) {
                    synchronized (lock) {
                        try {
                            while (!str.equals(b))
                                lock.wait();
                            System.out.print(b);
                            str = nextb;
                            Thread.sleep(1);
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        new Thread(new Task("A","B")).start();
        new Thread(new Task("B","C")).start();
        new Thread(new Task("C","A")).start();

    }
}
