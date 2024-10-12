package TP_Strategy.src.Approach2;

public class Sorter {
    private SortingStrategy strategy;
    private int[] data;

    public Sorter(int[] data) {
        this.data = data;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] getData() {
        return data;
    }

    public void performSort() {
        strategy.sort();
    }
}
