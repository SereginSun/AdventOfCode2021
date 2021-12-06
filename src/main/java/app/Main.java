package app;

import day6.PartOne;
import day6.PartTwo;

import java.util.function.Consumer;
import java.io.File;

public class Main {
    private final Consumer<String> output;

    public Main(Consumer<String> output) {
        this.output = output;
    }

    public void init() {
        Reader input = new Reader();
        File file = input.getFileFromResource("test.txt");
        input.readFileToList(file);
        Solution task1 = new PartOne(input, output);
        task1.solution();
        Solution task2= new PartTwo(input, output);
        task2.solution();
    }

    public static void main(String[] args) {
        Main start = new Main(System.out::println);
        start.init();
    }
}
