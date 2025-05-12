import java.util.Arrays;

public class PrintElements {
    public static void main(String[] args) {
        int[] a = {5, 10, 15, 20, 25};

        System.out.println("All elements in the array:");
        for (int num : a) {
            System.out.println(num);
        }

        System.out.println("First element: " + a[0]);
        System.out.println("Last element: " + a[a.length - 1]);
        System.out.println("Full array using Arrays.toString(): " + Arrays.toString(a));
    }
}
