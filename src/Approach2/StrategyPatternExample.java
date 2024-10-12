package Approach2;

public class StrategyPatternExample {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        // Create a sorter with the BubbleSort strategy
        Sorter sorter = new Sorter(numbers);
        SortingStrategy bubbleSort = new BubbleSort(sorter);
        sorter.setStrategy(bubbleSort);

        // Perform a sort using the BubbleSort strategy
        sorter.performSort();
        printArray(numbers);  // Print sorted array

        // Switch to the QuickSort strategy and perform another sort
        SortingStrategy quickSort = new QuickSort(sorter);
        sorter.setStrategy(quickSort);
        sorter.performSort();
        printArray(numbers);  // Print sorted array
    }

    // Method to print array
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

