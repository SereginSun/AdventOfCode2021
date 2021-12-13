package app;

import day13.PartOne;
import day13.PartTwo;

import java.util.function.Consumer;
import java.io.File;

public class Main {
    private final Consumer<String> output;
    private final Reader input;

    public Main(Consumer<String> output, Reader reader) {
        this.output = output;
        this.input = reader;
    }

    public void init() {
        File file = input.getFileFromResource("day13.txt");
        input.readFileToList(file);
        Solution task1 = new PartOne(input, output);
        task1.solution();
        Solution task2 = new PartTwo(input, output);
        task2.solution();
    }

    public static void main(String[] args) {
        Main start = new Main(System.out::println, new Reader());
        start.init();
    }
}
