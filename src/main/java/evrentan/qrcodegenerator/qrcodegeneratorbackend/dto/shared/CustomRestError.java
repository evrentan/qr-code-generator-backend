package evrentan.qrcodegenerator.qrcodegeneratorbackend.dto.shared;

import lombok.Builder;
import lombok.Data;

/**
 * Custom Rest Error class in order to handle returned error objects
 *
 * @author <a href="https://github.com/nmarulo">nmarulo</a>
 * @since 1.0.0
 */
@Data
@Builder
public class CustomRestError {
    
    /**
     * Status of the customized REST error in Integer type.
     *
     * @since 1.0.0
     */
    private Integer status;
    
    /**
     * Message of the customized REST error in String type.
     *
     * @since 1.0.0
     */
    private String message;
    
}
