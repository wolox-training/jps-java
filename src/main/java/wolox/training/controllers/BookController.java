package wolox.training.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api
public class BookController {

    private final BookRepository repository;



    /**
     * this method find all books
     */
    @GetMapping
    public Iterable findAll() {
        return repository.findAll();
    }


    @ApiOperation(value = "search by id, return a book", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Successfully retrieved book"),
            @ApiResponse(code = 401,message = "you are not authorized for this resource"),
            @ApiResponse(code = 404,message = "the book are not found")
    })
    @GetMapping("/{id}")
    public Book findById(@ApiParam(value = "id of the book",required = true,example = "1")
            @PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException());
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
        if(!bookNew.getId().equals(id)) {
            throw new BookIdMismatchException();
        }
        repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException() );
        return repository.save(bookNew);
    }

}
