package console;

import java.util.Scanner;

public class ConsoleInput {
    ConsoleCheck consoleCheck = new ConsoleCheck();
    ConsoleOutput consoleOutput = new ConsoleOutput();

    public void newInput() {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        String[] inputArray = inputString.split(" ");

        switch (inputArray[0]) {
            case ("-help"): {
                consoleOutput.instruction();
                newInput();
                break;
            }
            case ("-book"):
            case ("-author"):
            case ("-publisher"):
            case ("-year"): {
                consoleCheck.commandCheck(inputArray);
                newInput();
                break;
            }
            case ("-exit"): {
                consoleOutput.exit();
                break;
            }
            default: {
                consoleOutput.inputError();
                newInput();
            }
        }
    }
}