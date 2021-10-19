package demchyna.patientms.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NullReferenceEntityException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Error nullReferenceEntityHandler(HttpServletRequest request, NullReferenceEntityException exception) {
        String errorURL = request.getRequestURL().toString();
        String errorMessage = exception.getMessage();

        return new Error(HttpStatus.BAD_REQUEST.value(), errorURL, errorMessage);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Error entityNotFoundHandler(HttpServletRequest request, EntityNotFoundException exception) {
        String errorURL = request.getRequestURL().toString();
        String errorMessage = exception.getMessage();

        return new Error(HttpStatus.NOT_FOUND.value(), errorURL, errorMessage);
    }

    @ExceptionHandler(value = PSQLException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Error sqlRequestHandler(HttpServletRequest request, PSQLException exception) {
        String errorURL = request.getRequestURL().toString();
        String errorMessage = exception.getMessage();

        return new Error(HttpStatus.BAD_REQUEST.value(), errorURL, errorMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public Error internalServerErrorHandler(HttpServletRequest request, Exception exception) {
        String errorURL = request.getRequestURL().toString();
        String errorMessage = exception.getMessage();

        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorURL, errorMessage);
    }
}
