package co.com.need.configuration;

import co.com.need.dto.ErrorDTO;
import co.com.need.exception.ExpiredTokenException;
import co.com.need.exception.InvalidTokenException;
import co.com.need.util.StatusEnum;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerControllerAdvice {

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorDTO> handleInvalidToken(HttpServletRequest req, Exception ex) {
        return new ResponseEntity<>(
            new ErrorDTO(StatusEnum.CODE_INVALID_TOKEN.get(), StatusEnum.DESC_INVALID_TOKEN.get()),
            HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<ErrorDTO> handleExpiredToken(HttpServletRequest req, Exception ex) {
        return new ResponseEntity<>(
            new ErrorDTO(StatusEnum.CODE_EXPIRED_TOKEN.get(), StatusEnum.DESC_EXPIRED_TOKEN.get()),
            HttpStatus.UNAUTHORIZED);
    }
}
