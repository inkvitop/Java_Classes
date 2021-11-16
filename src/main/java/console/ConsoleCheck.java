package console;

import filters.BooksSort;

public class ConsoleCheck {
    ConsoleOutput consoleOutput;
    BooksSort booksSort;

    public ConsoleCheck() {
        consoleOutput = new ConsoleOutput();
        booksSort = new BooksSort();
    }

    public void commandCheck(String[] inputCommand) {
        if (inputCommand.length == 1) {
            switch (inputCommand[0]) {
                case "-book": {
                    booksSort.allBooks();
                    break;
                }
                case "-author": {
                    booksSort.allAuthorsName();
                    break;
                }
                case "-publisher": {
                    booksSort.allPublishersNames();
                    break;
                }
                case "-year": {
                    booksSort.allYearsPublishing();
                    break;
                }
                default: {
                    consoleOutput.inputError();
                }
            }
        } else if (inputCommand.length == 2){
            switch (inputCommand[0]) {
                case "-book": {
                    booksSort.getFullBookInformation(Integer.parseInt(inputCommand[1]));
                    break;
                }
                case "-author": {
                    booksSort.getAllAuthorsBooks(inputCommand[1]);
                    break;
                }
                case "-publisher": {
                    booksSort.getAllPublisherBooks(inputCommand[1]);
                    break;
                }
                case "-year": {
                    booksSort.getAllBooksAfterYear(Integer.parseInt(inputCommand[1]));
                    break;
                }
                default: {
                    consoleOutput.inputError();
                }
            }
        } else {
            consoleOutput.inputError();
        }
    }
}
