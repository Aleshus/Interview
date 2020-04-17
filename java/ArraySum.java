import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

import java.util.Arrays;

public class ArraySum {

    public static int arrayPlusArray(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1).sum() + Arrays.stream(arr2).sum();
    }

    public static void main(String[] args) {
        assertEquals(21, arrayPlusArray(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }));
        assertEquals(-21, arrayPlusArray(new int[] { -1, -2, -3 }, new int[] { -4, -5, -6 }));
        assertEquals(15, arrayPlusArray(new int[] { 0, 0, 0 }, new int[] { 4, 5, 6 }));
        assertEquals(2100, arrayPlusArray(new int[] { 100, 200, 300 }, new int[] { 400, 500, 600 }));
        System.out.println("Everything is ok!");
    }
}