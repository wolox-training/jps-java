package wolox.training.exceptions;


import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "you have already this book ")
@NoArgsConstructor
public class BookAlreadyOwnedException extends RuntimeException{

}