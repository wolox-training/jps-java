package wolox.training.exceptions.user;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User bot found")
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException{
}
