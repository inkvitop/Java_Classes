package filters;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import console.ConsoleOutput;
import converters.JsonToObj;
import objects.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BooksSort {
    RemoveMultipleValues removeMultipleValues;
    ConsoleOutput consoleOutput;

    List<Book> booksList;
    List<String> authorsList;
    List<String> publishersList;
    List<Integer> publishersYearsList;
    List<String> result;
    List<Integer> resultId;
    List<Integer>resultYear;
    List<Object> booksNameList;
    List<Object> booksIdList;

    public BooksSort() {
        JsonToObj arrObj = new JsonToObj();
        this.booksList = arrObj.jsonToObj();

        removeMultipleValues = new RemoveMultipleValues();
        consoleOutput = new ConsoleOutput();
    }

    public void allBooks() {
        booksNameList = new ArrayList<>();
        booksIdList = new ArrayList<>();

        booksList.forEach(book -> {
            booksIdList.add(book.getId());
            booksNameList.add(book.getName());
        });

        consoleOutput.allBooks(booksNameList, booksIdList);
    }

    public void allAuthorsName() {
        authorsList = new ArrayList<>();

        booksList.forEach(book -> {
            authorsList.add(book.getAuthor());
        });

        List<String> resultAuthorsList = new ArrayList<>(authorsList);
        consoleOutput.allAuthors(removeMultipleValues.remove(resultAuthorsList), authorsList);
    }

    public void allPublishersNames() {
        publishersList = new ArrayList<>();

        booksList.forEach(book -> {
            publishersList.add(book.getPublishing());
        });

        List<String> resultPublishersList = new ArrayList<>(publishersList);
        consoleOutput.allPublishers(removeMultipleValues.remove(resultPublishersList), publishersList);
    }

    public void allYearsPublishing() {
        List<Integer> resultIntPublishersYearsList;
        publishersYearsList = new ArrayList<>();

        booksList.forEach(book -> {
            publishersYearsList.add(book.getYear());
        });

        List<String> resultPublishersYearsList = new ArrayList<>(Lists.transform(publishersYearsList, Functions.toStringFunction()));
        removeMultipleValues.remove(resultPublishersYearsList);

        resultIntPublishersYearsList = resultPublishersYearsList.stream().map(Integer::valueOf).collect(Collectors.toList());;
        consoleOutput.allYears(resultIntPublishersYearsList, publishersYearsList);
    }

    public void getFullBookInformation(int inputBookId) {
        int bookId = -1;
        String resultBook;

        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getId() == inputBookId) {
                bookId = i;
            }
        }

        if (bookId != -1) {
            resultBook = booksList.get(bookId).toString();
            consoleOutput.bookInfo(resultBook);
        } else {
            consoleOutput.inputIdError();
        }
    }

    public void getAllAuthorsBooks(String authorName) {
        result = new ArrayList<>();
        resultId = new ArrayList<>();

        booksList.forEach(book -> {
            if (Objects.equals(book.getAuthor(), authorName)) {
                result.add(book.getName());
                resultId.add(book.getId());
            }
        });

        consoleOutput.allAuthorBooks(result, resultId, authorName);
    }

    public void getAllPublisherBooks(String publisherName) {
        result = new ArrayList<>();
        resultId = new ArrayList<>();

        booksList.forEach(book -> {
            if (Objects.equals(book.getPublishing(), publisherName)) {
                result.add(book.getName());
                resultId.add(book.getId());
            }
        });

        consoleOutput.allPublisherBooks(result, resultId, publisherName);
    }

    public void getAllBooksAfterYear(int year) {
        result = new ArrayList<>();
        resultId = new ArrayList<>();
        resultYear = new ArrayList<>();

        booksList.forEach(book -> {
            if (book.getYear() > year) {
                result.add(book.getName());
                resultId.add(book.getId());
                resultYear.add(book.getYear());
            }
        });

        consoleOutput.allBookAfterYear(result, resultId, resultYear, year);
    }
}
