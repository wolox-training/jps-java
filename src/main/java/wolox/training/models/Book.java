package wolox.training.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)

    private String Subtitle;
    @Column(nullable = false)
    /**
     * this is the name publisher of book
     */
    private String Publisher;
    @Column(nullable = false)

    /**
     * this is the year of publication of book
     */
    private String Year;
    @Column(nullable = false)

    private int Pages;
    @Column(nullable = false)

    /**
     * this is the unique number of a book
     */
    private String isbn;


    /**
     * this is the relationship with User model
     */
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users user;
}
