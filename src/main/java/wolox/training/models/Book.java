package wolox.training.models;

import com.google.common.base.Preconditions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
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
@ApiModel(description = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ApiModelProperty(notes = "can be comedy,drama,etc..",example = "comedy")
    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)

    private String subtitle;
    @Column(nullable = false)
    /**
     * this is the name publisher of book
     */
    private String publisher;
    @Column(nullable = false)

    /**
     * this is the year of publication of book
     */
    private String year;
    @Column(nullable = false)

    private int pages;
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
    private User user;

    public void setGenre(String genre) {
        this.genre =  Preconditions.checkNotNull(genre);
    }

    public void setImage(String image) {
        this.image =  Preconditions.checkNotNull(image);
    }

    public void setTitle(String title) {
        this.title =  Preconditions.checkNotNull(title);
    }

    public void setIsbn(String isbn) {
        this.isbn =  Preconditions.checkNotNull(isbn);
    }

    public void setUser(User user) {
        this.user =  Preconditions.checkNotNull(user);
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = Preconditions.checkNotNull(subtitle);
    }

    public void setPublisher(String publisher) {
        this.publisher = Preconditions.checkNotNull(publisher);
    }

    public void setYear(String year) {
        this.year = Preconditions.checkNotNull(year);
    }

    public void setPages(int pages) {
        this.pages = Preconditions.checkNotNull(pages);
    }
}
