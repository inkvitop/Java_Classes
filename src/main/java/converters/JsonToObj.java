package converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonToObj {
    List<objects.Book> booksList;

    public List<objects.Book> jsonToObj() {
        final ObjectMapper objectMapper = new ObjectMapper();

        try {
            booksList = objectMapper.readValue(
                    new File("src/main/resources/Books.json"),
                    new TypeReference<List<objects.Book>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return booksList;
    }
}




