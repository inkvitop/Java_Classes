package filters;

import objects.Book;
import converters.JsonToObj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Years {
    List<Book> booksList;
    List<Integer> publishersYearsList = new ArrayList<>();

    public Years() {
        JsonToObj arrObj = new JsonToObj();
        this.booksList = arrObj.jsonToObj();
    }

    public void allYearsPublishing() {
        booksList.forEach(book -> {
            publishersYearsList.add(book.getYear());
        });

        List<Integer> resultPublishersYearsList = new ArrayList<>(publishersYearsList);

        // remove double years
        for (int i = 0; i < resultPublishersYearsList.size(); i++) {
            if (Collections.frequency(resultPublishersYearsList, resultPublishersYearsList.get(i)) > 1) {
                resultPublishersYearsList.remove(i);
                i--;
            }
        }

        for (Integer publisher : resultPublishersYearsList) {
            int publisherBookCount = Collections.frequency(publishersYearsList, publisher);
            System.out.println("- Publishing House: " + publisher + ".   sort.Books published: " + publisherBookCount + ".");
        }
    }
}
