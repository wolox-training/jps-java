package wolox.training.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book bot found")
@NoArgsConstructor
public class BookNotFoundException extends RuntimeException{
}
