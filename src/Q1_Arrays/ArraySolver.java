package Q1_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySolver {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40, 50};

        System.out.println("--- Question 1: Clone Array ---");
        int[] clonedArray = cloneArray(myArray);
        System.out.println("Original: " + Arrays.toString(myArray));
        System.out.println("Cloned:   " + Arrays.toString(clonedArray));

        System.out.println("\n--- Question 3: Remove Specific Element ---");
        System.out.print("Enter element to remove from " + Arrays.toString(myArray) + ": ");
        int target = input.nextInt();
        int[] newArray = removeElement(myArray, target);

        if (newArray != null)
            System.out.println("After Removal: " + Arrays.toString(newArray));
        else
            System.out.println("Element not found!");
    }

    // حل السؤال الأول: نسخ المصفوفة
    public static int[] cloneArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // حل السؤال الثالث: حذف عنصر معين
    public static int[] removeElement(int[] arr, int element) {
        int count = 0;
        for (int x : arr) {
            if (x == element) count++;
        }

        if (count == 0) return null;

        int[] newArr = new int[arr.length - count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element) {
                newArr[index++] = arr[i];
            }
        }
        return newArr;
    }
}