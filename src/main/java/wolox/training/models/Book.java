package wolox.training.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String Publisher;
    @Column(nullable = false)
    private String Year;
    @Column(nullable = false)
    private int Pages;
    @Column(nullable = false)
    private String isbn;
}
