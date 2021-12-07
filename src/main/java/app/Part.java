package app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Part {
    private final Reader input;
    private final Consumer<String> output;

    public Part(Reader input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }

    public Reader getInput() {
        return input;
    }

    public Consumer<String> getOutput() {
        return output;
    }

    public List<Integer> getListCrabPositions(Reader input) {
        List<String> store = new ArrayList<>(input.getList());
        String[] ageArr = store.get(0).split(",");
        List<Integer> crabPosition = new ArrayList<>();
        for (String s : ageArr) {
            crabPosition.add(Integer.parseInt(s));
        }
        return crabPosition;
    }
}
