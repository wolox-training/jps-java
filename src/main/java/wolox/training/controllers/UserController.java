package wolox.training.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import wolox.training.exceptions.user.UserIdMismatchException;
import wolox.training.exceptions.user.UserNotFoundException;
import wolox.training.models.Book;
import wolox.training.models.Users;
import wolox.training.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private final UserRepository userRepository;
    private final Users user;




    /**
     * this method find all User
     */
    @GetMapping
    public List<Users> findAll() {
        return userRepository.findAll();
    }


    /**
     * this method save the users
     * @param users = object of type(User)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users users) {
        return userRepository.save(users);
    }


    /**
     * this method delete the User by id
     * @param id = id for delete the User
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException() );
        userRepository.deleteById(id);
    }


    /**
     * this method updated the User by id
     * @param users = object of type User
     * @param id = id for update the User (must be equals to User.id)
     */
    @PutMapping("/{id}")
    public Users updateBook(@RequestBody Users users, @PathVariable Long id) {
        if(users.getId() != id) {
            throw new UserIdMismatchException();
        }
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException() );
        return userRepository.save(users);
    }


    /**
     * this method add the book to the collection
     */
    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addBookToCollection(@RequestBody Book book ) {
        return user.addBook(book);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deleteBookToTheCollection(@PathVariable Long id ) {
        return user.deleteBook(id);
    }


}
