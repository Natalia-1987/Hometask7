import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private short age;
    private List<Book> books = new ArrayList<Book>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public short getAge(){
        return age;
    }

    public void setAge(short age){
        this.age = age;
    }

    public List<Book> getBooks(){
        return books;
    }

    public void setBooks(List<Book> books){
        this.books = books;
    }
}
