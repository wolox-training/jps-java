package wolox.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book bot found")
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
