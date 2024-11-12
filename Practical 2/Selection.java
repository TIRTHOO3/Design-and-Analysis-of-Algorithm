import java.util.Scanner;

class Selection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10000];
        System.out.println("random:");
        for (int i = 0; i < num.length; i++) {
            num[i] = i;

        }
        System.out.println("Before using SelectionSort of Array");
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i] + "");
        }
        long startTime = System.currentTimeMillis();

        System.out.println();

        System.out.println("Before SelectionSort");
        for (int i : num) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < num.length - 1; i++) {
            int ind = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[ind]) {
                    ind = j;
                }
            }

            int small = num[ind];
            num[ind] = num[i];
            num[i] = small;

        }

        System.out.println("After Selection Sort");
        for (int i : num) {
            System.out.print(i + " ");
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("  ");
        System.out.println("\nThe time duration is : " + duration);

    }
}