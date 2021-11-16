package filters;

import objects.Book;
import converters.JsonToObj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Publishers {
    List<Book> booksList;
    List<String> publishersList = new ArrayList<>();
    List<String> publisherBooks = new ArrayList<>();
    List<Integer> publisherBooksId = new ArrayList<>();

    public Publishers() {
        JsonToObj arrObj = new JsonToObj();
        this.booksList = arrObj.jsonToObj();
    }

    public void allPublishersNames() {
        booksList.forEach(book -> {
            publishersList.add(book.getPublishing());
        });

        List<String> resultPublishersList = new ArrayList<>(publishersList);

        // remove double names
        for (int i = 0; i < resultPublishersList.size(); i++) {
            if (Collections.frequency(resultPublishersList, resultPublishersList.get(i)) > 1) {
                resultPublishersList.remove(i);
                i--;
            }
        }

        for (String publisher : resultPublishersList) {
            int publisherBookCount = Collections.frequency(publishersList, publisher);
            System.out.println("- Publishing House: " + publisher + ".   sort.Books published: " + publisherBookCount + ".");
        }
    }

    public void allPublisherBooks(String publisherName) {
        booksList.forEach(book -> {
            if (Objects.equals(book.getPublishing(), publisherName)) {
                publisherBooks.add(book.getName());
                publisherBooksId.add(book.getId());
            }
        });
        System.out.println("*****");
        if (publisherBooks.size() > 0) {
            System.out.println("All books published by \"" + publisherName + "\" Publishing House:");
            for (int i = 0; i < publisherBooks.size(); i++) {
                System.out.println("- id: " + publisherBooksId.get(i) + "; book.Book title: " + publisherBooks.get(i) + ";");
            }
        } else {
            System.out.println("Incorrect publishing house entered");
        }
        System.out.println("*****");
    }
}
