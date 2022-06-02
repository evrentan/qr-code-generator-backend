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
   * QR Code Text in String Type
   *
   * @since 1.0.0
   */
  @Schema(description = "QR Code Text in String Type")
  @NotNull
  private String qrCodeText;

  /**
   * QR Code Size in Integer Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "QR Code Size in Integer Type")
  private Integer size;

  /**
   * QR Code BackGround Color in String Type.
   *
   * @since 1.0.0
   */
  @Schema(description = "QR Code BackGround Color in String Type")
  private String backGroundColor;
}
