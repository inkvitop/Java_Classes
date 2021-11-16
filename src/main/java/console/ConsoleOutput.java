package console;

import java.util.Collections;
import java.util.List;

public class ConsoleOutput {
    public void instruction() {
        System.out.println("******************************************");
        System.out.println("This program will help you work with the database. The database stores data about books about the Java language.");
        System.out.println("-book               (Get a list of all books)");
        System.out.println("-book <id>          (Get complete information about the book. Enter the ID of the book.)");
        System.out.println("-author             (Get a list of all authors)");
        System.out.println("-author <name>      (Get a list of all books written by an author. Enter the name of the author.)");
        System.out.println("-publisher          (Get a list of all publishing houses)");
        System.out.println("-publisher <name>   (Get a list of books published by a specific publisher. Enter the name of the publishing house.)");
        System.out.println("-year               (Get a list of all the years in which the books were published)");
        System.out.println("-year <year>        (Get a list of all books published after the entered year. Enter the year.)");
        System.out.println("-help               (List of all available commands)");
        System.out.println("******************************************");
    }

    public void exit() {
        System.out.println("---------------------------------");
        System.out.println("Terminating the program");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
    }

    public void inputError() {
        System.out.println("!!! Invalid command entered. Try again !!!");
    }

    public void inputIdError() {
        System.out.println("!!! The ID entered does not exist !!!");
    }


    public void allBooks(List<Object> booksNameList, List<Object> booksIdList) {
        System.out.println("------------------------------->");

        for (int i = 0; i < booksIdList.size(); i++) {
            System.out.println("Id:  " + booksIdList.get(i) + "; \nbook.Book title:  " + booksNameList.get(i));
            System.out.println("---");
        }

        System.out.println("\n! To get complete information about the book, enter its ID");
        System.out.println("--------------------------------");
    }

    public void bookInfo(String resultBook) {
        System.out.println("--------------------------------");
        System.out.println("A book was found at your request. Here are the details information.");
        System.out.println(resultBook);
        System.out.println("--------------------------------");
    }

    public void allAuthors(List<String> resultAuthorsList, List<String> authorsList) {
        System.out.println("------------------------------->");
        for (String author : resultAuthorsList) {
            int authorBookCount = Collections.frequency(authorsList, author);
            System.out.println("- Author: " + author + ". sort.Books written by him: " + authorBookCount + ".");
            System.out.println("---");
        }
        System.out.println("\n! To get a list of books by a particular author, enter his name");
        System.out.println("--------------------------------");
    }

    public void allAuthorBooks(List<String> resultBooks, List<Integer> resultBooksId, String authorName) {
        System.out.println("--------------------------------");
        if (resultBooks.size() > 0) {
            System.out.println("All books written by the author \"" + authorName + "\":");
            for (int i = 0; i < resultBooks.size(); i++) {
                System.out.println("- id: " + resultBooksId.get(i) + "; Book title: " + resultBooks.get(i) + ";");
                System.out.println("---");
            }
        } else {
            System.out.println("Incorrect author entered");
        }
        System.out.println("--------------------------------");
    }

    public void allPublishers(List<String> resultPublishersList, List<String> publishersList) {
        System.out.println("------------------------------->");
        for (String publisher : resultPublishersList) {
            int publisherBookCount = Collections.frequency(publishersList, publisher);
            System.out.println("- Publishing House: " + publisher + ". Books published: " + publisherBookCount + ".");
            System.out.println("---");
        }
        System.out.println("\n! To get a list of books for a particular publishing house, enter its name");
        System.out.println("--------------------------------");
    }

    public void allPublisherBooks(List<String> result, List<Integer> resultId, String publisherName) {
        System.out.println("--------------------------------");
        if (result.size() > 0) {
            System.out.println("All books published by \"" + publisherName + "\" Publishing House:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println("- id: " + resultId.get(i) + "; book.Book title: " + result.get(i) + ";");
                System.out.println("---");
            }
        } else {
            System.out.println("Incorrect publishing house entered");
        }
        System.out.println("--------------------------------");
    }

    public void allYears(List<Integer> resultPublishersYearsList, List<Integer> publishersYearsList) {
        System.out.println("------------------------------->");
        for (Integer publisher : resultPublishersYearsList) {
            int publisherBookCount = Collections.frequency(publishersYearsList, publisher);
            System.out.println("- Publishing House: " + publisher + ".   sort.Books published: " + publisherBookCount + ".");
            System.out.println("---");
        }
        System.out.println("\n! To get a list of books released after a given year, enter the year");
        System.out.println("--------------------------------");
    }

    public void allBookAfterYear(List<String> resultName, List<Integer> resultId, List<Integer> resultYear, int year) {
        System.out.println("--------------------------------");
        System.out.println("List of all books issued after - " + year + ":");
        for (int i = 0; i < resultId.size(); i++) {
            System.out.println("- id: " + resultId.get(i) + "; Year: " + resultYear.get(i) + "; Book title: " + resultName.get(i) + ";");
            System.out.println("---");
        }
        System.out.println("--------------------------------");
    }
}
