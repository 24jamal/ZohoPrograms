class Table {
    synchronized public void printtable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * n);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        System.out.println("Hello");

        Table table = new Table();

        Thread t1 = new Thread() {
            public void run() {
                table.printtable(2);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                table.printtable(3);
            }
        };

        t1.start();
        t2.start();
    }
}
