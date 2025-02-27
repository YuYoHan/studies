package Iterator.ex01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book>{
    private List<Book> books;
    private int last =0;

    public BookShelf(int last) {
        this.books = new ArrayList<Book>(last);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(last, book);
        last++;
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

}
