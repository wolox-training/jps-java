package wolox.training.models;


import com.google.common.base.Preconditions;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wolox.training.exceptions.book.BookAlreadyOwnedException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
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

    public void setUsername(String username) {
        this.username = Preconditions.checkNotNull(username);
    }

    public void setName(String name) {
        this.name = Preconditions.checkNotNull(name);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = Preconditions.checkNotNull(birthDate);
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
