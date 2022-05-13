package evrentan.qrcodegenerator.qrcodegeneratorbackend.service;

import evrentan.qrcodegenerator.qrcodegeneratorbackend.dto.GenerateQrCodeRequest;

/**
 * QrCode Service Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface QrCodeService {

  /**
   * Generate QR Code according to the given request.
   *
   * @param qrCodeGenerateRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   * @return String which corresponds to generated QR Code in base64 String.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  String generateQrCodeString(GenerateQrCodeRequest qrCodeGenerateRequest);

  /**
   * Generate QR Code according to the given request.
   *
   * @param qrCodeGenerateRequest object that is used to generate QR Code. Please, see the {@link GenerateQrCodeRequest} class for details.
   * @return byte[] which corresponds to generated QR Code.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  byte[] generateQrCodeByteArray(GenerateQrCodeRequest qrCodeGenerateRequest);
}
