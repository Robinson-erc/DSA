//code
package hashDriver;

import java.util.Objects;

public class Book {
    String title;
    String author;
    int pageCount;

    Date copyRightDate;

    public Book(String title, String author, int pageCount, Date copyRightDate) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.copyRightDate = copyRightDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Date getCopyRightDate() {
        return copyRightDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book))
            return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author) && copyRightDate.equals(book.copyRightDate);
    }

    @Override

    public int hashCode() {
        return Objects.hash(title, author, copyRightDate);
    }

    @Override
    public String toString() {
        return "[Book " + title + ", by " + author + ", " + pageCount + " pages, Copyright "
                + copyRightDate + "]";
    }
}