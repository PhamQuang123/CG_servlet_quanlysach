package cg.session10_quanlysach.model;

public class Book {
    private int bookId;
    private String bookName;
    private float price;
    private String description;
    private String auth;

    public Book() {
    }

    public Book(int bookId, String bookName, float price, String description, String auth) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.description = description;
        this.auth = auth;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
