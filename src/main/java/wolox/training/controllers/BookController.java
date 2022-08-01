package wolox.training.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import wolox.training.exceptions.book.BookIdMismatchException;
import wolox.training.exceptions.book.BookNotFoundException;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final String ID_NOT_FOUND = "Book not found";
    private final BookRepository repository;

    /**
     * this method create a greeting with a name or for default is world
     * @param name : Name of the sender (String)
     *
    */
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }


    /**
     * this method find all books
     */
    @GetMapping
    public Iterable findAll() {
        return repository.findAll();
    }


    /**
     * this method save the book
     * @param book = object of type(Book)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }


    /**
     * this method delete the book by id
     * @param id = id for delete the book
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException() );
        repository.deleteById(id);
    }


    /**
     * this method updated the book by id
     * @param bookNew = object of type Book
     * @param id = id for update the book (must be equals to Book.id)
     */
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book bookNew, @PathVariable Long id) {
        if(bookNew.getId() != id) {
            throw new BookIdMismatchException();
        }
        repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException() );
        return repository.save(bookNew);
    }

}
