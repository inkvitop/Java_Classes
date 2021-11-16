package objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publishing;
    private int year;
    private int pages;
    private int price;
    private String binding;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public String toString() {
        return  "Id = " + id +
                ", \nbook.Book title = '" + name + '\'' +
                ", \nAuthor = '" + author + '\'' +
                ", \nPublishing house = '" + publishing + '\'' +
                ", \nPublishing year = " + year +
                ", \nNumber of pages = " + pages +
                ", \nPrice = " + price + "$" +
                ", \nBinding type = '" + binding + '\'';
    }
}
