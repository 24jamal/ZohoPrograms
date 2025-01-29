public class PetrolBunk {

    public static int remainingpetrol(int petrol, int[] distances, int[] bunks) {
        for (int i = 0; i < distances.length; i++) {

            petrol -= distances[i];

            System.out.println("Remaining Petrol after reaching Bunk :" + i + " is " + petrol);
            if (petrol < 0) {
                return -1;
            }

            petrol += bunks[i];

        }

        return petrol;

    }

    public static void main(String[] args) {

        int petrol = 2;
        int[] distances = { 1, 5, 3 };
        int[] bunks = { 6, 4, 2 };

        int rempetrol = remainingpetrol(petrol, distances, bunks);

        if (rempetrol > 0) {
            System.out.println("Remaining Petrol :" + rempetrol);
        }

        else {
            System.out.println("Out of Petrol");
        }

    }
}
