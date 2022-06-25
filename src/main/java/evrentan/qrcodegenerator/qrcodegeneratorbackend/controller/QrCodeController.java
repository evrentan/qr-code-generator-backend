package evrentan.qrcodegenerator.qrcodegeneratorbackend.controller;

import evrentan.qrcodegenerator.qrcodegeneratorbackend.dto.GenerateQrCodeRequest;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.service.QrCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.net.URI;

/**
 * REST Controller for QR Code related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/qrCode", consumes = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "QR Code Related APIs")
public class QrCodeController {

  private final QrCodeService qrCodeService;


  /**
   * REST end-point in order to generate QR code in Base64 String with POST operation.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param generateQrCodeRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   * @return String within ResponseEntity which corresponds to generated QR Code in base64 String.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PostMapping(value = "/generate/qrCodeString", produces = MediaType.IMAGE_PNG_VALUE)
  @Operation(summary = "Generate QR Code in Base64 String", description = "Generate QR Code in Base64 String")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "201", description  = "Successfully Generate QR Code in Base64 String"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<String> generateQrCodeStringWithPost(@RequestBody @NotNull GenerateQrCodeRequest generateQrCodeRequest) {
    return ResponseEntity.created(URI.create(generateQrCodeRequest.getQrCodeText()))
        .body(this.qrCodeService.generateQrCodeString(generateQrCodeRequest));
  }

  /**
   * REST end-point in order to generate QR code in Base64 String with GET operation.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param qrCodeText qr code text in string type that is used to generate QR Code.
   * @return String within ResponseEntity which corresponds to generated QR Code in base64 String.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/generate/qrCodeString", produces = MediaType.IMAGE_PNG_VALUE)
  @Operation(summary = "Generate QR Code in Base64 String", description = "Generate QR Code in Base64 String")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Generate QR Code in Base64 String"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<String> generateQrCodeStringWithGet(@RequestParam (value = "qrCodeText") @NotNull String qrCodeText) {
    return ResponseEntity.ok(this.qrCodeService.generateQrCodeString(GenerateQrCodeRequest.builder().qrCodeText(qrCodeText).build()));
  }

  /**
   * REST end-point in order to generate QR code in byteArray format with POST operation.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param generateQrCodeRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   * @return byte[] within ResponseEntity which corresponds to generated QR Code.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @PostMapping(value = "/generate/qrCodeByteArray", produces = MediaType.IMAGE_PNG_VALUE)
  @Operation(summary = "Generate QR Code in ByteArray Format with Post Operation", description = "Generate QR Code in ByteArray Format with Post Operation")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "201", description  = "Successfully Generate QR Code in ByteArray Format with Post Operation"),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<byte[]> generateQrCodeByteArrayWithPost(@RequestBody @NotNull GenerateQrCodeRequest generateQrCodeRequest) {
    return ResponseEntity.created(URI.create(generateQrCodeRequest.getQrCodeText()))
        .body(this.qrCodeService.generateQrCodeByteArray(generateQrCodeRequest));
  }

  /**
   * REST end-point in order to generate QR code in byteArray format with GET operation.
   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
   *
   * @param qrCodeText qr code text in string type that is used to generate QR Code.
   * @return byte[] within ResponseEntity which corresponds to generated QR Code.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @GetMapping(value = "/generate/qrCodeByteArray", produces = MediaType.IMAGE_PNG_VALUE)
  @Operation(summary = "Generate QR Code in ByteArray Format with Get Operation ", description = "Generate QR Code in ByteArray Format with Get Operation ")
  @ApiResponses(value = {
      @ApiResponse(responseCode  = "200", description  = "Successfully Generate QR Code in ByteArray Format with Get Operation "),
      @ApiResponse(responseCode  = "400", description  = "Bad Request"),
      @ApiResponse(responseCode  = "404", description  = "Not Found"),
      @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
  })
  public ResponseEntity<byte[]> generateQrCodeByteArrayWithGet(@RequestParam (value = "qrCodeText") @NotNull String qrCodeText) {
    return ResponseEntity.ok(this.qrCodeService.generateQrCodeByteArray(GenerateQrCodeRequest.builder().qrCodeText(qrCodeText).build()));
  }
}
