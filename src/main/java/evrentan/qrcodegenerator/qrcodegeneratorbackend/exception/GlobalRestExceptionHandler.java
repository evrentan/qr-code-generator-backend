package evrentan.qrcodegenerator.qrcodegeneratorbackend.exception;

import com.google.zxing.WriterException;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.dto.shared.CustomRestError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Global Exception Handler Class
 *
 * @author <a href="https://github.com/nmarulo">nmarulo</a>
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalRestExceptionHandler {
    
    /**
     * To handle error cases in I/O operations and return an internal server error.
     *
     * @param exception IOException
     * @param request   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/nmarulo">nmarulo</a>
     * @since 1.0.0
     */
    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<CustomRestError> processIOException(final Exception exception, final HttpServletRequest request) {
        var customRestError = CustomRestError.builder()
                                             .message(exception.getCause()
                                                               .getMessage())
                                             .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                             .build();
        
        return responseEntity(customRestError);
    }
    
    /**
     * To handle error cases that may occur when encoding a barcode and returning bad request.
     *
     * @param exception WriterException
     * @param request   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/nmarulo">nmarulo</a>
     * @since 1.0.0
     */
    @ExceptionHandler(value = {WriterException.class})
    public ResponseEntity<CustomRestError> processWriteException(final Exception exception, final HttpServletRequest request) {
        var customRestError = CustomRestError.builder()
                                             .message(exception.getCause()
                                                               .getMessage())
                                             .status(HttpStatus.BAD_REQUEST.value())
                                             .build();
        
        return responseEntity(customRestError);
    }
    
    /**
     * To build ResponseEntity with CustomerRestError
     *
     * @param customRestError CustomerError to build the ResponseEntity
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/nmarulo">nmarulo</a>
     * @since 1.0.0
     */
    private static ResponseEntity<CustomRestError> responseEntity(CustomRestError customRestError) {
        return ResponseEntity.status(HttpStatus.valueOf(customRestError.getStatus()))
                             .body(customRestError);
    }
    
}
