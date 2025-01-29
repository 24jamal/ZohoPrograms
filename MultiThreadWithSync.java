class Table {

    synchronized public void printtable(int n) {
        for (int i = 1; i <= 5; i++) {
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

public class MultiThreadWithSync {

    public static void main(String[] args) {

        Table table = new Table();

        Thread t1 = new Thread() {
            public void run() {
                table.printtable(2);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                table.printtable(2);
            }
        };

        t1.start();
        t2.start();

    }
}