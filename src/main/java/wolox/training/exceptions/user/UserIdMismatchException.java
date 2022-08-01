package wolox.training.exceptions.user;


import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "id is different to id of the object")
@NoArgsConstructor
public class UserIdMismatchException extends RuntimeException{

}
