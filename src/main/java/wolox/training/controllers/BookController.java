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
import wolox.training.exceptions.BookIdMismatchException;
import wolox.training.exceptions.BookNotFoundException;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final String ID_NOT_FOUND = "Book not found";
    private final BookRepository repository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

    @GetMapping
    public Iterable findAll() {
        return repository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(ID_NOT_FOUND) );
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book bookNew, @PathVariable Long id) {
        if(bookNew.getId() != id) {
            throw new BookIdMismatchException("id is different to id in the object Book");
        }
        repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(ID_NOT_FOUND) );
        return repository.save(bookNew);
    }

}
