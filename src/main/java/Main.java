import console.ConsoleOutput;
import console.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        ConsoleOutput console = new ConsoleOutput();
        console.instruction();
        ConsoleInput input = new ConsoleInput();
        input.newInput();
    }
}
