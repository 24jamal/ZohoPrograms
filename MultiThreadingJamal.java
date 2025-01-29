// class Number extends Thread {

//     public void run() {

//         for (int i = 0; i < 5; i++) {
//             System.out.println("Number is Printing : " + i);
//             try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }

//         }
//     }
// }

////////////////////////////////////////////////////////
// class Number implements Runnable {

// public void run() {

// for (int i = 0; i < 5; i++) {
// System.out.println("Number is Printing : " + i);
// try {
// Thread.sleep(1000);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }

// }
// }
//}

// class UpdateDB1 extends Thread {

// public void run() {

// for (int i = 0; i < 5; i++) {
// System.out.println("DB is updating...");
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }

// }
// }
// }

public class MultiThreadingJamal {

    public static void main(String[] args) {

        // Implementing Runnable without Class Object - But we Runnable : Thread class
        // Start
        // Number number = new Number();
        // UpdateDB1 updateDB1 = new UpdateDB1();

        // number.start();
        // updateDB1.start();

        // Runnable implemented with Class Object
        // Runnable number = new Number();
        // Thread t1 = new Thread(number);

        // t1.start();

        /////////////////////////////////

        Runnable number = new Runnable() {
            public void run() {

                for (int i = 0; i < 5; i++) {
                    System.out.println("Number is Printing : " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        };

        ////////////////////////////////////////////////
        ///
        Runnable number1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Number is Printing : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        };

        Thread t1 = new Thread(number);

        Thread t2 = new Thread(number1);

        t1.start();

        t2.start();
    }

}
