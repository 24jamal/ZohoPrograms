
// class Num extends Thread {
//     public void run() {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("number is printing " + i);
//             try {
//                 Thread.sleep(6000);
//             } catch (InterruptedException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//         }
//     }

// }

class Num extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("number is printing " + i);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

public class Threads {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");

        Runnable updateDB = () -> {

            for (int i = 0; i < 5; i++) {
                System.out.println("DB is updating " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        };
        // Num num = new Num();

        Runnable Num = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("number is printing " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        };

        Thread t1 = new Thread(updateDB);
        Thread t2 = new Thread(Num);

        t1.setName("UpDateDb");
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getName());

        t1.start();

        t2.start();

        System.out.println("Bye....");
    }

}
