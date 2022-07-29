package wolox.training.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wolox.training.exceptions.BookAlreadyOwnedException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;


    /**
     * this is the relationship with Book model
     */
    @Column(nullable = false)
    @OneToMany(mappedBy = "user")
    private List<Book> books;


    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }


    /**
     * this is the method for add a book in the collection
     */
    public boolean addBook(Book book){
        if (!books.contains(book)){
            return books.add(book);
        }else {
            throw new BookAlreadyOwnedException();
        }
    }


    /**
     * this is the method for delete a book in the collection
     */
    public boolean deleteBook(Long idBook){
        if (!books.contains(idBook)) {
            return books.remove(idBook);
        }else {
            throw new BookAlreadyOwnedException();
        }
    }
}
