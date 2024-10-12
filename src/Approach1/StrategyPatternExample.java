package Approach1;

public class StrategyPatternExample {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        // Create sorting strategies
        SortingStrategy bubbleSort = new BubbleSort();
        SortingStrategy quickSort = new QuickSort();

        // Create a sorter with the BubbleSort strategy
        Sorter sorter = new Sorter(bubbleSort);

        // Perform a sort using the BubbleSort strategy
        sorter.performSort(numbers);

        // Switch to the QuickSort strategy and perform another sort
        sorter.setStrategy(quickSort);
        sorter.performSort(numbers);
    }
}
