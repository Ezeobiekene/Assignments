public class Book extends Item{
    private int isbn_number;
    private String author;

    public int getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(int isbn_number) {
        this.isbn_number = isbn_number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(){
        super();
        isbn_number = 0;
        author = "Unknown";
    }

    public Book(String title, int isbn_number, String author) {
        super(title);
        this.isbn_number = isbn_number;
        this.author = author;
    }

    @Override
    public String getListing(){
        return "Book Name - " + getTitle()+"\n"+
                "Author - " +getAuthor()+"\n"+
                "ISBN # - "+getIsbn_number();
    }
}
