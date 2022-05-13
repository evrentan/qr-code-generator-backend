package evrentan.qrcodegenerator.qrcodegeneratorbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * GenerateQrCodeRequest Class.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Generate QR Code Request")
public class GenerateQrCodeRequest {

  /**
   * Barcode Text in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "Barcode Text in String Type")
  @NotNull
  private String barcodeText;

  /**
   * Barcode Size in Integer Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Barcode Size in Integer Type")
  private Integer size;

  /**
   * Barcode BackGround Color in String Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "Barcode BackGround Color in String Type")
  private String backGroundColor;
}
